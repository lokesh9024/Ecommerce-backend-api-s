package com.example.Backend.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
 String state;
 String city;
 long pincode;
 String hnfulladdress;
 
public Address() {
	super();
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public Address(String state, String city, long pincode, String hnfulladdress) {
	super();
	this.state = state;
	this.city = city;
	this.pincode = pincode;
	this.hnfulladdress = hnfulladdress;
}
public void setCity(String city) {
	this.city = city;
}
public long getPincode() {
	return pincode;
}
public void setPincode(long pincode) {
	this.pincode = pincode;
}
public String getHnfulladdress() {
	return hnfulladdress;
}
public void setHnfulladdress(String hnfulladdress) {
	this.hnfulladdress = hnfulladdress;
}
}
