package com.example.Backend.security;

public class SecurityConstants {
	private SecurityConstants() {};
	public static final String SECRET_KEY="my-super-secret=key-my,super-secret";
	public static final long JWT_expiration=1000*60*60;
	public static String Auth_Header="Authorization";
	public static final String Token_Prefix="Bearer ";
	public  static final String Login_URL="/auth/login";
           
}
