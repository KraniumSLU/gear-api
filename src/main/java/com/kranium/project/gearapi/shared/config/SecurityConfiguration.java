package com.kranium.project.gearapi.shared.config;

import com.kranium.project.gearapi.shared.security.routes.AdminRoutes;
import com.kranium.project.gearapi.shared.security.routes.PrivateRoutes;
import com.kranium.project.gearapi.shared.security.routes.PublicRoutes;
import com.kranium.project.gearapi.shared.security.filter.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.
                csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PublicRoutes.ENDPOINTS)
                        .permitAll()
                        .requestMatchers(AdminRoutes.ENDPOINTS)
                        .hasRole("ADMIN")
                        .requestMatchers(PrivateRoutes.ENDPOINTS)
                        .hasAnyRole("ADMIN", "DEVICE")
                        .anyRequest()
                        .authenticated())
                .addFilterBefore(jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    RoleHierarchy roleHierarchy(){
        return RoleHierarchyImpl.fromHierarchy(
                """
                         ROLE_ADMIN > ROLE_USER
                         ROLE_USER > ROLE_VISITOR
                        """
        );
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
