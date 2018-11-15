package com.bucketlist.aaron.bucketlist.dto;

import java.util.List;

/**
 * This is the class the acts as a Data Transfer Object for the Entity Goal that
 * transfer information from the front end to the back end and vice versa.
 * 
 * @author Aaron
 * @version 1.0
 * @since 2018-11-15
 */
public class GoalDTO {
	private Integer id;
	private Boolean done;
	private int importance;
	private String title;
	private String cateName;
	private List<StepDTO> steps;

	public List<StepDTO> getSteps() {
		return steps;
	}

	public void setSteps(List<StepDTO> steps) {
		this.steps = steps;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDone() {
		return done;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
