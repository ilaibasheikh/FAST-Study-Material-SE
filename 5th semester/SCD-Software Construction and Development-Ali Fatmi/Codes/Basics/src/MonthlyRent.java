
public class MonthlyRent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double baseRent = 15000.0; // Rent for 3 persons
        double extraPerPerson = 5000.0; // Extra rent per person

        double[] rentForPersons = new double[11]; // Array to store rent for each number of persons

        for (int numberOfPersons = 1; numberOfPersons <= 10; numberOfPersons++) {
            double rent = baseRent + (Math.max(numberOfPersons - 3, 0) * extraPerPerson);
            rentForPersons[numberOfPersons] = rent;
        }

        // Print the rent for each number of persons
        for (int numberOfPersons = 1; numberOfPersons <= 10; numberOfPersons++) {
            System.out.println("Rent for " + numberOfPersons + " persons: $" + rentForPersons[numberOfPersons]);
        }

	}

}
