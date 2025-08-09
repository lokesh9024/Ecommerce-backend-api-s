package com.example.First.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.First.Item;

import TheProductDto.ItemDto;


@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "categoryId", source = "categoryId")
    ItemDto toDto(Item pro);
}