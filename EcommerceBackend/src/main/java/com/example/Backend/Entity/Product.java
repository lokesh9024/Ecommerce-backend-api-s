package com.example.Backend.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int productid;
String pname;
String category;
double price;
String setDescription;
int stock;
private LocalDateTime createdAt;
private LocalDateTime updatedAt;

private List<OrderEntity>orders;

public List<OrderEntity> getOrders() {
	return orders;
}

public void setOrders(List<OrderEntity> orders) {
	this.orders = orders;
}

@PrePersist
protected void onCreate()
{
	createdAt=LocalDateTime.now();
	updatedAt=LocalDateTime.now();
}

@PreUpdate
protected void onUpdate() {
	updatedAt=LocalDateTime.now();
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
public void setPrice(double price) {
	this.price = price;
}
public Product(int productid, String pname, String category, double price, String setDescription, int stock) {
	super();
	this.productid = productid;
	this.pname = pname;
	this.category = category;
	this.price = price;
	this.setDescription = setDescription;
	this.stock = stock;
}
public Product() {
}
public int getproductid() {
	return productid;
}
public void setproductid(int productid) {
	this.productid = productid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public double getPrice() {
	return price;
}

public String getDescription() {
	return setDescription;
}
public String setDescription(String setDescription) {
	return this.setDescription = setDescription;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}

}
