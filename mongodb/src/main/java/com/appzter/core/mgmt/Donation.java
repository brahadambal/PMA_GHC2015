package com.appzter.core.mgmt;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** * A simple POJO representing a inventory **/

@Document
public class Donation {
	@Id
	private String DonationId;
	@Field
	private String name;
	private String projectId;
	private String PAN;
	private double amount;
	
	public Donation(String name, String projectId, String pan, double d) {
		this.name = name;
		this.setPAN(pan);
		this.projectId = projectId;
		this.setAmount(d);
		/*this.setInstanceId(X); get the instance id from the instance table based on instance name*/
	}

	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	public String getDonationId() {
		return DonationId;
	}

	public void setDonationId(final String donationId) {
		this.DonationId = donationId;
	}
	

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "donation [id=" + DonationId + ", name=" + name + "]";
	}

	/**
	 * @return the instanceId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return amount;
	}

	/**
	 * @param d the cost to set
	 */
	public void setCost(double d) {
		this.amount = d;
	}

	/**
	 * @return the pAN
	 */
	public String getPAN() {
		return PAN;
	}

	/**
	 * @param pAN the pAN to set
	 */
	public void setPAN(String pAN) {
		PAN = pAN;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
}