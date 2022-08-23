package com.example.Thymleafdemo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Teacher implements Serializable {

	private static final long serialVersionUID = 946941572942270450L;

	private Integer id;

	private String name;

	private String gender;

	private boolean isActive;

	private List<String> courses = new ArrayList<String>();

	private String additionalSkills;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public String getAdditionalSkills() {
		return additionalSkills;
	}

	public void setAdditionalSkills(String additionalSkills) {
		this.additionalSkills = additionalSkills;
	}

}
