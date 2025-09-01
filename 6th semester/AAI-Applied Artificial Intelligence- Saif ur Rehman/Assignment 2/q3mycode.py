from collections import deque
import time

N = 9
DOMAIN = set(range(1, 10))

def get_n(i, j):
    n = set()
    for k in range(N):
        n.add((i, k))
        n.add((k, j))
        n.add((3 * (i // 3) + k // 3, 3 * (j // 3) + k % 3))
    n.remove((i, j))
    return n

def create_csp(puzzle):
    csp = {}
    for i in range(N):
        for j in range(N):
            if puzzle[i * N + j] == '0':
                csp[(i, j)] = DOMAIN.copy()
            else:
                csp[(i, j)] = {int(puzzle[i * N + j])}
    return csp

def initialize_q(csp):
    q = deque()
    for (i, j), domain in csp.items():
        for (ni, nj) in get_n(i, j):
            q.append(((i, j), (ni, nj)))
    return q

def ac3(csp):
    q = initialize_q(csp)
    while q:
        (i, j), (ni, nj) = q.popleft()
        if revise(csp, i, j, ni, nj):
            if len(csp[(i, j)]) == 0:
                return False
            for neighbor in get_n(i, j):
                if (neighbor, (i, j)) not in q:
                    q.append(((i, j), neighbor))
    return True

def revise(csp, i, j, ni, nj):
    revised = False
    for value in list(csp[(i, j)]):
        if not any(neighbor_value != value for neighbor_value in csp[(ni, nj)]):
            csp[(i, j)].remove(value)
            revised = True
    return revised

def select_unassigned_variable(csp):
    unassigned = [(var, domain) for var, domain in csp.items() if len(domain) > 1]
    return min(unassigned, key=lambda x: len(x[1]), default=None)

def is_consistent(csp, i, j, value):
    for (ni, nj) in get_n(i, j):
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

def solve_sudoku(puzzle):
    csp = create_csp(puzzle)
    if ac3(csp):
        solution = backtrack(csp)
        if solution:
            return ''.join(str(next(iter(solution[(i, j)]))) for i in range(N) for j in range(N))
    return None

def read_puzzles_from_file(filename):
    with open(filename, 'r') as file:
        return [line.strip() for line in file]

def main():
    puzzles = read_puzzles_from_file("sudoku_puzzles.txt")
    start_time = time.time()

    for idx, puzzle in enumerate(puzzles):
        
        solution = solve_sudoku(puzzle)
        if solution:
            print(f"Solution for puzzle {idx + 1}: {solution}")
        else:
            print(f"Puzzle {idx + 1} could not be solved.")

    end_time = time.time()
    print(f"\nTotal time taken to solve all puzzles: {end_time - start_time:.4f} seconds")

if __name__ == "__main__":
    main()
