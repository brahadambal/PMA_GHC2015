package com.appzter.core.mgmt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/** * Repository for {@link Person}s */
@Repository
public class CopyOfPersonRepository {
	static final Logger logger = LoggerFactory
			.getLogger(CopyOfPersonRepository.class);
	@Autowired
	MongoTemplate mongoTemplate;

	public void logAllPersons() {
		List<Person> results = mongoTemplate.findAll(Person.class);
		logger.info("Total amount of persons: {}", results.size());
		logger.info("Results: {}", results);
	}

	public void insertPersonWithNameJohnAndRandomAge() { // get random age
															// between 1 and 100
		double age = Math.ceil(Math.random() * 100);
		Person p = new Person("John", (int) age);
		mongoTemplate.insert(p);
	}

	/**
	 * * Create a {@link Person} collection if the collection does not already
	 * exists
	 */
	public void createPersonCollection() {
		if (!mongoTemplate.collectionExists(Person.class)) {
			mongoTemplate.createCollection(Person.class);
		}
	}

	/**
	 * * Drops the {@link Person} collection if the collection does already
	 * exists
	 */
	public void dropPersonCollection() {
		if (mongoTemplate.collectionExists(Person.class)) {
			mongoTemplate.dropCollection(Person.class);
		}
	}
}
