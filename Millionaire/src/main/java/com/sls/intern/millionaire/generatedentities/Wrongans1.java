package com.sls.intern.millionaire.generatedentities;
// Generated Oct 4, 2018 3:02:26 PM by Hibernate Tools 5.1.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Wrongans1 generated by hbm2java
 */
@Entity
@Table(name = "wrongans1", catalog = "dbQuestion2")
public class Wrongans1 implements java.io.Serializable {
	
	@Id
	@Column(name = "wa1ID")
	private Integer wa1id;
	
	@Column(name = "wa1Content")
	private String wa1content;

	public Wrongans1() {
	}

	public Wrongans1(String wa1content) {
		this.wa1content = wa1content;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "wa1ID", unique = true, nullable = false)
	public Integer getWa1id() {
		return this.wa1id;
	}

	public void setWa1id(Integer wa1id) {
		this.wa1id = wa1id;
	}

	@Column(name = "wa1Content", length = 50)
	public String getWa1content() {
		return this.wa1content;
	}

	public void setWa1content(String wa1content) {
		this.wa1content = wa1content;
	}

}
