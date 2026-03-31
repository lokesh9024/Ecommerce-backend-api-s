package com.example.Backend.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Backend.Entity.User;
import com.example.Backend.Repository.UserRepository;

@Service
public class Customuserdetailservice implements UserDetailsService{
 @Autowired
 UserRepository repo;
 
 @Override
 public UserDetails loadUserByUsername(String username)
           throws UsernameNotFoundException{
	 User user= repo.findByUsername(username)
			 .orElseThrow(()-> new UsernameNotFoundException("User not found"));
			return new org.springframework.security.core.userdetails.User(
					user.getUsername(),
					user.getPassword(),
					List.of()
					);
					//(new SimpleGrantedAuthority(user.getGetRole()))
//);
					
 }
	

}
