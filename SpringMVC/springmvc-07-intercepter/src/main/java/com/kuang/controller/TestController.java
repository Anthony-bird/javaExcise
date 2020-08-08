package com.kuang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/t1")
    public String test() {
        System.out.println("testController执行力");
        return "OK";
    }
}
