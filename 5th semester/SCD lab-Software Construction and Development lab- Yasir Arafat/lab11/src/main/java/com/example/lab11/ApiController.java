package com.example.lab11;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/api")
public class ApiController {

    // Handle GET request to /api (this should load the form)
    @GetMapping("")
    public String showApiHome() {
        return "form";  // Return the form view directly for /api
    }

    // Render the HTML form
    @GetMapping("/form")
    public String showForm() {
        return "form";  // Render the form view for /api/form
    }

    // Handle GET request from form submission
    @GetMapping("/submit")
    public String handleGetRequest(@RequestParam String name, Model model) {
        model.addAttribute("message", "Hello, " + name);
        return "response";  // Return the response view after GET submission
    }

    // Handle POST request from form submission
    @PostMapping("/submit")
    public String handlePostRequest(@RequestParam String data, Model model) {
        model.addAttribute("message", "Data received: " + data);
        return "response";  // Return the response view after POST submission
    }
}
