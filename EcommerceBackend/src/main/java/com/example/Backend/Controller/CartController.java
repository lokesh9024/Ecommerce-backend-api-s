package com.example.Backend.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.DTO.CartDto;
import com.example.Backend.Services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController{

private final CartService cartService;

public CartController(CartService cartService)
{
	this.cartService=cartService;
}

@PostMapping("/add")
public String  addProductToCart(
		@RequestParam("userid")   int userid,
		@RequestParam("productid") int productid,
		@RequestParam("quantity") int quantity
		) {
	cartService.addProductToCart(userid, productid, quantity);
	return "product added to cart";
}
}
