package com.example.First.mapper;


	import org.mapstruct.*;

import com.example.First.Product;

import TheProductDto.ProducDto;

	@Mapper(componentModel="spring")
	public interface UserMapper {
	ProducDto toDto(Product pro);
	}


