package com.example.Backend.Services;

import org.springframework.stereotype.Service;

import com.example.Backend.Entity.Cart;
import com.example.Backend.Entity.User;
import com.example.Backend.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
	public User addUser(User user)
	{
		Cart cart =new Cart();
		
		cart.setUser(user);
        user.setCart(cart);
		return userRepository.save(user);
	}
}