package org.course.spring;

import org.course.spring.beans.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		
		LOGGER.info("Context loaded.");
		
		User user = (User) ctx.getBean("user");
		LOGGER.info(user.getName());
	}

}
