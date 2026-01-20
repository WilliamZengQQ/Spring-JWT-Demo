package com.williamzeng.Security.demo.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class MyController {

    private final static Logger logger = LoggerFactory.getLogger(MyController.class);
    @GetMapping("/welcome")
    public String welcome(Authentication authentication){

        String username = authentication.getName();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        

        return "Welcome~"+username+"權限為"+authorities;
    }
    
}
