package com.tap;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="project_name")
	private String projectName;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="emp_pro",
			inverseJoinColumns = @JoinColumn(name="emp_id"),
					joinColumns = @JoinColumn(name="pro_id"))	
	
	//how many employee did project many to store in list
	private List<Employee> employees;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int id, String projectName) {
		super();
		this.id = id;
		this.projectName = projectName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		return id+" "+projectName;
	}
	
}
