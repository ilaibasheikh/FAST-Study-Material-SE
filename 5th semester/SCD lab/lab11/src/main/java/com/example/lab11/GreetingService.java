package com.example.lab11;

import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.Locale;

@Service
public class GreetingService {

    public String getGreetingMessage(String name, String language) {
        String greeting;

        // Determine greeting based on time of day
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isBefore(LocalTime.NOON)) {
            greeting = "Good morning";
        } else if (currentTime.isBefore(LocalTime.of(17, 0))) {
            greeting = "Good afternoon";
        } else {
            greeting = "Good evening";
        }

        // Customize greeting based on language
        switch (language.toLowerCase()) {
            case "french":
                greeting = greeting.replace("Good", "Bonjour");
                break;
            case "spanish":
                greeting = greeting.replace("Good", "Buenos");
                break;
            case "english":
                // Default to English
                break;
            default:
                throw new UnsupportedOperationException("Language not supported: " + language);
        }

        return String.format("%s, %s!", greeting, name);
    }
}
