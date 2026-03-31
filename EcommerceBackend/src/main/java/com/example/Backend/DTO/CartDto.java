package com.example.Backend.DTO;

public class CartDto {

private int Userid;
private int productid;
public int getUserid() {
	return Userid;
}
public void setUserid(int Userid) {
	this.Userid = Userid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public long getPrice() {
	return price;
}
public void setPrice(long price) {
	this.price = price;
}
public CartDto(int Userid, int productid, String productname, long price, long totalamt) {
	super();
	this.Userid = Userid;
	this.productid = productid;
	this.productname = productname;
	this.price = price;
	this.totalamt = totalamt;
}
public long getTotalamt() {
	return totalamt;
}
public void setTotalamt(long totalamt) {
	this.totalamt = totalamt;
}
private String productname;
private long price;
private long totalamt;
}
