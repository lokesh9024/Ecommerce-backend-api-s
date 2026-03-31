package com.example.Backend.DTO;

public class ProductDto {
private String pname;
private String category;
private double price;
private String setDescription;
private int stock;

public ProductDto() {
	super();
}
public ProductDto(String pname, String category, double price, String setDescription, int stock) {
	super();
	this.pname = pname;
	this.category = category;
	this.price = price;
	this.setDescription = setDescription;
	this.stock = stock;
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
public void setPrice(double price) {
	this.price = price;
}
public String getSetDescription() {
	return setDescription;
}
public void setSetDescription(String setDescription) {
	this.setDescription = setDescription;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}

}
