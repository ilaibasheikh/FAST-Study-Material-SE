package com.example.lab11;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository {
    private Map<Long, Item> items = new HashMap<>();
    private static long idCounter = 1;

    // Create or Update an item
    public Item save(Item item) {
        if (item.getId() == null) {
            item.setId(idCounter++);
        }
        items.put(item.getId(), item);
        return item;
    }

    // Get an item by ID
    public Item findById(Long id) {
        return items.get(id);
    }

    // Get all items
    public Map<Long, Item> findAll() {
        return items;
    }

    // Delete an item by ID
    public Item delete(Long id) {
        return items.remove(id);
    }
}

