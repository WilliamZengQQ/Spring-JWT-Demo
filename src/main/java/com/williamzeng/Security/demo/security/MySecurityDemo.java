package com.williamzeng.Security.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableSpringDataWebSupport //InMemory固定使用的annotation
public class MySecurityDemo {

    @Bean
    public PasswordEncoder passwordEncode(){

        // return NoOpPasswordEncoder.getInstance();
        

        return  new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{

        return http
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())

                .authorizeHttpRequests(request -> request
                        .requestMatchers( "/register").permitAll()
                        .requestMatchers("/hello").authenticated() //Role角色
                        .requestMatchers("/welcome").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )

                .build();
    }
    
    /*
    *以下寫法為InMemory固定寫法，為了進行(寫死)測試使用
    */
    // @Bean 
    // public InMemoryUserDetailsManager userDetailsManager(){
    //     UserDetails userTest1 = User
    //                             .withUsername("test1")
    //                             .password("{noop}111") //{noop}為前綴用途為指定要哪一種加密技術
    //                             .roles("ADMIN","USER") //權限角色
    //                             .build();

    //     UserDetails userTest2 = User
    //                             .withUsername("test2")
    //                             .password("{noop}222")
    //                             .roles("USER")
    //                             .build();
        
    //     return new InMemoryUserDetailsManager(userTest1,userTest2);
    // }
    
}
