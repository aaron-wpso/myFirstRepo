package com.bucketlist.aaron.bucketlist.dto;

public class StepDTO
{
	private Integer id;
	private Boolean done;
	private String instruction;
	private Integer goalID;
	
	public Integer getGoalID() {
		return goalID;
	}
	public void setGoalID(Integer goalID) {
		this.goalID = goalID;
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
	public void setDone(Boolean done) {
		this.done = done;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
}
