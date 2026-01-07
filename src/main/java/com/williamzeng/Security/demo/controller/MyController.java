package com.williamzeng.Security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome~";
    }
    
}
