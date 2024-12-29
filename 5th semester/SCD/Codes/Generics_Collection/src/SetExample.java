import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // Step 1: Create a HashSet of Strings
        Set<String> stringSet = new HashSet<>();

        // Step 2: Add elements to the Set
        stringSet.add("Apple");
        stringSet.add("Banana");
        stringSet.add("Cherry");
        stringSet.add("Date");

        System.out.println("Original Set: " + stringSet);

        // Step 3: Adding duplicate elements (ignored in a Set)
        stringSet.add("Apple");
        stringSet.add("Banana");

        System.out.println("After adding duplicates: " + stringSet);

        // Step 4: Remove an element from the Set
        stringSet.remove("Cherry");

        System.out.println("After removing Cherry: " + stringSet);

        // Step 5: Check if an element is present in the Set
        boolean containsBanana = stringSet.contains("Banana");
        System.out.println("Contains Banana: " + containsBanana);

        // Step 6: Iterate through the Set
        System.out.println("Iterating through the Set:");
        for (String fruit : stringSet) {
            System.out.println(fruit);
        }

        // Using an Iterator
        System.out.println("Iterating through the Set using an Iterator:");
        Iterator<String> iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Step 7: Check if the Set is empty
        boolean isEmpty = stringSet.isEmpty();
        System.out.println("Is the Set empty? " + isEmpty);

        // Step 8: Get the size of the Set
        int size = stringSet.size();
        System.out.println("Size of the Set: " + size);

        // Step 9: Clear the Set
        stringSet.clear();
        System.out.println("Cleared Set: " + stringSet);
    }
}
