package com.example.createstream;

import java.util.List;

public class Programmer {

	private String name;
	private List<String> skills;
	
	public Programmer(String name, List<String> skills) {
		super();
		this.name = name;
		this.skills = skills;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
}
