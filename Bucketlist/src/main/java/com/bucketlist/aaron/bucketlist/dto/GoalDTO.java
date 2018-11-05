package com.bucketlist.aaron.bucketlist.dto;

public class GoalDTO 
{
	private Integer id;
	private byte done;
	private int importance;
	private String title;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public byte getDone() {
		return done;
	}
	public void setDone(byte done) {
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
