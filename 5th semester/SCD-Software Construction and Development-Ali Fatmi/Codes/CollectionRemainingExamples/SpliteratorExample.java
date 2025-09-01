package CollectionRemainingExamples;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        // Get a Spliterator for the list
        Spliterator<Integer> spliterator = numbers.spliterator();

        // Perform some operations using the Spliterator
        while (spliterator.tryAdvance((Integer num) -> {
            System.out.println("Processing number: " + num);
        })) ;

        // You can also use parallelStream() with a Spliterator
        Spliterator<Integer> parallelSpliterator = numbers.spliterator();
        parallelSpliterator.forEachRemaining((Integer num) -> {
            System.out.println("Parallel Processing number: " + num);
        });
    }
}
