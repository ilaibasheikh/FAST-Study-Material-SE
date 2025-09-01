package CollectionRemainingExamples;

import java.util.*;

public class MapValue {
    public static void main(String[] args) {
        // Creating a HashMap
        Map<Integer, String> hashMap = new HashMap<>();

        // Adding key-value pairs to the map
        hashMap.put(1, "Alice");
        hashMap.put(2, "Bob");
        hashMap.put(3, "Charlie");
        hashMap.put(4, "David");

        // Printing keys
        System.out.println("Keys in the HashMap:");
        for (Integer key : hashMap.keySet()) {
            System.out.println(key);
        }

        // Printing values
        System.out.println("\nValues in the HashMap:");
        for (String value : hashMap.values()) {
            System.out.println(value);
        }
        
        // Printing hash addresses of keys
        System.out.println("Hash addresses of keys in the HashMap:");
        for (Integer key : hashMap.keySet()) {
            int hashAddress = System.identityHashCode(key);
            System.out.println("Key: " + key + ", Hash Address: " + hashAddress);
        }
        
    }
}
