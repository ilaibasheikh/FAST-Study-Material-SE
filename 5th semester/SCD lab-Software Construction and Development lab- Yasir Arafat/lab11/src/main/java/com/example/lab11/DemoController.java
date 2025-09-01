package com.example.lab11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Demonstrating @RequestParam
    @GetMapping("/welcome")
    public String greet(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Demonstrating @PathVariable
    @GetMapping("/welcome/{name}")
    public String greetByPathVariable(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // Demonstrating both @RequestParam and @PathVariable together
    @GetMapping("/welcome/{name}/age")
    public String greetWithAge(@PathVariable String name, @RequestParam int age) {
        return "Hello, " + name + "! You are " + age + " years old.";
    }
}
