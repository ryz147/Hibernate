package com.hibernate.model.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Interviewers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long interviewersID;

	private String name;
	private String department;

	@ManyToMany(fetch = FetchType.LAZY, cascade =
        { CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        },targetEntity=Applicants.class)
	@JoinTable(name = "Interviewer_Applicant", joinColumns = {
			@JoinColumn(name = "applicantsId", nullable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "interviewersId", nullable = false) })

	private List<Applicants> ap = new ArrayList<>();

	//private Applicants applicants;

	public Interviewers() {
		super();
	}
	public Interviewers(String name, String department) {
		super();
		this.name = name;
		this.department = department;
		
	}

	public List<Applicants> getAp() {
		return ap;
	}

	public void setAp(List<Applicants> ap) {
		this.ap = ap;
	}

	

	public Long getInterviewersID() {
		return interviewersID;
	}

	public void setInterviewersID(Long interviewersID) {
		this.interviewersID = interviewersID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	

}
