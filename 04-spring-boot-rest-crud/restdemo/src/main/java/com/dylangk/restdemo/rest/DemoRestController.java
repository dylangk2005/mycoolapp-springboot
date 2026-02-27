package com.dylangk.restdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {
    // add code for ther "/hello endpoint"
    @GetMapping("/hello")
    public String sayhello() {
        return "Hello World!";
    }
}
