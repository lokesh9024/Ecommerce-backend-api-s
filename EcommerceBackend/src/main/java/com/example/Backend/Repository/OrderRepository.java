package com.example.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Backend.Entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer >
{

}
