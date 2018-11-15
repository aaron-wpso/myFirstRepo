package com.bucketlist.aaron.bucketlist.dto;

/**
 * This is the class the acts as a Data Transfer Object for the Entity Step that
 * transfer information from the front end to the back end and vice versa.
 * 
 * @author Aaron
 * @version 1.0
 * @since 2018-11-15
 */
public class StepDTO {
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
