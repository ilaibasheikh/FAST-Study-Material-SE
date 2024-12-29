package CollectionRemainingExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpiliteratorExpertExample {
    public static void main(String[] args) {
        // Create a list of integers from 1 to 1,000,000
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            numbers.add(i);
        }

        // Convert the list into a parallel stream
        Stream<Integer> parallelStream = numbers.parallelStream();

        // Create a custom Spliterator to split the stream
        Spliterator<Integer> customSpliterator = new CustomSpliterator<>(parallelStream.spliterator());

        // Create a new stream from the custom Spliterator
        Stream<Integer> customStream = StreamSupport.stream(customSpliterator, true);

        // Perform some operations on the custom stream in parallel
        List<Integer> result = customStream
                .map(x -> x * 2)        // Double each element
                .filter(x -> x % 3 == 0) // Filter elements divisible by 3
                .collect(Collectors.toList());

        // Display the result
        System.out.println("Result size: " + result.size());
    }

    // Custom Spliterator that splits the stream in chunks
    static class CustomSpliterator<T> implements Spliterator<T> {
        private final Spliterator<T> sourceSpliterator;

        public CustomSpliterator(Spliterator<T> sourceSpliterator) {
            this.sourceSpliterator = sourceSpliterator;
        }

        @Override
        public boolean tryAdvance(java.util.function.Consumer<? super T> action) {
            return sourceSpliterator.tryAdvance(action);
        }

        @Override
        public Spliterator<T> trySplit() {
            // Split the source Spliterator and create a new CustomSpliterator
            Spliterator<T> split = this.sourceSpliterator.trySplit();
            if (split != null) {
                return new CustomSpliterator<>(split);
            } else {
                return null; // No more splitting possible
            }
        }

        @Override
        public long estimateSize() {
            return sourceSpliterator.estimateSize();
        }

        @Override
        public int characteristics() {
            return sourceSpliterator.characteristics();
        }
    }
}

