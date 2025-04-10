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
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name= "employee_name")
	private String employeeName;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="emp_pro",
			joinColumns = @JoinColumn(name="emp_id"),
			inverseJoinColumns = @JoinColumn(name="pro_id")
	//joincolum - foregin key , given in employee class this class map to employee id
	//inversionJoinColumn - project class  not in employee so given like inversion...
			
			
		)
	private List<Project>projects;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String employeeName) {
		super();
		this.id = id;
		this.employeeName = employeeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public List<Project> getProjects() {
		return projects;
	}

	@Override
	public String toString() {
		return id+" "+employeeName;
	}
	
	
	
}
