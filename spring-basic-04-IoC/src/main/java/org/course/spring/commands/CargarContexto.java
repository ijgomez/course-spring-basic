package org.course.spring.commands;

import org.course.spring.utils.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CargarContexto implements Command {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CargarContexto.class);
    
    public void execute() {

        new ClassPathXmlApplicationContext(new String[]{"applicationContext0001.xml"});

        LOGGER.info("Context loaded.");
    }
    
}
