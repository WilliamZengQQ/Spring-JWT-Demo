package com.williamzeng.Security.demo.security;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyFilter1 implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        System.out.println("執行 MyFilter1");

        // 把 request 和 response 傳下去，交給下一個 Filter 繼續處理
        chain.doFilter(request, response);
    }

    
}
