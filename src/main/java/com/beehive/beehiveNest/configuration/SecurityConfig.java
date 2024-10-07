package com.beehive.beehiveNest.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection for testing (not recommended for production)
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers(
//                                "/v3/api-docs/**",     // Allow access to OpenAPI docs
//                                "/swagger-ui/**",      // Allow access to Swagger UI
//                                "/swagger-resources/**" // Allow access to Swagger resources
//                        ).permitAll() // Permit access without authentication
//                        .anyRequest().authenticated() // All other requests require authentication
//                );
//
//        return http.build(); // Return the SecurityFilterChain
//    }

}
