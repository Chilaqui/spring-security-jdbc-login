package com.security.app.config;

import javax.sql.DataSource;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
/* @EnableMethodSecurity(prePostEnabled = true) */
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests( auth -> auth
                .requestMatchers("/auth/admin").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/auth/user").hasAuthority("ROLE_USER")
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults())
            .formLogin(form -> form.disable());
        
        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new  JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    
}
