package com.bucketlist.aaron.bucketlist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bucketlist.aaron.bucketlist.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>
{
	public Category findByCateName(String cateName);
	
}
