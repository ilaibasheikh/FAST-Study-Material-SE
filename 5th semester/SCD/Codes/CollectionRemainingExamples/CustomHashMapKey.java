package CollectionRemainingExamples;

import java.util.HashMap;

class CustomHashMap<K, V> extends HashMap<K, V> {
    @Override
    public V put(K key, V value) {
        // Customize the key before adding it to the map
        K modifiedKey = customizeKey(key);
        return super.put(modifiedKey, value);
    }

    // Custom key modification logic
    private K customizeKey(K key) {
        // Add your custom logic here to modify the key
        // For example, you can prefix the key with "custom_"
        if (key instanceof String) {
            return (K)("custom_" + key);
        }
        return key;
    }
}

public class CustomHashMapKey {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> customMap = new CustomHashMap<>();

        customMap.put("apple", 10);
        customMap.put("banana", 5);
        customMap.put("cherry", 8);

        // Retrieve values using customized keys
        System.out.println(customMap.get("custom_apple"));  // Output: 10
        System.out.println(customMap.get("custom_banana")); // Output: 5
        System.out.println(customMap.get("custom_cherry")); // Output: 8
    }
}

