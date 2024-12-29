package com.example.lab11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task1")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {

        this.greetingService = greetingService;
    }

    @GetMapping("/{name}")
    public String greetUser(@PathVariable String name, @RequestParam(defaultValue = "english") String language) {
        try {
            return greetingService.getGreetingMessage(name, language);
        } catch (UnsupportedOperationException e) {
            return (e.getMessage());
        }
    }

}
