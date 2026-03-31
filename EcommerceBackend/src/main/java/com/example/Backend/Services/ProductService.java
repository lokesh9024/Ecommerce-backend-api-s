package com.example.Backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Backend.DTO.ProductDto;
import com.example.Backend.Entity.Product;
import com.example.Backend.Repository.ProduRepository;

@Service
public class ProductService {
private final ProduRepository produrepo ;
public ProductService(ProduRepository produrepo)
{
	this.produrepo=produrepo;
	
}
public List<Product> getAllProducts(){
	return produrepo.findAll();
}
public Product getproductById(int id) {
	return produrepo.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
	
}
/*public Product updateProduct(@RequestBody ProductDto request)
{
	
	
	Product existing=getproductById(request.get);
	existing.setPname(updateProduct.getPname());
	existing.setDescription(updateProduct.setDescription(null));
	existing.setPrice(updateProduct.getPrice());
	existing.setStock(updateProduct.getStock());
	return produrepo.save(existing);
}
*/
public void deleteProduct(int id)
{
produrepo.deleteById(id);
}

public Product addproduct(@RequestBody ProductDto request)
{
	Product pro=new Product();
	
	String pname=request.getPname();
	String category=request.getCategory();
	String description=request.getSetDescription();
	double price =request.getPrice();
	int stock=request.getStock();
	pro.setPname(pname);
	pro.setCategory(category);
	pro.setDescription(description);
	pro.setPrice(price);
	pro.setStock(stock);
	return produrepo.save(pro);
	
}

}
