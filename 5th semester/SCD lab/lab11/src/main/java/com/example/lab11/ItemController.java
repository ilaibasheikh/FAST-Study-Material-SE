package com.example.lab11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository itemRepository = new ItemRepository();

    // Create a new item
    @PostMapping
    public String createItem(@RequestParam String name, @RequestParam Double price, Model model) {
        Item newItem = new Item(null, name, price);
        Item createdItem = itemRepository.save(newItem);
        model.addAttribute("item", createdItem);
        return "redirect:/items"; // Redirect to the list of items
    }

    // Update an existing item
    @PostMapping("/{id}")
    public String updateItem(@PathVariable Long id, @RequestParam String name, @RequestParam Double price, Model model) {
        Item existingItem = itemRepository.findById(id);
        if (existingItem != null) {
            existingItem.setName(name);
            existingItem.setPrice(price);
            itemRepository.save(existingItem);
        }
        return "redirect:/items"; // Redirect to the list of items
    }

    // Delete an item
    @PostMapping("/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        itemRepository.delete(id);
        return "redirect:/items"; // Redirect to the list of items
    }

    // View all items
    @GetMapping
    public String getAllItems(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "items/list"; // View the list of items
    }
}
