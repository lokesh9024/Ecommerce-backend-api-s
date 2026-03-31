package com.example.Backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Backend.Entity.Product;

public interface ProduRepository extends JpaRepository<Product,Integer>
{

	 Optional<Product> findByproductid(int productid);

//all crud methods are buildin
}
