package com.example.Backend.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PreUpdate;

@Entity
public class CartItem {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int CartItemId;
	long totalitems;
    int quantity;
    
    
   double totalprice;
	
	public CartItem(double totalprice) {
	super();
	this.totalprice = totalprice;
}

	public double getTotalprice() {
	return totalprice;
}

public void setTotalprice(double totalprice) {
	this.totalprice = totalprice;
}

	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@PostPersist
	protected void onCreate()
	{
		createdAt=LocalDateTime.now();
		updatedAt=LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onupdate()
	{
		updatedAt=LocalDateTime.now();
		
	}

	public CartItem() {
		super();
	}

	public CartItem(int cartItemId, int totalitems, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		CartItemId = cartItemId;
		this.totalitems = totalitems;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getCartItemId() {
		return CartItemId;
	}

	public void setCartItemId(int cartItemId) {
		CartItemId = cartItemId;
	}

	

	public long getTotalitems() {
		return totalitems;
	}

	public void setTotalitems(long totalitems) {
		this.totalitems = totalitems;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
