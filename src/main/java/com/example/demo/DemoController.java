package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final String data;

    public DemoController(String data) {
        this.data = data;
    }

    @GetMapping("/demo")
    public String demo() {
        return data;
    }
}
