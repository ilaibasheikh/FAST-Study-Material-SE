package CollectionRemainingExamples;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        Map<Integer, String> hashMap = new HashMap<>();

        // Adding key-value pairs to the map
        hashMap.put(1, "Alice");
        hashMap.put(2, "Bob");
        hashMap.put(3, "Charlie");
        hashMap.put(4, "David");

        // Size of the map
        System.out.println("Size of the HashMap: " + hashMap.size());

        // Checking if a key exists
        System.out.println("Does key 2 exist? " + hashMap.containsKey(2));

        // Checking if a value exists
        System.out.println("Does value 'Eve' exist? " + hashMap.containsValue("Eve"));

        // Retrieving a value by key
        String value = hashMap.get(3);
        System.out.println("Value for key 3: " + value);

        // Creating a new map
        Map<Integer, String> anotherMap = new HashMap<>();
        anotherMap.put(5, "Eve");
        anotherMap.put(6, "Frank");

        // Copying all mappings from another map
        hashMap.putAll(anotherMap);

        // Removing a key-value pair
        hashMap.remove(4);

        // Checking if the map is empty
        System.out.println("Is the map empty? " + hashMap.isEmpty());

        // Iterating through keys
        Set<Integer> keys = hashMap.keySet();
        System.out.println("Keys in the map: " + keys);

        // Iterating through values
        Collection<String> values = hashMap.values();
        System.out.println("Values in the map: " + values);

        // Iterating through key-value pairs
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Clearing the map
        hashMap.clear();

        // Checking if the map is empty after clearing
        System.out.println("Is the map empty after clearing? " + hashMap.isEmpty());
    }
}

