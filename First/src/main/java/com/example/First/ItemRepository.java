package com.example.First;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item ,Long>{
 List<Item>findBycategoryId(Byte categoryId);



}
