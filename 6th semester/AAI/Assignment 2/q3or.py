from ortools.sat.python import cp_model
import time

def solve_sudoku_with_ortools(puzzle):
    model = cp_model.CpModel()

    grid = [[model.NewIntVar(1, 9, f'cell_{i}_{j}') for j in range(9)] for i in range(9)]

    for i in range(9):
        model.AddAllDifferent(grid[i])
        model.AddAllDifferent([grid[j][i] for j in range(9)])

    for i in range(3):
        for j in range(3):
            block = [grid[i*3 + di][j*3 + dj] for di in range(3) for dj in range(3)]
            model.AddAllDifferent(block)

    for i in range(9):
        for j in range(9):
            if puzzle[i * 9 + j] != '0':
                model.Add(grid[i][j] == int(puzzle[i * 9 + j]))

    solver = cp_model.CpSolver()
    status = solver.Solve(model)

    if status == cp_model.OPTIMAL or status == cp_model.FEASIBLE:
        solution = ''.join(str(solver.Value(grid[i][j])) for i in range(9) for j in range(9))
        return solution
    return None

def read_puzzles_from_file(filename):
    with open(filename, 'r') as file:
        return [line.strip() for line in file]

def main():
    puzzles = read_puzzles_from_file("sudoku_puzzles.txt")
    start_time = time.time()

    for idx, puzzle in enumerate(puzzles):
       
        solution = solve_sudoku_with_ortools(puzzle)
        if solution:
            print(f"Solution for puzzle {idx + 1}: {solution}")
        else:
            print(f"Puzzle {idx + 1} could not be solved.")

    end_time = time.time()
    print(f"\nTotal time taken to solve all puzzles with OR-Tools: {end_time - start_time:.4f} seconds")

if __name__ == "__main__":
    main()
