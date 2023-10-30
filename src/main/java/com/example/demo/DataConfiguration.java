package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.util.stream.Collectors.joining;

@Configuration
class DataConfiguration {

    private static final List<String> ids = List.of("id1", "id2");

    private final DemoClient client;

    DataConfiguration(DemoClient client) {
        this.client = client;
    }

    @Bean
    String data() {
        // Change to 'ids.stream()' to work
        return ids.parallelStream()
                .map(this::getValue)
                .collect(joining());
    }

    private String getValue(String id) {
        System.out.println("Getting value for id " + id);
        String value = client.getValue(id).value();
        System.out.println("Got value for id " + id);

        return value;
    }
}
