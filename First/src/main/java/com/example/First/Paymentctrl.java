package com.example.First;

public class Paymentctrl{
	public paymentservice service;
	public Paymentctrl(paymentservice service)
	{
		this.service=service;
	}



public void placeorder()
{
  service.processPayment(10.0);
  System.out.println("thissssssss");
}
}
