package com.example.security.config;

import com.example.security.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.users.MemoryUserDatabase;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import java.io.IOException;

@RequiredArgsConstructor

@Configuration
public class SecurityOldConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService service;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/loginpage", "infopage").permitAll()
                .antMatchers("/mainpage").authenticated()
                .and()
                .cors().disable()
                .formLogin()
                .loginPage("/loginpage").loginProcessingUrl("/try-login")
                .successHandler((request, response, authentication) -> {
                    response.sendRedirect("/mainpage");
                })
                //используем заданные нами login & pass вместо username & password
                .usernameParameter("login")
                .passwordParameter("pass")
                .and()
                .logout()
                .logoutUrl("/try-logout")
                .addLogoutHandler((request, response, authentication) -> {
                    try {
                        response.sendRedirect("/infopage");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//        auth.inMemoryAuthentication()
//                .withUser("user").password("user").authorities("reed")
//                .and()
//                .withUser("admin").password("admin").authorities("write");
    }
}
