import random
import numpy as np


task_times = [5, 8, 4, 7, 6, 3, 9]
facility_capacities = [24, 30, 28]
cost_matrix = [
    [10, 12, 9],
    [15, 14, 16],
    [8, 9, 7],
    [12, 10, 13],
    [14, 13, 12],
    [9, 8, 10],
    [11, 12, 13]
]


POP_SIZE = 6
CROSSOVER_RATE = 0.8
MUTATION_RATE = 0.2
NUM_TASKS = len(task_times)
NUM_GENERATIONS = 3


def init_population():
    return [random.choices([0, 1, 2], k=NUM_TASKS) for _ in range(POP_SIZE)]


def evaluate_fitness(chromosome):
    facility_loads = [0] * 3
    total_cost = 0

    for task, facility in enumerate(chromosome):
        time = task_times[task]
        cost = cost_matrix[task][facility]
        facility_loads[facility] += time
        total_cost += cost * time

    penalty = 1000 * sum(
        max(0, facility_loads[i] - facility_capacities[i]) for i in range(3)
    )
    
    return total_cost + penalty


def roulette_wheel_selection(population, fitnesses):
    inverse_fitness = [1 / f for f in fitnesses]
    total_inv_fit = sum(inverse_fitness)
    probabilities = [f / total_inv_fit for f in inverse_fitness]
    return random.choices(population, weights=probabilities, k=POP_SIZE)


def one_point_crossover(parent1, parent2):
    if random.random() > CROSSOVER_RATE:
        return parent1[:], parent2[:]
    point = random.randint(1, NUM_TASKS - 2)
    return parent1[:point] + parent2[point:], parent2[:point] + parent1[point:]


def mutate(chromosome):
    if random.random() < MUTATION_RATE:
        idx1, idx2 = random.sample(range(NUM_TASKS), 2)
        chromosome[idx1], chromosome[idx2] = chromosome[idx2], chromosome[idx1]
    return chromosome


def run_generation(population):
    fitnesses = [evaluate_fitness(ch) for ch in population]
    selected = roulette_wheel_selection(population, fitnesses)
    next_gen = []
    for i in range(0, POP_SIZE, 2):
        parent1, parent2 = selected[i], selected[i+1]
        child1, child2 = one_point_crossover(parent1, parent2)
        next_gen.append(mutate(child1))
        next_gen.append(mutate(child2))
    return next_gen, fitnesses


population = init_population()
best_solution = None
best_fitness = float('inf')

for gen in range(NUM_GENERATIONS):
    population, fitnesses = run_generation(population)
    gen_best = min(fitnesses)
    if gen_best < best_fitness:
        best_fitness = gen_best
        best_solution = population[fitnesses.index(gen_best)]
    print(f"Generation {gen+1}: Best Fitness = {gen_best}")


print("\n🏆 Best Solution Found:")
print("Chromosome (facility assignments):", best_solution)
print("Total Cost (with penalties if any):", best_fitness)
