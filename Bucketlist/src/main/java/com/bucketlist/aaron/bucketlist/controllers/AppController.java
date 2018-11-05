package com.bucketlist.aaron.bucketlist.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<Category> categoryList = categoryService.getAllCategories();
		
		List<CategoryDTO> dtoList = new ArrayList<>();
		for(Category category: categoryList)
		{
			CategoryDTO dtoCategory = new CategoryDTO();
			
			dtoCategory.setId(category.getId());
			dtoCategory.setCateName(category.getCateName());
			
			List<GoalDTO> dtoGoalList = new ArrayList<>(); 
			for(Goal goal: category.getGoals())
			{
				GoalDTO dtoGoal = new GoalDTO();
					
				dtoGoal.setId(goal.getId());
				dtoGoal.setTitle(goal.getTitle());
				dtoGoal.setImportance(goal.getImportance());
				dtoGoal.setDone(goal.getDone());
					
				dtoGoalList.add(dtoGoal);
			
			}
			dtoCategory.setGoals(dtoGoalList);
			dtoList.add(dtoCategory);
		}
		
		return dtoList;
	}
	
	@PutMapping(path = "/category/update")
	public void updateCategories(@RequestBody List<CategoryDTO> categoryDTOList)
	{
		categoryService.updateCategories(categoryDTOList);
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
}
