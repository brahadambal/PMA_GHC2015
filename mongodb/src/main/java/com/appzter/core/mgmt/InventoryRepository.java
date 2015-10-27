package com.appzter.core.mgmt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/** * Repository for {@link Person}s */
@Repository("inventoryRepository")
public class InventoryRepository {
	static final Logger logger = LoggerFactory
			.getLogger(InventoryRepository.class);
	@Autowired
	MongoTemplate mongoTemplate;

	public void logAllInstacess() {
		List<Inventory> results = mongoTemplate.findAll(Inventory.class);
		logger.info("Total amount of Inventorys: {}", results.size());
		logger.info("Results: {}", results);
	}

	public void insertInventory() {
		Inventory Inv = new Inventory("book", "I1", "GirlChildToSchool", 100.00);
		mongoTemplate.insert(Inv);
	}

	/**
	 * * Create a {@link Person} collection if the collection does not already
	 * exists
	 */
	public void createInventoryCollection() {
		if (!mongoTemplate.collectionExists(Inventory.class)) {
			mongoTemplate.createCollection(Inventory.class);
		}
	}

	/**
	 * * Drops the {@link Person} collection if the collection does already
	 * exists
	 */
	public void dropInventoryCollection() {
		if (mongoTemplate.collectionExists(Inventory.class)) {
			mongoTemplate.dropCollection(Inventory.class);
		}
	}
	
	/**
	 * Edit existing Inventory collection
	 */
	public void editInventoryCollection() {
		
	
	}
}
