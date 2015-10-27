package com.appzter.core.mgmt;


import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** * A simple POJO representing a Person **/

@Document
public class SuccessStories {
	@Id
	private ObjectId SSId;
	@Field
	private String projectId;
	private String instanceId;
	private String personId;
	private String successName;
	private String address;
	private String mobile;
	private String Institution;
	private Date start;
	private Date end;
		
	public SuccessStories(String name, String instanceId, String projectId, String personId, String Location, String mobile, String Institution) {
		this.successName = name;
		this.setProjectId(projectId);
		this.setInstanceId(instanceId);
		this.setPersonId(personId);
		this.address = Location;
		this.setMobile(mobile);
		this.setInstitution(Institution);
		this.setStart(new Date());
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getSuccessName() {
		return successName;
	}

	public void setName(final String name) {
		this.successName = name;
	}

	public String getAddress() {
		return address;
	}

	public void setLocation(final String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Instance [id=" + SSId + ", name=" + successName + ", Location=" + address + "]";
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the institution
	 */
	public String getInstitution() {
		return Institution;
	}

	/**
	 * @param institution the institution to set
	 */
	public void setInstitution(String institution) {
		Institution = institution;
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
	 * @return the personId
	 */
	public String getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}
}