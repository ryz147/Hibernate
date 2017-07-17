package com.hibernate.model.onetomany;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long employeeID;
	
	private String firstName;
	private String lastName;
	private String cellNum;
	
	@ManyToOne()
	@JoinColumn(name="DepotID")
	private Department depot;
	
	
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String cellNum, Department depot) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cellNum = cellNum;
		this.depot = depot;
	}
	public Long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCellNum() {
		return cellNum;
	}
	public void setCellNum(String cellNum) {
		this.cellNum = cellNum;
	}
	public Department getDepot() {
		return depot;
	}
	public void setDepot(Department depot) {
		this.depot = depot;
	}
	
	
}
