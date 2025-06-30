package com.security.app.config;

import java.beans.Customizer;

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
            .authorizeHttpRequests( auth -> auth
                .requestMatchers("/auth/admin").hasRole("ROLE_ADMIN")
                .requestMatchers("/auth/user").hasRole("ROLE_USER")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form.disable());
        
        return http.build();

    }



    
}
