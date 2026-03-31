package com.example.Backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.DTO.ProductDto;
import com.example.Backend.Entity.Product;
import com.example.Backend.Repository.ProduRepository;
import com.example.Backend.Services.ProductService;


@RestController
@RequestMapping("/Backend")
public class Prodctrl {

	@Autowired
	private ProductService productservice;

	@Autowired
	ProduRepository prodrepo;
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) 
	
	{

	  productservice.deleteProduct(id);
	  return ResponseEntity.ok("product deleted successfully");
	}
	@GetMapping("/basic")
	public void func()
	{
		System.out.println("hello lkesh your code is running");
	}
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody ProductDto request)
	{
	Product addproduct=productservice.addproduct(request);
	return ResponseEntity.ok(addproduct);
	
	}
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts()
	{
		return ResponseEntity.ok(productservice.getAllProducts());
		
	}
	
		

}

