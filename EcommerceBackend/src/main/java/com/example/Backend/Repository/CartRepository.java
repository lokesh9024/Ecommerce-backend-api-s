package com.example.Backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Backend.Entity.User;
import com.example.Backend.Entity.Cart;   
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>
{

 Optional<Cart> findByUser(User user);


}
