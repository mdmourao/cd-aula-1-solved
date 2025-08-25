package com.university.cd.aula1.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello/{name}")
    public String greet(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot with Java 23! 🚀";
    }

    @PostMapping("/echo")
    public String echo(@RequestBody Map<String, String> body) {
        return "You said: " + body.get("message");
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam String name,
                           @RequestParam(defaultValue = "en") String lang) {
        return "Hi " + name + " (lang: " + lang + ")";
    }

    /*
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return user; // echoes back the created user
    }
    */
}