package com.appzter.core.mgmt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/** * Repository for {@link Person}s */
@Repository("instanceRepository")
public class InstanceRepository {
	static final Logger logger = LoggerFactory
			.getLogger(InstanceRepository.class);
	@Autowired
	MongoTemplate mongoTemplate;

	public void logAllInstacess() {
		List<Instance> results = mongoTemplate.findAll(Instance.class);
		logger.info("Total amount of instances: {}", results.size());
		logger.info("Results: {}", results);
	}

	public void insertInstanceWithName() { // get random id
		double random = Math.ceil(Math.random() * 100);
		String parentID ="blah"+random;
		Instance i = new Instance("1", "A", "Bengaluru", parentID, 25000.00);
		mongoTemplate.insert(i);
	}

	/**
	 * * Create a {@link Person} collection if the collection does not already
	 * exists
	 */
	public void createInstanceCollection() {
		if (!mongoTemplate.collectionExists(Instance.class)) {
			mongoTemplate.createCollection(Instance.class);
		}
	}

	/**
	 * * Drops the {@link Person} collection if the collection does already
	 * exists
	 */
	public void dropInstanceCollection() {
		if (mongoTemplate.collectionExists(Instance.class)) {
			mongoTemplate.dropCollection(Instance.class);
		}
	}
	
	/**
	 * Edit existing instance collection
	 */
	public void editInstanceCollection() {
		
	
	}
}
