package com.example.lab11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // Predefined user list for checking existing usernames
    private List<String> registeredUsernames = new ArrayList<>(List.of("user1", "user2"));

    // GET Mapping to display the form (optional if using a static HTML page)
    @GetMapping("/task2")
    public String showForm() {
        return "task2";  // returns form.html in templates folder
    }

    // Registration endpoint
    @PostMapping("/task2register")
    @ResponseBody
    public String register(@RequestParam String username, @RequestParam String password) {
        // Check if username already exists
        if (registeredUsernames.contains(username)) {
            return "Username is already taken. Please choose a different one.";
        } else {
            registeredUsernames.add(username);
            return "Registration successful!";
        }
    }

    // Login endpoint
    @PostMapping("/task2login")
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password) {
        // Simple validation (for demonstration, usually you would verify password as well)
        if (registeredUsernames.contains(username)) {
            return "Login successful!";
        } else {
            return "Login failed. Username not found.";
        }
    }
}
