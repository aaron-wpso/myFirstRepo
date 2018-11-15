package com.bucketlist.aaron.bucketlist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bucketlist.aaron.bucketlist.dto.StepDTO;
import com.bucketlist.aaron.bucketlist.entities.Goal;
import com.bucketlist.aaron.bucketlist.entities.Step;
import com.bucketlist.aaron.bucketlist.repository.GoalRepository;
import com.bucketlist.aaron.bucketlist.repository.StepRepository;

@Service
public class StepService 
{
	@Autowired
	private StepRepository stepRepository;
	
	@Autowired
	private GoalRepository goalRepository;
	
	public List<StepDTO> getAllSteps(int goalID)
	{
		List<Step> stepList = new ArrayList<>();
		stepRepository.findAll().forEach(stepList::add);
		
		List<StepDTO> dtoList = new ArrayList<>();
		for(Step step : stepList)
		{
			if(step.getGoal().getId() == goalID)
			{
				StepDTO dto = new StepDTO();
			
				dto.setId(step.getId());
				dto.setInstruction(step.getInstruction());
				dto.setDone(step.getDone());
			
				dtoList.add(dto);
			}
		}
		
		return dtoList;
	}
	
	public void deleteStep(int id)
	{
		stepRepository.delete(id);
	}
	
	public void updateStep(StepDTO stepDTO)
	{
		Step step= stepRepository.findOne(stepDTO.getId());
		step.setInstruction(stepDTO.getInstruction());
		step.setDone(stepDTO.getDone());
		
		stepRepository.save(step);
	}
	
	public void createStep(StepDTO stepDTO)
	{
		Goal goal = goalRepository.findOne(stepDTO.getGoalID());
		
		Step step = new Step();
		step.setInstruction(stepDTO.getInstruction());
		step.setDone(stepDTO.getDone());
		step.setGoal(goal);
		
		stepRepository.save(step);
		
	}
}
