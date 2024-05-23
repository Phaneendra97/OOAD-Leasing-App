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
                    "/admin-dashboard.html",
                    "/api/applications/**",
                    "/housing-options.html", 
                    "/application.html",  
                    "/resident-profile.html",
                    "/api/residents/**",
                    "/api/billing/**",
                    "/api/auth/**",
                    "/api/housing-units/**",
                    "/css/**", 
                    "/js/**", 
                    "/images/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/resident-login.html")
                .defaultSuccessUrl("/index.html", true)
                .permitAll()
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/admin-login.html")
                .defaultSuccessUrl("/admin-dashboard.html", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/api/auth/logout")
                .permitAll()
            )
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
