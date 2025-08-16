package com.example.First;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.First.mapper.ItemMapper;

import TheProductDto.ChangePasswordRequest;
import TheProductDto.ItemDto;

@RestController
@RequestMapping("/Items")
public class ItemController {
	@Autowired
    private ItemRepository repository;
    @Autowired
    private  ItemMapper ItemMapper;
	
	
	
	

    @PostMapping
    public ItemDto createItem(@RequestBody ItemDto item)
    {
    	return item;
    }
   //@DeleteMapping("/{id}")
   // public   ResponseEntity<Void> deleteitem(@PathVariable long id)
    //{
    //	var item=repository.findById(id).orElse(null);
    //	if(item== null)
    	//{
    		
    	
		//return ResponseEntity.notFound().build();
    	
   // }
    //	repository.delete(item);
    	//return ResponseEntity.noContent().build();
  //  }
    @PostMapping("/{id}/password")
    public ResponseEntity<Object> changepassword(@PathVariable long id,@RequestBody ChangePasswordRequest request)
    {
    	
    	var item=repository.findById(id).orElse(null);
    	if(item== null)
    	{
    		 
    	
		return ResponseEntity.notFound().build();
    	
    }
    	if((item.getPassword())==(request.getOldPassword()))
    	{
    		return  new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    	}
    	item.setPassword(request.getNewPassword());
        repository.save(item);
        return ResponseEntity.noContent().build();
     }
    
	   @GetMapping("/all")
	    public List<ItemDto> getAllProduct(
	    		@RequestParam(name="categoryId",required=false)Byte categoryId
	    		) {
		   List<Item> items;
		   if(categoryId != null)
		   {
			   items=repository.findBycategoryId(categoryId);
		   }
		   else {
			   items=repository.findAll();
		   }
	        return items
	        		.stream()
	        		.map(ItemMapper :: toDto)
	        		.toList();
}}
