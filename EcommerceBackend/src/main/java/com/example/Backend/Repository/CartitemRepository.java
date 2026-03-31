package com.example.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Backend.Entity.CartItem;

public interface CartitemRepository extends JpaRepository<CartItem,Integer> {

}
