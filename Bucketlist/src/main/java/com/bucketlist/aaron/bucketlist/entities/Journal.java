package com.bucketlist.aaron.bucketlist.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the journal database table.
 * 
 */
@Entity
@NamedQuery(name="Journal.findAll", query="SELECT j FROM Journal j")
public class Journal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Lob
	private String content;

	@Temporal(TemporalType.DATE)
	@Column(name="day_written")
	private Date dayWritten;

	@Lob
	private String title;

	//bi-directional many-to-one association to Goal
	@ManyToOne
	private Goal goal;

	public Journal() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDayWritten() {
		return this.dayWritten;
	}

	public void setDayWritten(Date dayWritten) {
		this.dayWritten = dayWritten;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Goal getGoal() {
		return this.goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

}