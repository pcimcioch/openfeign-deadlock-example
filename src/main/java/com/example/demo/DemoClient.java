package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="demo", url = "localhost:8081")
interface DemoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/values/{id}")
    Value getValue(@PathVariable String id);

    record Value(String value) {}
}
