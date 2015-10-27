package com.appzter.core.mgmt;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Project {
	@Id
	private String projectId;
	@Field
	private String name;
	private double fund;
	private String description;
	private List<Instance> instances;
	private List<SuccessStories> successStories;
	private Date start;
	private Date end;
	private DateFormat dateFormat;
	private DateFormat dateFormat2;
	
	public Project(String name, List<Instance> instanceList, String description, double fund, String projectId) {
		setDateFormat2(new SimpleDateFormat("MMM dd, ''yyyy"));
		this.projectId = projectId;
		this.name = name;
		this.fund = fund; 
		this.instances = instanceList;
		this.setDescription(description);
		this.setStart(new Date());
	}

	public String getProjectID() {
		return projectId;
	}

	public void setProjectID(final String projectID) {
		this.projectId = projectID;
	}

	public double getFund() {
		return fund;
	}

	public void setFund(final double fund) {
		this.fund = fund;
	}
		
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the instances
	 */
	public List<Instance> getInstances() {
		return instances;
	}

	/**
	 * @param instances the instances to set
	 */
	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(Date end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "Project [name ="+ name  + " id=" + projectId + ", fund=" + fund +"]";
	}

	/**
	 * @return the dateFormat
	 */
	public DateFormat getDateFormat() {
		return dateFormat;
	}

	/**
	 * @param dateFormat the dateFormat to set
	 */
	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	/**
	 * @return the dateFormat2
	 */
	public DateFormat getDateFormat2() {
		return dateFormat2;
	}

	/**
	 * @param dateFormat2 the dateFormat2 to set
	 */
	public void setDateFormat2(DateFormat dateFormat2) {
		this.dateFormat2 = dateFormat2;
	}

	/**
	 * @return the successStories
	 */
	public List<SuccessStories> getSuccessStories() {
		return successStories;
	}

	/**
	 * @param successStories the successStories to set
	 */
	public void setSuccessStories(List<SuccessStories> successStories) {
		this.successStories = successStories;
	}

}
