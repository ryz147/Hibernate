package com.hibernate.model.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long departmentId;
	private String departmentName;
	
	@OneToMany(mappedBy="depot", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@OrderColumn
	@Fetch(FetchMode.SELECT)
	private List<Employee> emp = new ArrayList<>();
	
	
	
	public Department() {
		super();
	}

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
		
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	
	
	
	
}
