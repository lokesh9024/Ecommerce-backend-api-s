package com.example.Backend.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.DTO.AuthRequestDto;
import com.example.Backend.Entity.User;
import com.example.Backend.Services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
  
    private final AuthenticationManager authenticationManager;

    @Autowired
    private com.example.Backend.security.jwtutil jwtutil;
    
    @Autowired
    private UserService userservice;

    public AuthenticationController(AuthenticationConfiguration config) throws Exception {
        this.authenticationManager = config.getAuthenticationManager();
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        User savedUser = userservice.addUser(user);

        return ResponseEntity.ok(savedUser);
    }
    @GetMapping("/profile")
    public User profile(Authentication auth) {
       
    	return userservice.getUser(auth.getName());

		
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequestDto request) {
      System.out.println("login api gets hitted");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        String username=authentication.getName();

        String token = jwtutil.generateToken(username);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/its")
    public ResponseEntity<String> test() {
        System.out.println("This login is running");
        return ResponseEntity.ok("login hit");
    }
}
