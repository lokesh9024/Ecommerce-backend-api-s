package com.example.First;

public class paypalpay implements paymentservice{
@Override
public void processPayment(double amt)
{
	System.out.println("Payment with Paypal"+amt);
	
}
}
