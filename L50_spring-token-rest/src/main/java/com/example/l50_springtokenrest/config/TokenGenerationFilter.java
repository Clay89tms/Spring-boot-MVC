package com.example.l50_springtokenrest.config;

import com.example.l50_springtokenrest.domain.User;
import com.example.l50_springtokenrest.service.TokenService;
import com.example.l50_springtokenrest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class TokenGenerationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getParameter("username");

        User user = userService.getByUsername(username);

        if(user != null) {

            List<SimpleGrantedAuthority> collect = user.getAuths()
                    .stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(user.getLogin(), "", collect);

            String tokenAsString = tokenService.createToken(token);
            response.setHeader("token", tokenAsString);
        }
        filterChain.doFilter(request, response);
    }
}
