package com.appzter.core.mgmt;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** * A simple POJO representing a Person **/

@Document
public class Instance {
	@Id
	private String instanceId;
	@Field
	private String name;
	private String projectId;
	private String Location;
	private double fund;
	private List<Person> persons;
	private List<SuccessStories> successStories;
	 
	public Instance(String name, String projectName, String Location, String parentID, double fund) {
		this.name = name;
		/*this.projectId = projectId;  get project ID from project table using project name */
		this.Location = Location;
		this.fund = fund;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setPersons(final List<Person> persons) {
		this.persons = persons;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public double getFunds() {
		return fund;
	}

	public void setFunds(final double fund) {
		this.fund = fund;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(final String Location) {
		this.Location = Location;
	}

	@Override
	public String toString() {
		return "Instance [id=" + projectId + ", name=" + name + ", funds=" + fund + ", Location=" + Location + ", No. of persons=" + persons + ", No. of Success Stories =" + successStories + "]";
	}
}