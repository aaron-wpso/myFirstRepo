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
	
	public List<Category> getAllCategories()
	{
		List<Category> categoryList = new ArrayList<>();
		categoryRepository.findAll().forEach(categoryList::add);
		return categoryList;
	}
	
	public void updateCategories(List<CategoryDTO> categoryDTOList)
	{
		for(CategoryDTO categoryDTO : categoryDTOList)
		{
			List<GoalDTO> goalDTOList = categoryDTO.getGoals();
			
			for(GoalDTO goalDTO : goalDTOList)
			{
				Goal goal = goalRepository.findOne(goalDTO.getId());
				goal.setTitle(goalDTO.getTitle());
				goal.setImportance(goalDTO.getImportance());
				goal.setDone(goalDTO.getDone());
				
				goalRepository.save(goal);
			}
		}
	}
}
