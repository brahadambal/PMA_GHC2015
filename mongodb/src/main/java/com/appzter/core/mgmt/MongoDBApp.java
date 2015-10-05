package com.appzter.core.mgmt;

import java.net.UnknownHostException;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** * Small MongoDB application that uses spring data to interact with MongoDB. */
public class MongoDBApp {
	static final Logger logger = LoggerFactory.getLogger(MongoDBApp.class);

	
	public static void main(String[] args) throws UnknownHostException {
		BasicConfigurator.configure();
		logger.info("Bootstrapping MongoDemo application");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/spring/applicationContext.xml");
		PersonRepository personRepository = context
				.getBean(PersonRepository.class); // cleanup person collection
													// before insertion
		personRepository.dropPersonCollection(); // create person collection<br
													// />
		personRepository.createPersonCollection();
		for (int i = 0; i < 20; i++) {
			personRepository.insertPersonWithNameJohnAndRandomAge();
		}
		personRepository.logAllPersons();
		
		
		ProjectRepository projectRepository = context
				.getBean(ProjectRepository.class); // cleanup person collection
													// before insertion
		projectRepository.dropProjectCollection(); // create person collection<br
													// />
		projectRepository.createProjectCollection();
		for (int i = 0; i < 20; i++) {
			projectRepository.insertProject("i"+i, "ID"+i, new Double(1000));
		}
		projectRepository.logAllProjects();
				
	}
}