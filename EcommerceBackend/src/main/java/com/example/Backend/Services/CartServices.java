package com.example.Backend.Services;

import com.example.Backend.DTO.CartDto;

public interface CartServices {
 CartDto addProductToCart(int id,int productid,int quantity);
 CartDto viewCart(int id);
 CartDto updateCartItem(int id,int productid,int quantity);
 void removeCartItem(int userid,int productid);
 void clearCart(int id);
}
