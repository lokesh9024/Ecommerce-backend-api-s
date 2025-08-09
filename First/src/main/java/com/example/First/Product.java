package com.example.First;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
 int pid;
 int pdesc;
String pname;
String email;
public Product(int pid, int pdesc, String pname, String email) {
	super();
	this.pid = pid;
	this.pdesc = pdesc;
	this.pname = pname;
	this.email=email;
}
public Product() {
	// TODO Auto-generated constructor stub
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getPdesc() {
	return pdesc;
}
public void setPdesc(int pdesc) {
	this.pdesc = pdesc;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getemail()
{
	return email;
}
public void setemail(String email)
{
	this.email=email;
}

public Object getMail() {
	// TODO Auto-generated method stub
	return null;
}
 
}
