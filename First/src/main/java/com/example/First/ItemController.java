package com.example.First;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.First.mapper.ItemMapper;
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
