package com.example.Backend.Entity;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;

String username;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="cart_id")
private Cart cart;

@OneToMany(mappedBy="user")
List<OrderEntity> orders=new ArrayList<>();

String messages;
String  password;
 String getRole;
public int getid() {
	return id;
}
public void setid(int id) {
	this.id = id;
}
public String getUsername() {
	return username; 
}
public User() {
	super();
}
public User(int id, String username, Cart cart, List<OrderEntity> orders, String messages,
		String password, String getRole) {
	super();
	this.id = id;
	this.username = username;
	this.cart = cart;
	this.orders = orders;
	this.messages = messages;
	this.password = password;
	this.getRole = getRole;
}

public void setUsername(String username) {
	this.username = username;
}
public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
	if(cart!=null)
	{
		cart.setUser(this);
	}

}
public List<OrderEntity> getOrders() {
	return orders;
}
public void setOrders(List<OrderEntity> orders) {
	this.orders = orders;
}
public String getMessages() {
	return messages;
}
public void setMessages(String messages) {
	this.messages = messages;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGetRole() {
	return getRole;
}
public void setGetRole(String getRole) {
	this.getRole = getRole;
}
}

