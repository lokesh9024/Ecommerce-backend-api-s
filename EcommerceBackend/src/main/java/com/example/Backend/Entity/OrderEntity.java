package com.example.Backend.Entity;

import java.util.List;

import com.example.Backend.DTO.ProductDto;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderEntity {
String pname;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;

@ManyToMany
@JoinTable(
		
name="order_products",
joinColumns=@JoinColumn(name="order_id"),
inverseJoinColumns=@JoinColumn(name="product_id")
)
private List<Product> products;


public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> list) {
	this.products = list;
}
@ManyToOne
@JoinColumn(name="user_id")
private User user;
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
private long Price;
private String orderNumber;
private Double tax;
private Double Deliverycharge;
private Double Discount;
private Double Totalamount;
private Double Subtotal;

private String Status;
private String PaymentStatus;
private int quantity;

@Embedded
private Address address;
public OrderEntity() {
	super();
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public OrderEntity(String pname, int id, String orderNumber, Double tax, Double deliverycharge, Double discount,
		Double totalamount, Double subtotal, String status, String paymentStatus) {
	super();
	this.pname = pname;
	this.id = id;
	this.orderNumber = orderNumber;
	this.tax = tax;
	Deliverycharge = deliverycharge;
	Discount = discount;
	Totalamount = totalamount;
	Subtotal = subtotal;	
	Status = status;
	PaymentStatus = paymentStatus;
	
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOrderNumber() {
	return orderNumber;
}
public void setOrderNumber(String orderNumber) {
	this.orderNumber = orderNumber;
}
public Double getTax() {
	return tax;
}
public void setTax(Double tax) {
	this.tax = tax;
}
public Double getDeliverycharge() {
	return Deliverycharge;
}
public void setDeliverycharge(Double deliverycharge) {
	Deliverycharge = deliverycharge;
}
public Double getDiscount() {
	return Discount;
}
public void setDiscount(Double discount) {
	Discount = discount;
}
public Double getTotalamount() {
	return Totalamount;
}
public void setTotalamount(Double totalamount) {
	Totalamount = totalamount;
}
public Double getSubtotal() {
	return Subtotal;
}
public void setSubtotal(Double subtotal) {
	Subtotal = subtotal;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public String getPaymentStatus() {
	return PaymentStatus;
}
public void setPaymentStatus(String paymentStatus) {
	PaymentStatus = paymentStatus;
}
public long getPrice() {
	return Price;
}
public void setPrice(long price) {
	Price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
