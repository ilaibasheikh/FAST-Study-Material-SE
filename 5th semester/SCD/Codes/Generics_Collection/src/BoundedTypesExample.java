// Define a generic class with a bounded type parameter
class PrintSum<T extends Number> {
    // Method to print the sum of numbers in an array
    public void print(T[] arr) {
        double sum = 0.0; // Initialize the sum

        for (T num : arr) {
            sum += num.doubleValue(); // Add the value of each number to the sum
        }

        System.out.println("Sum: " + sum);
    }
}

public class BoundedTypesExample {
    public static void main(String[] args) {
        // Create an array of integers
        Integer[] intArray = { 1, 2, 3, 4, 5 };

        // Create a PrintSum object for integers and print the sum
        PrintSum<Integer> intPrinter = new PrintSum<>();
        intPrinter.print(intArray); // Prints the sum of integers

        // Create an array of doubles
        Double[] doubleArray = { 1.5, 2.5, 3.5, 4.5, 5.5 };

        // Create a PrintSum object for doubles and print the sum
        PrintSum<Double> doublePrinter = new PrintSum<>();
        doublePrinter.print(doubleArray); // Prints the sum of doubles
        // Attempt to create an array of strings (will result in a compile-time error)
        // String[] stringArray = { "Hello", "World" };
        // PrintSum<String> stringPrinter = new PrintSum<>(); // Error: Bound mismatch

        // Attempt to create a PrintSum object for strings (will cause an error)
        // Uncomment the following lines to demonstrate the error
        // PrintSum<String> stringPrinter = new PrintSum<>();
        // stringPrinter.print(stringArray); // This line will cause a compile-time error
        System.out.println("Passing a String to PrintSum will cause a compile-time error.");
    }
}    