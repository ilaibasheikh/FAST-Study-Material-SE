package fileHandlingandStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;


public class StreamDetailed {
    public static void main(String[] args) {
        // Stream from Collection
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        System.out.println("Stream from Collection: " + streamOfCollection.collect(Collectors.toList()));

        // Stream from Array
        Stream<String> streamOfArray = Stream.of("a", "b", "c");
        System.out.println("Stream from Array: " + streamOfArray.collect(Collectors.toList()));

        // Stream from an existing array
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        System.out.println("Stream from existing array (Full): " + streamOfArrayFull.collect(Collectors.toList()));
        System.out.println("Stream from existing array (Part): " + streamOfArrayPart.collect(Collectors.toList()));

        // Stream.builder()
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();
        System.out.println("Stream from Stream.builder(): " + streamBuilder.collect(Collectors.toList()));

        // Stream.generate()
        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);
        System.out.println("Stream generated using Stream.generate(): " + streamGenerated.collect(Collectors.toList()));

        // Stream.iterate()
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        System.out.println("Stream generated using Stream.iterate(): " + streamIterated.collect(Collectors.toList()));

        // Stream of Primitives
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        System.out.println("IntStream: " + intStream.boxed().collect(Collectors.toList()));
        System.out.println("LongStream: " + longStream.boxed().collect(Collectors.toList()));

        // Stream from File
        try {
            // Specify the file path
            Path path = Paths.get("sample.txt");
            // Read lines from the file into a stream
            Stream<String> streamFromFile = Files.lines(path);
            System.out.println("Stream from File: " + streamFromFile.collect(Collectors.toList()));
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        // Parallel Streams
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long count = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Count of even numbers in parallel: " + count);

        // Stream Reduction using reduce()
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = integers.stream().reduce((x, y) -> x + y);
        System.out.println("Sum of integers using reduce(): " + sum.orElse(0));

        // Stream Reduction using collect()
        List<String> words = Arrays.asList("Hello", "Stream", "API");
        String concatenated = words.stream().collect(Collectors.joining(" "));
        System.out.println("Concatenated string using collect(): " + concatenated);
    }
}
