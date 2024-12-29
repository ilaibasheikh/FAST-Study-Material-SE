import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedListExample {
    public static void main(String[] args) {
        // Step 1: Create a LinkedList of Strings
        LinkedList<String> linkedList = new LinkedList<>();

        // Step 2: Add elements to the LinkedList
        linkedList.add("Alice");
        linkedList.add("Bob");
        linkedList.add("Charlie");
        linkedList.add("David");

        System.out.println("Original LinkedList: " + linkedList);

        // Step 3: Add elements at specific positions
        linkedList.addFirst("Eve");  // Add at the beginning
        linkedList.addLast("Frank");  // Add at the end
        linkedList.add(3, "Grace");  // Add at a specific index

        System.out.println("After adding elements: " + linkedList);

        // Step 4: Remove elements
        linkedList.removeFirst();  // Remove the first element
        linkedList.removeLast();   // Remove the last element
        linkedList.remove(2);      // Remove the element at index 2

        System.out.println("After removing elements: " + linkedList);

        // Step 5: Retrieve elements
        String firstElement = linkedList.getFirst();
        String lastElement = linkedList.getLast();
        String elementAtIndex = linkedList.get(1);

        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);
        System.out.println("Element at Index 1: " + elementAtIndex);

        // Step 6: Iterate through the LinkedList
        System.out.println("Iterating through the LinkedList:");
        for (String element : linkedList) {
            System.out.println(element);
        }

        // Using an Iterator
        System.out.println("Iterating through the LinkedList using an Iterator:");
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Using a ListIterator
        System.out.println("Iterating through the LinkedList using a ListIterator (in reverse):");
        ListIterator<String> listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // Step 7: Check if the LinkedList is empty
        boolean isEmpty = linkedList.isEmpty();
        System.out.println("Is the LinkedList empty? " + isEmpty);

        // Step 8: Get the size of the LinkedList
        int size = linkedList.size();
        System.out.println("Size of the LinkedList: " + size);
    }
}
