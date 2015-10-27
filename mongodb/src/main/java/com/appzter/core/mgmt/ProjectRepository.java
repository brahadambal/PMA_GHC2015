package com.appzter.core.mgmt;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/** * Repository for {@link Project}s */
@Repository
public class ProjectRepository {
	static final Logger logger = LoggerFactory
			.getLogger(ProjectRepository.class);
	@Autowired
	MongoTemplate mongoTemplate;

	public void logAllProjects() {
		
		List<Project> results = mongoTemplate.findAll(Project.class);
		List<Fund> Fundresults = mongoTemplate.findAll(Fund.class);
		logger.info("Total amount of project {}", results.size());
		logger.info("Results: {}", results);
		logger.info("Fundresults: {}", Fundresults);
	}

	public void insertProject(String projectName, String projectID, Double fund) {
		double random = Math.ceil(Math.random() * 100);
		String parentID = "P"+random;
				
		Instance I1 = new Instance("I1",  projectName, "Bengaluru", parentID, 10000.00);
		Instance I2 = new Instance("I2",  projectName, "Mysuru", parentID, 5000.00);
		
		List<Instance> InstanceList= new ArrayList<Instance>();
		InstanceList.add(I1);
		InstanceList.add(I2);
		
		Project p = new Project("P1", InstanceList, "GirlChildToSchool", 25000.00, "P"+random);
		mongoTemplate.insert(I1);
		mongoTemplate.insert(I2);
		mongoTemplate.insert(p);
	}

	/**
	 * * Create a {@link Project} collection if the collection does not already
	 * exists
	 */
	public void createProjectCollection() {
		if (!mongoTemplate.collectionExists(Fund.class)) {
			mongoTemplate.createCollection(Fund.class);
		}
		if (!mongoTemplate.collectionExists(Project.class)) {
			mongoTemplate.createCollection(Project.class);
		}
	}

	/**
	 * * Drops the {@link Project} collection if the collection does already
	 * exists
	 */
	public void dropProjectCollection() {
		if (mongoTemplate.collectionExists(Fund.class)) {
			mongoTemplate.dropCollection(Fund.class);
		}
		if (mongoTemplate.collectionExists(Project.class)) {
			mongoTemplate.dropCollection(Project.class);
		}
	}
}