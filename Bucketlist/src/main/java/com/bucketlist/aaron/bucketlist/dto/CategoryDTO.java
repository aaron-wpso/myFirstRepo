package com.bucketlist.aaron.bucketlist.dto;

import java.util.List;

import com.bucketlist.aaron.bucketlist.entities.Goal;

public class CategoryDTO {
	
	private Integer id;
	private String cateName;
	private List<GoalDTO> goalDTOs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public List<GoalDTO> getGoals() {
		return goalDTOs;
	}
	public void setGoals(List<GoalDTO> list) {
		this.goalDTOs = list;
	}
	
	
}
