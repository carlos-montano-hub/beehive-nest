package com.beehive.beehiveNest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection for testing (not recommended for production)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(
                                "/v3/api-docs/**",     // Allow access to OpenAPI docs
                                "/swagger-ui/**",      // Allow access to Swagger UI
                                "/swagger-resources/**", // Allow access to Swagger resources
                                "/api/countries/**",
                                "/api/**"
                        ).permitAll() // Permit access without authentication
                        .anyRequest().authenticated() // All other requests require authentication
                );

        return http.build(); // Return the SecurityFilterChain
    }

}
