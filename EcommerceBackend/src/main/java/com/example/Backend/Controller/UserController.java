package com.example.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.Entity.User;
import com.example.Backend.Repository.UserRepository;
import com.example.Backend.Services.UserService;

@RestController
@RequestMapping("/create")
public class UserController {
	@Autowired
	 UserService userservice;
	//private UserRepository userrepo;
	
 @PostMapping("/usr")
 public String createuser(@RequestBody User user)
 {
	userservice.addUser(user);
	return "susscessfull created;";
 }
}
