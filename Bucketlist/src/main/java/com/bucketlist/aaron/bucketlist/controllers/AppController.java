package com.bucketlist.aaron.bucketlist.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bucketlist.aaron.bucketlist.dto.CategoryDTO;
import com.bucketlist.aaron.bucketlist.dto.GoalDTO;
import com.bucketlist.aaron.bucketlist.entities.Category;
import com.bucketlist.aaron.bucketlist.entities.Goal;
import com.bucketlist.aaron.bucketlist.services.CategoryService;
import com.bucketlist.aaron.bucketlist.services.GoalService;

@RestController
@RequestMapping(path = "/app")
public class AppController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	GoalService goalService;

	/**
	 * This returns all available goals
	 * 
	 * @return list of goals
	 */
	@GetMapping(path ="/category/getAll")
	public List<CategoryDTO> getAllCategories() 
	{
		return categoryService.getAllCategories();
	}
	
	@PutMapping(path = "/category/update")
	public void updateCategories(@RequestBody List<CategoryDTO> categoryDTOList)
	{
		categoryService.updateCategories(categoryDTOList);
	}
	
	@DeleteMapping(path ="/category/delete/{id}")
	public void deleteCategory(@PathVariable("id") int id)
	{
		categoryService.deleteCategory(id);
	}
	
	@PostMapping(path = "/category/create")
	public void createCategory(@RequestBody CategoryDTO categoryDTO)
	{
		categoryService.createCategory(categoryDTO);
	}
	
	@DeleteMapping(path = "/goal/delete/{id}")
	public void deleteGoal(@PathVariable("id") int id)
	{
		goalService.deleteGoal(id);
	}	
	
	@GetMapping(path ="/goal/getAll")
	public List<GoalDTO> getAllGoals() 
	{
		return goalService.getAllGoals();
	}
	
	@PutMapping(path = "/goal/update")
	public void updateGoal(@RequestBody GoalDTO goalDTO)
	{
		goalService.updateGoal(goalDTO);
	}
	
	@PostMapping(path = "/goal/create")
	public void createGoal(@RequestBody GoalDTO goalDTO)
	{
		goalService.createGoal(goalDTO);
	}
	


}
