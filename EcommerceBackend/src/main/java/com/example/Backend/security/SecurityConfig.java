package com.example.Backend.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final Jwtfilter jwtFilter;
	public SecurityConfig(Jwtfilter jwtFilter)
	{
		this.jwtFilter=jwtFilter;
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
               .requestMatchers("/auth/login").permitAll()
               .requestMatchers("/auth/register").permitAll()
               .requestMatchers("/Backend/add").permitAll()
               .requestMatchers("/cart/add").permitAll()
               .requestMatchers("/Order/Buy").permitAll()
               .requestMatchers("/Order/cancel").permitAll()
               .requestMatchers("/Order/Address").permitAll()
               // .requestMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
    
            )
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean 
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config
    ) throws Exception {
        return config.getAuthenticationManager();
    }

    @SuppressWarnings("deprecation")
	@Bean
    public PasswordEncoder passwordEncoder() {
       // return new BCryptPasswordEncoder();
    	return NoOpPasswordEncoder.getInstance();
    }
}
