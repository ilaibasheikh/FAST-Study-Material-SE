package com.example.lab11;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public String greet() {
        return "Hello from MyService!";
    }
}