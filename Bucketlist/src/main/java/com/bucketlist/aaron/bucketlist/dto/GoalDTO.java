package com.bucketlist.aaron.bucketlist.dto;

public class GoalDTO 
{
	private Integer id;
	private Boolean done;
	private int importance;
	private String title;
	private String cateName;
	
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
