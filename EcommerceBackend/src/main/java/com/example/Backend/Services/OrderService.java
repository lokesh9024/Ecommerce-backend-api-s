package com.example.Backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Backend.DTO.OrderDto;
import com.example.Backend.DTO.ProductDto;
import com.example.Backend.Entity.Address;
import com.example.Backend.Entity.OrderEntity;
import com.example.Backend.Entity.Ordernumber;
import com.example.Backend.Entity.Product;
import com.example.Backend.Entity.User;
import com.example.Backend.Repository.OrderRepository;
import com.example.Backend.Repository.ProduRepository;
import com.example.Backend.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {
private  OrderRepository orderrepo;
private UserRepository userrepo;
private ProduRepository produrepo;

public OrderService(OrderRepository orderrepo, UserRepository userrepo) {
	super();
	this.orderrepo = orderrepo;
	this.userrepo=userrepo;
}

//to change address
public String changeaddres( OrderDto request)
{
	Optional<OrderEntity> order= orderrepo.findById(request.getId());
	if(!order.isPresent())
	{
		return "order not found";
	}
	OrderEntity Order= order.get();
    Address address=request.getAddress();
    Order.setAddress(address);
    return "successfull";					
  
}

public String  Cancelorder( OrderDto request)
{
Optional<OrderEntity> order= orderrepo.findById(request.getId());
	if(!order.isPresent())
	{
		return "order not found";
	}
	OrderEntity Order= order.get();
		if("Delivered".equals(Order.getStatus()))
		{
			return "cannot canelled a Delivered order";
		}
	
	
	
     Order.setStatus("CANCELLED");
	return "success fully cancelled";
	
};
 public OrderEntity Buyproduct( OrderDto request)
 {
	
	Product product= produrepo.findById(request.getProductId())
			 .orElseThrow(()->new RuntimeException("product not found"));
	 
 List<Product> productlist=List.of(product);
	 Ordernumber ordernumber=new Ordernumber();
	 OrderEntity order= new OrderEntity();
	 
	 order.setProducts(productlist);
	 
	Long price= request.getPrice();
    String pname= request.getPname();
	Double discount=request.getDiscount();
	Double Tax =request.getTax();
    int Quantity=request.getQuantity();
    String status=request.getStatus();
	String paymentstatus =request.getPaymentStatus();
	Double subtotal=(double) (price*Quantity);
	Address addres=request.getAddress();
	if(addres==null)
	{
       System.out.println("So Sorryyyyyyy ITs failed to fetch data");
	}
	if(request.getDeliverycharge()==null)
	{
		throw new RuntimeException("Delivery charge is required");
	}
	Double deliver=request.getDeliverycharge();
	
	
	
	Double Total=subtotal+(price*Tax/100);
	Double Total2= Total-(Total*discount/100);
	Double Total3= Total2+deliver;
     
	String ordnumber=ordernumber.generateordernumber();
	User user= userrepo.findById(request.getUserId())
			.orElseThrow(()-> new RuntimeException("User not found"));
	order.setAddress(addres);
	order.setDeliverycharge(deliver);
	order.setDiscount(discount);
	order.setOrderNumber(ordnumber);
	order.setPaymentStatus(paymentstatus);
	order.setPname(pname);
	order.setQuantity(Quantity);
	order.setTax(Tax);
	order.setPrice(price);
	order.setSubtotal(subtotal);
	order.setTotalamount(Total3);
	order.setUser(user);
	order.setStatus(status);
	
	
	return orderrepo.save(order);
	
 };
}
