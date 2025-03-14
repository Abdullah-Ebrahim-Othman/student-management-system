package com.example.studentcrud.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // ✅ Proper way to disable CSRF in Spring Security 6.1+
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // ✅ Allow all requests (no authentication)
                )
                .httpBasic(basic -> basic.disable()); // ✅ Disable Basic Auth

        return http.build();
    }
}
