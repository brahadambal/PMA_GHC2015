package com.appzter.core.mgmt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/** * Repository for {@link Person}s */
@Repository("personRepository")
public class PersonRepository {
	static final Logger logger = LoggerFactory
			.getLogger(PersonRepository.class);
	@Autowired
	MongoTemplate mongoTemplate;

	public void logAllPersons() {
		List<Person> results = mongoTemplate.findAll(Person.class);
		logger.info("Total number of persons: {}", results.size());
		logger.info("Results: {}", results);
	}

	public void insertPerson(String name, int age, String instanceId, String projectId, String gender, String address, String mobile, double salary) {
		Person p = new Person(name, age, instanceId, projectId, gender, address, mobile, salary);
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
