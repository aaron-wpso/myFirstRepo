package com.bucketlist.aaron.bucketlist.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the goal database table.
 * 
 */
@Entity
@NamedQuery(name="Goal.findAll", query="SELECT g FROM Goal g")
public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean done;

	private int importance;

	@Lob
	private String title;

	//bi-directional many-to-many association to Category
	@ManyToMany
	@JoinTable(
		name="goal_category"
		, joinColumns={
			@JoinColumn(name="goal_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cate_id")
			}
		)
	private List<Category> categories;

	//bi-directional many-to-one association to Journal
	@OneToMany(mappedBy="goal")
	private List<Journal> journals;

	//bi-directional many-to-one association to Photo
	@OneToMany(mappedBy="goal")
	private List<Photo> photos;

	//bi-directional many-to-one association to Step
	@OneToMany(mappedBy="goal")
	private List<Step> steps;

	public Goal() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDone() {
		return this.done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public int getImportance() {
		return this.importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Journal> getJournals() {
		return this.journals;
	}

	public void setJournals(List<Journal> journals) {
		this.journals = journals;
	}

	public Journal addJournal(Journal journal) {
		getJournals().add(journal);
		journal.setGoal(this);

		return journal;
	}

	public Journal removeJournal(Journal journal) {
		getJournals().remove(journal);
		journal.setGoal(null);

		return journal;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Photo addPhoto(Photo photo) {
		getPhotos().add(photo);
		photo.setGoal(this);

		return photo;
	}

	public Photo removePhoto(Photo photo) {
		getPhotos().remove(photo);
		photo.setGoal(null);

		return photo;
	}

	public List<Step> getSteps() {
		return this.steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public Step addStep(Step step) {
		getSteps().add(step);
		step.setGoal(this);

		return step;
	}

	public Step removeStep(Step step) {
		getSteps().remove(step);
		step.setGoal(null);

		return step;
	}

}