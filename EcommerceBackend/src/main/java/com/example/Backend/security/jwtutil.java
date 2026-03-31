package com.example.Backend.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;

@Component
public class jwtutil {
	private  final String SECRET="mysecretmysecretmysecretkey1234567";
	private final SecretKey key=Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
	
	private static final long EXPIRATION_TIME=60*60*1000;
	public  String generateToken(String username)
	{
		return Jwts.builder()
		            .setSubject(username)
		            .setIssuedAt(new Date())
		            .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
		                   .signWith(key, SignatureAlgorithm.HS256)
		                    .compact();
	}
	public String extractUsername(String token)
	{
		return Jwts.parserBuilder()
		.setSigningKey(key)
		.build()
		.parseClaimsJws(token)
		.getBody()
		.getSubject();
		
	}
	public boolean isTokenValid(String token)
	{
		try {
			Jwts.parserBuilder()
			
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token);
			return true;
			
		}catch (Exception e)
		{
			return false;
		}
	}

}
