
import java.util.*;

public class SetExamplehashtreelinked {
    public static void main(String[] args) {
        // HashSet - An unordered collection with no duplicate elements.
        Set<String> hashSet = new HashSet<>();

        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("x");
        hashSet.add("n");
        hashSet.add("y");
        hashSet.add("SCD");
        hashSet.add("DSA");
        hashSet.add("Cherry");
        hashSet.add("Banana"); // Duplicate, won't be added

        System.out.println("HashSet: " + hashSet);

        // LinkedHashSet - Maintains the order of elements in which they were inserted.
        Set<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        linkedHashSet.add("Banana"); // Duplicate, won't be added

        System.out.println("LinkedHashSet: " + linkedHashSet);

        // TreeSet - Sorted set where elements are ordered.
        Set<String> treeSet = new TreeSet<>();

        treeSet.add("Apple");
        
        treeSet.add("Cherry");
        treeSet.add("Banana");
        treeSet.add("Banana"); // Duplicate, won't be added

        System.out.println("TreeSet: " + treeSet);

        // Common Set operations
        System.out.println("HashSet contains 'Banana': " + hashSet.contains("Banana"));
        System.out.println("LinkedHashSet contains 'Banana': " + linkedHashSet.contains("Banana"));
        System.out.println("TreeSet contains 'Banana': " + treeSet.contains("Banana"));

        // Iterate over a Set
        System.out.print("HashSet elements: ");
        for (String fruit : hashSet) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // Remove an element
        hashSet.remove("Banana");
        System.out.println("HashSet after removing 'Banana': " + hashSet);

        // Size of the Set
        System.out.println("Size of LinkedHashSet: " + linkedHashSet.size());

        // Clear a Set
        treeSet.clear();
        System.out.println("TreeSet after clearing: " + treeSet);
    }
}
