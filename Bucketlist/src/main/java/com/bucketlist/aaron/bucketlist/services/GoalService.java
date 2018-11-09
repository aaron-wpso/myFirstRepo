package com.bucketlist.aaron.bucketlist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bucketlist.aaron.bucketlist.dto.GoalDTO;
import com.bucketlist.aaron.bucketlist.entities.Category;
import com.bucketlist.aaron.bucketlist.entities.Goal;
import com.bucketlist.aaron.bucketlist.repository.CategoryRepository;
import com.bucketlist.aaron.bucketlist.repository.GoalRepository;

@Service
public class GoalService 
{
	@Autowired
	private GoalRepository goalRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<GoalDTO> getAllGoals()
	{
		List<Goal> goalList = new ArrayList<>();
		goalRepository.findAll().forEach(goalList::add);
		
		List<GoalDTO> dtoList = new ArrayList<>();
		for(Goal goal : goalList)
		{
			GoalDTO dto = new GoalDTO();
			
			dto.setId(goal.getId());
			dto.setTitle(goal.getTitle());
			dto.setImportance(goal.getImportance());
			dto.setDone(goal.getDone());
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}
	
	public void deleteGoal(int id)
	{
		goalRepository.delete(id);
	}
	
	public void updateGoal(GoalDTO goalDTO)
	{
		Goal goal = goalRepository.findOne(goalDTO.getId());
		goal.setTitle(goalDTO.getTitle());
		goal.setDone(goalDTO.getDone());
		goal.setImportance(goalDTO.getImportance());
		
		goalRepository.save(goal);
	}
	
	public void createGoal(GoalDTO goalDTO)
	{
		Category cateName = categoryRepository.findByCateName(goalDTO.getCateName());
		
		Goal goal = new Goal();
		goal.setTitle(goalDTO.getTitle());
		goal.setDone(goalDTO.getDone());
		goal.setImportance(goalDTO.getImportance());
		
		List categoryList = new ArrayList<>();
		categoryList.add(cateName);
		
		goal.setCategories(categoryList);
		
		goalRepository.save(goal);
	}
}
