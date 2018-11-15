package com.bucketlist.aaron.bucketlist.dto;

import java.util.List;

/**
 * This is the class the acts as a Data Transfer Object for the Entity Category
 * that transfer information from the front end to the back end and vice versa.
 * 
 * @author Aaron
 * @version 1.0
 * @since 2018-11-15
 */
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
