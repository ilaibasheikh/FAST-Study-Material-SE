import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Step 1: Create a Learner class
class Learner {
    private String name;
    private int rollNumber;

    public Learner(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Learner [name=" + name + ", rollNumber=" + rollNumber + "]";
    }
}

public class MainforArraylist {
    public static void main(String[] args) {
        // Step 2: Create an ArrayList of Learner instances
        List<Learner> learnerList = new ArrayList<>();

        // Step 3: Add, retrieve, update, and remove elements
        // Add learners to the ArrayList
        learnerList.add(new Learner("Alice", 101));
        learnerList.add(new Learner("Bob", 102));
        learnerList.add(new Learner("Charlie", 103));

        // Retrieve elements
        Learner learner1 = learnerList.get(0);
        System.out.println("Retrieved learner: " + learner1);

        // Update an element
        Learner updatedLearner = new Learner("Eve", 101);
        learnerList.set(0, updatedLearner);
        System.out.println("Updated learner: " + learnerList.get(0));

        // Remove an element
        learnerList.remove(1);
        System.out.println("After removing Bob: " + learnerList);

        // Step 4: Iterate through the ArrayList
        System.out.println("Iterating through the list:");
        for (Learner learner : learnerList) {
            System.out.println(learner);
        }

        // Using an Iterator
        System.out.println("Iterating through the list using an Iterator:");
        Iterator<Learner> iterator = learnerList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
