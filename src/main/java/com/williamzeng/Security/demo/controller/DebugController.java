package com.williamzeng.Security.demo.controller;

import com.williamzeng.Security.demo.service.DebugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class DebugController {

    @Autowired
    private DebugService debugService;

    @GetMapping("/debug")
    public String debug() {
        Double number = 123 / 10.0;

        List<String> nameList = debugService.getAllNames();
        
        return "Finish debug";
    }
}








