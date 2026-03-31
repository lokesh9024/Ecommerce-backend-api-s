package com.example.Backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Backend.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
Optional<User> findByUsername(String username);

 Optional<User> findById(int userid);

}
