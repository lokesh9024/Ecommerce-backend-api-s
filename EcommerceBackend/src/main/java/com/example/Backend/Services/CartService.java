package com.example.Backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Backend.Entity.Product;
import com.example.Backend.Entity.User;
import com.example.Backend.Entity.Cart;
import com.example.Backend.Entity.CartItem;
import com.example.Backend.Repository.CartRepository;
import com.example.Backend.Repository.CartitemRepository;
import com.example.Backend.Repository.ProduRepository;
import com.example.Backend.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartService {
 private final CartRepository cartrepo;
 private final CartitemRepository cartitemrepo;
 private final ProduRepository productrepo;
 private final UserRepository userrepo;
public CartService(CartRepository cartrepo, CartitemRepository cartitemrepo, ProduRepository productrepo,
		UserRepository userrepo) {

	this.cartrepo = cartrepo;
	this.cartitemrepo = cartitemrepo;
	this.productrepo = productrepo;
	this.userrepo = userrepo;
}
//Add product to cart 
public void addProductToCart(int id,int productid,int quantity)
{
	if(quantity<=0)
	{
		throw new RuntimeException("quantity must be greateer tahn 0");
		
	}
	
	 User user=userrepo.findById(id)
			 .orElseThrow(()-> new RuntimeException("user not found"));
	 
	Product product =productrepo.findById(productid)
			.orElseThrow(()-> new RuntimeException("product not found"));
	
			Cart cart=user.getCart();
			
			CartItem item =new CartItem();
			
			double totalprice=product.getPrice()*quantity;
			 item.setTotalprice(totalprice);

			item.setCart(cart);
			item.setProduct(product);
			item.setQuantity(quantity);
			cartitemrepo.save(item);
			
			cart.setUser(user);
			cart.setProductId(productid);
			cart.setTotalItems(cart.getTotalItems()+quantity);
			cart.setTotalprice(cart.getTotalprice()+totalprice);
			cartrepo.save(cart);
			long total= cartitemrepo.count();
			
			  List<CartItem> items=cartitemrepo.findAll();
			  for(CartItem iteme : items)
			  {
				  iteme.setTotalitems((int)total);
			  }
			cartitemrepo.saveAll(items);
			
			
		
			
}
 
}
