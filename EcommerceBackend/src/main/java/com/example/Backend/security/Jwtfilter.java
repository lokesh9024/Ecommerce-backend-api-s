package com.example.Backend.security;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Component
public class Jwtfilter extends OncePerRequestFilter {  // Fixed class name convention
    @Autowired
    private jwtutil jwtUtil;  // Assuming correct casing
    @Autowired
    private UserDetailsService userDetailsService;  // Fixed name consistency

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/auth/login");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      
    		FilterChain chain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                if (jwtUtil.isTokenValid(token)) {  // Add logging here for debugging
                    String username = jwtUtil.extractUsername(token);
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if (username.equals(userDetails.getUsername()) && userDetails.isEnabled()) {  // Extra validation
                        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
            } catch (Exception e) {
                // Log exception; don't throw UsernameNotFoundException here
                logger.warn("JWT validation failed",e);  // Add logger
                SecurityContextHolder.clearContext();  // Clear invalid context
            }
        }
        chain.doFilter(request, response);
    }
}
