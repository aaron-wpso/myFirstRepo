package com.bucketlist.aaron.bucketlist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bucketlist.aaron.bucketlist.entities.Category;

/**
 * This is a Repository that extends from the CrudRepository defined by Spring
 * framework to handle database operations of the Entity type Category.
 * 
 * @author Aaron
 * @version 1.0
 * @since 2018-11-15
 *
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

	/**
	 * This method allows for the Repository to retrieve a record by the cateName
	 * column of the database table.
	 * 
	 * @param cateName The Category Name of the desired Category needed to be
	 *                 retrieved
	 * @return the Category that has the matching Category Name
	 */
	public Category findByCateName(String cateName);

}
