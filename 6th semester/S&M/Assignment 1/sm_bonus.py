import numpy as np

def simulate_virus_spread(trials=1000):
    total_days = []
    infection_counts = []
    ever_infected = np.zeros(20, dtype=int)
    
    for _ in range(trials):
        infected = set([0])  
        days = 0
        
        while infected:

            infection_counts.append(len(infected))
            
            new_infected = set(infected)
            for comp in range(20):
                if comp not in infected:
                    if np.random.rand() < (0.1 * len(infected)):
                        new_infected.add(comp)
            
            for comp in new_infected:
                ever_infected[comp] = 1
            
            infected = new_infected
            
        
            to_remove = min(len(infected), 5)
            infected = set(np.random.choice(list(infected), len(infected) - to_remove, replace=False))
            
            days += 1
        
        total_days.append(days)
    
    expected_days = np.mean(total_days)
    probability_each_infected = np.mean(ever_infected)
    expected_total_infected = np.mean(infection_counts)
    
    return expected_days, probability_each_infected, expected_total_infected

expected_days, prob_each_infected, expected_total_infected = simulate_virus_spread()
print(f"Expected days to remove virus: {expected_days:.2f}")
print(f"Probability each computer gets infected at least once: {prob_each_infected:.2f}")
print(f"Expected total infections across time: {expected_total_infected:.2f}")
