package com.appzter.core.mgmt;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** * A simple POJO representing a inventory **/

@Document
public class Inventory {
	@Id
	private String inventoryId;
	@Field
	private String name;
	private ObjectId instanceId;
	private String description;
	private double cost;
	
	public Inventory(String name, String instanceName, String description, double d) {
		this.name = name;
		this.setDescription(description);
		this.setCost(d);
		/*this.setInstanceId(X); get the instance id from the instance table based on instance name*/
	}

	public String getInventoryId() {
		return inventoryId;
	}

	/*
	public void setInventoryId(final String inventoryId) {
		this.inventoryId = inventoryId;
	}
	*/

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "inventory [id=" + inventoryId + ", name=" + name + "]";
	}

	/**
	 * @return the instanceId
	 */
	public ObjectId getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(ObjectId instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param d the cost to set
	 */
	public void setCost(double d) {
		this.cost = d;
	}
}