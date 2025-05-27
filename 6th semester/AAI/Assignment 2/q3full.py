import time
from collections import deque
from ortools.sat.python import cp_model

# ========== SHARED: Load Puzzles ==========
def read_puzzles_from_file(filename):
    with open(filename, 'r') as file:
        return [line.strip() for line in file if line.strip()]

# ========== SOLVER 1: CSP ==========
N = 9
DOMAIN = set(range(1, 10))

def get_neighbors(i, j):
    neighbors = set()
    for k in range(N):
        neighbors.add((i, k))
        neighbors.add((k, j))
        neighbors.add((3 * (i // 3) + k // 3, 3 * (j // 3) + k % 3))
    neighbors.remove((i, j))
    return neighbors

def create_csp(puzzle):
    csp = {}
    for i in range(N):
        for j in range(N):
            idx = i * N + j
            if puzzle[idx] == '0':
                csp[(i, j)] = DOMAIN.copy()
            else:
                csp[(i, j)] = {int(puzzle[idx])}
    return csp

def initialize_queue(csp):
    queue = deque()
    for (i, j), _ in csp.items():
        for neighbor in get_neighbors(i, j):
            queue.append(((i, j), neighbor))
    return queue

def ac3(csp):
    queue = initialize_queue(csp)
    while queue:
        (i, j), (ni, nj) = queue.popleft()
        if revise(csp, i, j, ni, nj):
            if len(csp[(i, j)]) == 0:
                return False
            for neighbor in get_neighbors(i, j):
                if (neighbor, (i, j)) not in queue:
                    queue.append(((i, j), neighbor))
    return True

def revise(csp, i, j, ni, nj):
    revised = False
    for value in list(csp[(i, j)]):
        if not any(nv != value for nv in csp[(ni, nj)]):
            csp[(i, j)].remove(value)
            revised = True
    return revised

def select_unassigned_variable(csp):
    unassigned = [(var, domain) for var, domain in csp.items() if len(domain) > 1]
    return min(unassigned, key=lambda x: len(x[1]), default=None)

def is_consistent(csp, i, j, value):
    for (ni, nj) in get_neighbors(i, j):
        if value in csp[(ni, nj)] and len(csp[(ni, nj)]) == 1:
            return False
    return True

def backtrack(csp):
    unassigned = select_unassigned_variable(csp)
    if not unassigned:
        return csp
    var, domain = unassigned
    i, j = var
    for value in domain:
        if is_consistent(csp, i, j, value):
            csp_copy = csp.copy()
            csp_copy[var] = {value}
            if ac3(csp_copy):
                result = backtrack(csp_copy)
                if result:
                    return result
    return None

def solve_sudoku_csp(puzzle):
    csp = create_csp(puzzle)
    if ac3(csp):
        solution = backtrack(csp)
        if solution:
            return ''.join(str(next(iter(solution[(i, j)]))) for i in range(N) for j in range(N))
    return None

# ========== SOLVER 2: OR-TOOLS ==========
def solve_sudoku_ortools(puzzle):
    model = cp_model.CpModel()
    grid = [[model.NewIntVar(1, 9, f'cell_{i}_{j}') for j in range(9)] for i in range(9)]

    for i in range(9):
        model.AddAllDifferent(grid[i])
        model.AddAllDifferent([grid[j][i] for j in range(9)])

    for bi in range(3):
        for bj in range(3):
            block = [grid[bi * 3 + di][bj * 3 + dj] for di in range(3) for dj in range(3)]
            model.AddAllDifferent(block)

    for i in range(9):
        for j in range(9):
            if puzzle[i * 9 + j] != '0':
                model.Add(grid[i][j] == int(puzzle[i * 9 + j]))

    solver = cp_model.CpSolver()
    status = solver.Solve(model)

    if status in (cp_model.OPTIMAL, cp_model.FEASIBLE):
        return ''.join(str(solver.Value(grid[i][j])) for i in range(9) for j in range(9))
    return None

# ========== SOLVER 3: GIT ==========
subtract_set = {1, 2, 3, 4, 5, 6, 7, 8, 9}

def string_to_board(puzzle_str):
    return [[int(puzzle_str[i * 9 + j]) for j in range(9)] for i in range(9)]

def check_horizontal(i, j, container):
    return subtract_set - set(container[i])

def check_vertical(i, j, container):
    return subtract_set - {container[x][j] for x in range(9)}

def check_square(i, j, container):
    row_base = (i // 3) * 3
    col_base = (j // 3) * 3
    return subtract_set - {
        container[x][y]
        for x in range(row_base, row_base + 3)
        for y in range(col_base, col_base + 3)
    }

def get_poss_vals(i, j, container):
    return list(
        check_square(i, j, container)
        .intersection(check_horizontal(i, j, container))
        .intersection(check_vertical(i, j, container))
    )

def explicit_solver(container):
    stump_count = 1
    for i in range(9):
        for j in range(9):
            if container[i][j] == 0:
                poss_vals = get_poss_vals(i, j, container)
                if len(poss_vals) == 1:
                    container[i][j] = poss_vals[0]
                    stump_count = 0
    return container, stump_count

def implicit_solver(i, j, container):
    if container[i][j] != 0:
        return container

    poss_vals = get_poss_vals(i, j, container)
    row_poss = [val for y in range(9) if y != j and container[i][y] == 0 for val in get_poss_vals(i, y, container)]
    if len(set(poss_vals) - set(row_poss)) == 1:
        container[i][j] = list(set(poss_vals) - set(row_poss))[0]

    col_poss = [val for x in range(9) if x != i and container[x][j] == 0 for val in get_poss_vals(x, j, container)]
    if len(set(poss_vals) - set(col_poss)) == 1:
        container[i][j] = list(set(poss_vals) - set(col_poss))[0]

    square_poss = []
    row_base = (i // 3) * 3
    col_base = (j // 3) * 3
    for x in range(row_base, row_base + 3):
        for y in range(col_base, col_base + 3):
            if container[x][y] == 0:
                square_poss.extend(get_poss_vals(x, y, container))
    if len(set(poss_vals) - set(square_poss)) == 1:
        container[i][j] = list(set(poss_vals) - set(square_poss))[0]

    return container

def solve_sudoku_git(puzzle_str):
    container = string_to_board(puzzle_str)
    while True:
        container, stump_count = explicit_solver(container)
        if all(val != 0 for row in container for val in row):
            return ''.join(str(container[i][j]) for i in range(9) for j in range(9))
        if stump_count > 0:
            for i in range(9):
                for j in range(9):
                    container = implicit_solver(i, j, container)

# ========== MAIN EXECUTION ==========
def main():
    puzzles = read_puzzles_from_file("sudoku_puzzles.txt")
    total_time = {"CSP": 0.0, "OR-Tools": 0.0, "GIT": 0.0}

    for idx, puzzle in enumerate(puzzles):
        print(f"\n Solving Puzzle {idx + 1}:")

        # CSP
        start = time.perf_counter()
        result_csp = solve_sudoku_csp(puzzle)
        duration = time.perf_counter() - start
        total_time["CSP"] += duration
        print(f"  CSP       : {result_csp or 'Unsolved'} (Time: {duration:.6f}s)")

        # OR-Tools
        start = time.perf_counter()
        result_ortools = solve_sudoku_ortools(puzzle)
        duration = time.perf_counter() - start
        total_time["OR-Tools"] += duration
        print(f"  OR-Tools  : {result_ortools or 'Unsolved'} (Time: {duration:.6f}s)")

        # GIT
        start = time.perf_counter()
        result_git = solve_sudoku_git(puzzle)
        duration = time.perf_counter() - start
        total_time["GIT"] += duration
        print(f"  GIT       : {result_git or 'Unsolved'} (Time: {duration:.6f}s)")

    print("\n================== ⏱ Time Comparison ==================")
    for method, t in total_time.items():
        print(f"Total time by {method:9}: {t:.6f} seconds")
    fastest = min(total_time, key=total_time.get)
    print(f"\n Fastest overall: {fastest}")

if __name__ == "__main__":
    main()
