package com.example.Backend.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Ordernumber {
 public String generateordernumber()
 {
	 DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyyMMddHHmmSS");
	 String datepart=LocalDateTime.now().format(formatter);
	 int random= new Random().nextInt(9999);
	 return  "ORD_"+datepart+"_"+random;
 }
}
