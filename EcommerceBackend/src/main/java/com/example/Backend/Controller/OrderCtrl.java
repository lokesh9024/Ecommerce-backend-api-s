package com.example.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.DTO.OrderDto;
import com.example.Backend.Entity.OrderEntity;
import com.example.Backend.Services.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderCtrl {
              
@Autowired
private OrderService orderservice;
//To buy a product
@PostMapping("/Buy")
public ResponseEntity<OrderEntity> buyorder(@RequestBody OrderDto order)
{
	OrderEntity placedor= orderservice.Buyproduct(order);
	return ResponseEntity.ok(placedor);
	
}
//To cancel product
@PostMapping("/cancel")
public ResponseEntity<String> Cancelorder(@RequestBody OrderDto order)
{
	String cancelorder=orderservice.Cancelorder(order);
	return ResponseEntity.ok(cancelorder);
}
//To change address
@PutMapping("/Address")
public ResponseEntity<String> ChangeAddress(@RequestBody OrderDto order)
{
	String Changeaddress=orderservice.changeaddres(order);
	return ResponseEntity.ok(Changeaddress);
}
}
