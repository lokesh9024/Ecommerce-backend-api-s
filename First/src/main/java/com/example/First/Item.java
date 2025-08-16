package com.example.First;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {
@Id
private long id;
private String name;
 private Float price;
private String description;
private long password;
public Item(long id, String name, Float price, String description, Byte categoryId,long password) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.description = description; 
	this.categoryId = categoryId;
	this.password=password;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Item() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Float getPrice() {
	return price;
}
public void setPrice(Float price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Byte getCategoryId() {
	return categoryId;
}
public void setCategoryId(Byte categoryId) {
	this.categoryId = categoryId;
}
public long getPassword() {
	return password;
}
public void setPassword(long password) {
	this.password = password;
}
Byte categoryId;
}
