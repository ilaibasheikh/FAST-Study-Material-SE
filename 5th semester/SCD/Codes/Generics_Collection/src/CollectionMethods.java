import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CollectionMethods {
    public static void main(String[] args) {
        // Creating a collection of integers
        Collection<Integer> numbers = new ArrayList<>();

        // 1. add(E e) - Insert an element
        numbers.add(5);
        System.out.println("After add(5): " + numbers);

        // 2. addAll(Collection<? extends E> c) - Insert a collection of elements
        Collection<Integer> moreNumbers = Arrays.asList(10, 15, 20);
        numbers.addAll(moreNumbers);
        System.out.println("After addAll([10, 15, 20]): " + numbers);

        // 3. remove(Object element) - Delete an element
        numbers.remove(10);
        System.out.println("After remove(10): " + numbers);

        // 4. removeAll(Collection<?> c) - Delete elements from another collection
        Collection<Integer> toRemove = Arrays.asList(15, 20);
        numbers.removeAll(toRemove);
        System.out.println("After removeAll([15, 20]): " + numbers);

        // 5. removeIf(Predicate<? super E> filter) - Delete elements based on a condition
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removeIf(n -> n % 2 == 0): " + numbers);

        // 6. retainAll(Collection<?> c) - Keep only elements in the specified collection
        Collection<Integer> toRetain = Arrays.asList(5, 7);
        numbers.retainAll(toRetain);
        System.out.println("After retainAll([5, 7]): " + numbers);

        // 7. size() - Get the number of elements
        int size = numbers.size();
        System.out.println("Size: " + size);

        // 8. clear() - Remove all elements
        numbers.clear();
        System.out.println("After clear(): " + numbers);

        // 9. contains(Object element) - Check if an element is in the collection
        boolean contains = numbers.contains(5);
        System.out.println("Contains 5: " + contains);

        // 10. containsAll(Collection<?> c) - Check if a collection is in the collection
        boolean containsAll = numbers.containsAll(Arrays.asList(5, 7));
        System.out.println("Contains all [5, 7]: " + containsAll);

        // 11. iterator() - Get an iterator
        Iterator<Integer> iterator = numbers.iterator();
        System.out.print("Iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 12. toArray() - Convert the collection to an array
        Object[] array = numbers.toArray();
        System.out.println("Array: " + Arrays.toString(array));

        // 13. toArray(T[] a) - Convert the collection to an array of a specified type
        Integer[] intArray = numbers.toArray(new Integer[0]);
        System.out.println("Integer Array: " + Arrays.toString(intArray));

        // 14. isEmpty() - Check if the collection is empty
        boolean isEmpty = numbers.isEmpty();
        System.out.println("Is empty: " + isEmpty);

		/*
		 * // 15. parallelStream() - Get a parallel stream Stream<Integer>
		 * parallelStream = numbers.parallelStream();
		 * System.out.println("Parallel Stream: " + parallelStream);
		 * 
		 * // 16. stream() - Get a sequential stream Stream<Integer> sequentialStream =
		 * numbers.stream(); System.out.println("Sequential Stream: " +
		 * sequentialStream);
		 * 
		 * // 17. spliterator() - Get a spliterator Spliterator<Integer> spliterator =
		 * numbers.spliterator(); System.out.println("Spliterator: " + spliterator);
		 */

        // 18. equals(Object element) - Check if two collections are equal
        boolean isEqual = numbers.equals(toRetain);
        System.out.println("Is equal to [5, 7]: " + isEqual);

		/*
		 * // 19. hashCode() - Get the hash code of the collection int hashCode =
		 * numbers.hashCode(); System.out.println("Hash Code: " + hashCode);
		 */
    }
}
