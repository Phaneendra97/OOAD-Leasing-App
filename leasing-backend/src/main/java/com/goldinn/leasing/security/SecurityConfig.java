package com.goldinn.leasing.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorize -> authorize
                .requestMatchers(
                    "/", 
                    "/index.html", 
                    "/create-account.html", 
                    "/resident-login.html", 
                    "/admin-login.html", 
                    "/admin-create-account.html", 
                    "/leasingApp.pdf",
                    "/api/applications/**",
                    "/housing-options.html",
                    "/admin-dashboard.html", 
                    "/application.html",  
                    "/api/auth/**",
                    "/api/housing-units/**",
                    "/css/**", 
                    "/js/**", 
                    "/images/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/resident-login.html")  // Specify your login page
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/api/auth/logout") // Custom logout URL
                .permitAll()
            )
            .csrf(csrf -> csrf.disable()); // Disable CSRF for simplicity (not recommended for production)

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
