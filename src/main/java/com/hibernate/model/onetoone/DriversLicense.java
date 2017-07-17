package com.hibernate.model.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class DriversLicense implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long personID;
	private String licenseNum;
	private String address;
	private String State;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="dl")
	private PersonDetails pd;
	
	public PersonDetails getPd() {
		return pd;
	}
	public void setPd(PersonDetails pd) {
		this.pd = pd;
	}
	
	public Long getPersonID() {
		return personID;
	}
	public void setPersonID(Long personID) {
		this.personID = personID;
	}
	public String getLicenseNum() {
		return licenseNum;
	}
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	
}
