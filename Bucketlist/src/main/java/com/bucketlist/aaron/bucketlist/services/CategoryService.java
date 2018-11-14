package com.bucketlist.aaron.bucketlist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bucketlist.aaron.bucketlist.dto.CategoryDTO;
import com.bucketlist.aaron.bucketlist.dto.GoalDTO;
import com.bucketlist.aaron.bucketlist.entities.Category;
import com.bucketlist.aaron.bucketlist.entities.Goal;
import com.bucketlist.aaron.bucketlist.repository.CategoryRepository;
import com.bucketlist.aaron.bucketlist.repository.GoalRepository;

@Service
public class CategoryService 
{
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	GoalRepository goalRepository;
	
	public List<CategoryDTO> getAllCategories()
	{
		List<Category> categoryList = new ArrayList<>();
		categoryRepository.findAll().forEach(categoryList::add);
		
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
	
	public void updateCategories(List<CategoryDTO> categoryDTOList)
	{
		for(CategoryDTO categoryDTO : categoryDTOList)
		{
			Category category = categoryRepository.findOne(categoryDTO.getId());
			category.setCateName(categoryDTO.getCateName());
			
			List<GoalDTO> goalDTOList = categoryDTO.getGoals();
			
			for(GoalDTO goalDTO : goalDTOList)
			{
				Goal goal = goalRepository.findOne(goalDTO.getId());
				goal.setTitle(goalDTO.getTitle());
				goal.setImportance(goalDTO.getImportance());
				goal.setDone(goalDTO.getDone());
				
				goalRepository.save(goal);
			}
			
			categoryRepository.save(category);
		}
	}
	
	public void createCategory(CategoryDTO categoryDTO)
	{
		Category category = new Category();
		
		category.setCateName(categoryDTO.getCateName());
		
		if(categoryDTO.getGoals() != null)
		{
		
			List<Goal> goalList = new ArrayList<>(); 
			for(GoalDTO goalDTO : categoryDTO.getGoals())
			{
				Goal goal = new Goal();
				goal.setTitle(goalDTO.getTitle());
				goal.setImportance(goalDTO.getImportance());
				goal.setDone(goalDTO.getDone());
			
				goalList.add(goal);
			}
			category.setGoals(goalList);
			
			goalRepository.save(category.getGoals());
		}
		
		categoryRepository.save(category);
		
	}
	
	public void deleteCategory(int id)
	{	
		Category category = categoryRepository.findOne(id);
		for(Goal goal:category.getGoals())
		{
			goalRepository.delete(goal);
		}
		categoryRepository.delete(id);
		
	}
	
	
}
