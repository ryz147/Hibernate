package com.hibernate.model.onetoone;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class PersonDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property",value="dl"))
	@Id
	@GeneratedValue(generator = "generator")
	private Long personID;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private DriversLicense dl;
	private String firstName;
	private String lastName;
	
	public Long getPersonID() {
		return personID;
	}
	public void setPersonID(Long personID) {
		this.personID = personID;
	}
	public DriversLicense getDl() {
		return dl;
	}
	public void setDl(DriversLicense dl) {
		this.dl = dl;
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
	
	
	
}
