import time

def read_puzzles_from_file(filename):
    with open(filename, 'r') as file:
        puzzles = [line.strip() for line in file.readlines() if line.strip()]
    return puzzles

subtract_set = {1, 2, 3, 4, 5, 6, 7, 8, 9}

def check_horizontal(i, j, container):
    return subtract_set - set(container[i])

def check_vertical(i, j, container):
    ret_set = [container[x][j] for x in range(9)]
    return subtract_set - set(ret_set)

def check_square(i, j, container):
    first = [0, 1, 2]
    second = [3, 4, 5]
    third = [6, 7, 8]
    find_square = [first, second, third]
    for l in find_square:
        if i in l:
            row = l
        if j in l:
            col = l
    ret_set = [container[x][y] for x in row for y in col]
    return subtract_set - set(ret_set)

def get_poss_vals(i, j, container):
    return list(check_square(i, j, container).intersection(
        check_horizontal(i, j, container)).intersection(
        check_vertical(i, j, container)))

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
    if container[i][j] == 0:
        poss_vals = get_poss_vals(i, j, container)

        row_poss = []
        for y in range(9):
            if y == j:
                continue
            if container[i][y] == 0:
                row_poss.extend(get_poss_vals(i, y, container))
        if len(set(poss_vals) - set(row_poss)) == 1:
            container[i][j] = list(set(poss_vals) - set(row_poss))[0]

        col_poss = []
        for x in range(9):
            if x == i:
                continue
            if container[x][j] == 0:
                col_poss.extend(get_poss_vals(x, j, container))
        if len(set(poss_vals) - set(col_poss)) == 1:
            container[i][j] = list(set(poss_vals) - set(col_poss))[0]

        first = [0, 1, 2]
        second = [3, 4, 5]
        third = [6, 7, 8]
        find_square = [first, second, third]
        for l in find_square:
            if i in l:
                row = l
            if j in l:
                col = l

        square_poss = []
        for x in row:
            for y in col:
                if container[x][y] == 0:
                    square_poss.extend(get_poss_vals(x, y, container))
        if len(set(poss_vals) - set(square_poss)) == 1:
            container[i][j] = list(set(poss_vals) - set(square_poss))[0]

    return container

def string_to_board(puzzle_str):
    return [[int(puzzle_str[i * 9 + j]) for j in range(9)] for i in range(9)]

start_time = time.time()
puzzles = read_puzzles_from_file('sudoku_puzzles.txt')

for idx, puzzle_str in enumerate(puzzles):
    container = string_to_board(puzzle_str)
    solving = True
    while solving:
        container, stump_count = explicit_solver(container)
        zero_count = sum(1 for row in container for val in row if val == 0)
        if zero_count == 0:
            solution = ''.join(str(container[i][j]) for i in range(9) for j in range(9))
            print(f"Solution for puzzle {idx + 1}: {solution}")
            solving = False
        if stump_count > 0:
            for i in range(9):
                for j in range(9):
                    container = implicit_solver(i, j, container)

end_time = time.time()
print(f"\nTotal time taken to solve all puzzles with GitHub Code: {end_time - start_time:.4f} seconds")
