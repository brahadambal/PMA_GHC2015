package com.appzter.core.mgmt;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Project {
	@Id
	private String projectID;
	
	private String name;
	
	private Fund fund;
	
	public Project(String name, Fund fund) {
		this.name = name;
		this.fund = fund;
		
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(final String projectID) {
		this.projectID = projectID;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(final Fund fund) {
		this.fund = fund;
	}
		
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Project [name ="+ name  + " id=" + projectID + ", fund=" + fund +"]";
	}	

}
