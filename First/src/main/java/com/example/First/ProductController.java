package com.example.First;


import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.First.mapper.UserMapperImpl;

import TheProductDto.ProducDto;


@RestController
	@RequestMapping("/products")
	public class ProductController {

	    @Autowired
	    private ProductRepository repository;
	    @Autowired
	    private  UserMapperImpl userMapper;
	    
	    
	  //  public ProductController(ProductRepository repository, UserMapper userMapper) {
	      //  this.repository = repository;
	   //     this.userMapper = userMapper;
	   // }
	    @GetMapping("/all")
	    public List<ProducDto> getAllProduct(@RequestParam String sort) {
	        return repository.findAll(Sort.by(sort))
	        		.stream()
	        		.map(userMapper::toDto)
	        		.toList();
	        
	        

	       
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<ProducDto>getproduct (@PathVariable int id) {
	        var pro=repository.findById(id).orElse(null);
	        if(pro==null)
	        {
	        	return ResponseEntity.notFound().build();
	        }
	        else {
			
			return ResponseEntity.ok(userMapper.toDto(pro));
	        }
	    }
	      
		@GetMapping("/hello")
	       public String welcome() {
	           return "Use /products/add to insert product.";
	       }
	   // }
	//    @GetMapping
	 //   public List<Product> getAllProducts() {
	  //  	  return List.of(new Product(1, 100, "Demo Product"));
	       
	   // }

	   // @PostMapping
	   // public Product createProduct(@RequestBody Product product) {
	    	
	    // return   repository.save(product);
	    
	     
	    
	}//}
	
