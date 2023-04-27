package com.example.l50_springtokenrest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@RequiredArgsConstructor

@Configuration
@EnableWebSecurity(debug = true)
public class SecureConfig extends WebSecurityConfigurerAdapter {
    private final TokenValidationFilter validationFilter;
    private final TokenGenerationFilter generationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/test").authenticated()
                .and()
                .addFilterBefore(validationFilter, LogoutFilter.class)
                .addFilterAfter(generationFilter, UsernamePasswordAuthenticationFilter.class)
        ;
    }
}
