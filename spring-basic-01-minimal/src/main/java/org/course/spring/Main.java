package org.course.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		
		LOGGER.info("Context loaded.");
		
	}

}
