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
public class Applicants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicantsID;

	private String names;
	private String skills;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade =
        { CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        },targetEntity=Interviewers.class)
	@JoinTable(name = "Interviewer_Applicant", joinColumns = {
			@JoinColumn(name = "interviewersId", nullable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "applicantsId", nullable = false) })
	private List<Interviewers> interviews = new ArrayList<>();

	public Applicants() {
		super();

	}

	public Applicants(String names, String skills, List<Interviewers> interviews) {
		super();
		this.names = names;
		this.skills = skills;
		
		this.interviews = interviews;
	}

	public List<Interviewers> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Interviewers> interviews) {
		this.interviews = interviews;
	}

	public Long getApplicantsID() {
		return applicantsID;
	}

	public void setApplicantsID(Long applicantsID) {
		applicantsID = applicantsID;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}


}
