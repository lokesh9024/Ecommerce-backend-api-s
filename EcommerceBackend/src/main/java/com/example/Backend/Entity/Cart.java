package com.example.Backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int productId;

    private int TotalItems;
    
    private double TotalPrice;

    

    public Cart(int totalItems, double totalPrice) {
		super();
		totalItems = TotalItems;
		totalPrice = TotalPrice;
	}

	public int getTotalItems() {
		return TotalItems;
	}

	public void setTotalItems(int totalitems) {
		TotalItems = totalitems;
	}

	public double getTotalprice() {
		return TotalPrice;
	}

	public void setTotalprice(double d) {
		TotalPrice = d;
	}

	@OneToOne(mappedBy="cart",cascade=CascadeType.ALL)
    @JsonIgnore
    private User user;

    public Cart() {
    }

    public Cart(int id, int productId, User user) {
        this.id = id;
        this.productId = productId;        
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    
   

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}