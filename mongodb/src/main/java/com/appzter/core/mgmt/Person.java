package com.appzter.core.mgmt;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** * A simple POJO representing a Person **/

@Document
public class Person {
	@Id
	private String personId;
	@Field
	private String name;
	private String projectId;
	private String instanceId;
	private int successStories;
	private int age;
	private String gender;
	private String address;
	private String mobile;
	private Date joiningDate;
	private double salary;
	private Date leavingDate;
	
	public Person(String name, int age, String instanceId, String projectId, String gender, String address, String mobile2, double salary ) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.setMobile(mobile2);
		this.setSalary(salary);
		this.setJoiningDate(new Date());
		this.setGender(gender);
		this.setInstanceId(instanceId);
		this.setProjectId(projectId);
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(final String personId) {
		this.personId = personId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(final String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + personId + ", name=" + name + ", age=" + age
				+ ", home town=" + address + "]";
	}

	/**
	 * @return the instanceId
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * @return the successStories
	 */
	public int getSuccessStories() {
		return successStories;
	}

	/**
	 * @param successStories the successStories to set
	 */
	public void setSuccessStories(int successStories) {
		this.successStories = successStories;
	}

	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}

	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	/**
	 * @return the leavingDate
	 */
	public Date getLeavingDate() {
		return leavingDate;
	}

	/**
	 * @param leavingDate the leavingDate to set
	 */
	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile2 the mobile to set
	 */
	public void setMobile(String mobile2) {
		this.mobile = mobile2;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}