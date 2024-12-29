package com.example.lab11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestExample {
    @GetMapping("/Load")
    public String sayHello() {
        return "Working Of Restfull Annotations";
    }
}
