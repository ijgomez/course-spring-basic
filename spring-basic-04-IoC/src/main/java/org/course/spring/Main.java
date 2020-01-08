package org.course.spring;

import org.course.spring.utils.CommandFactory;
import org.course.spring.utils.CommandType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		LOGGER.info("Context loaded.");
		
		LOGGER.info("*************Ejemplo 1*************");
        CommandFactory.getInstancia().getCommand(CommandType.LOAD_CONTEXT).execute();
        LOGGER.info("***********************************");
        
        LOGGER.info("*************Ejemplo 2*************");
        CommandFactory.getInstancia().getCommand(CommandType.INSTANCE_BEAN).execute();
        LOGGER.info("***********************************");
        
        LOGGER.info("*************Ejemplo 3*************");
        CommandFactory.getInstancia().getCommand(CommandType.INYECTION_BEAN).execute();
        LOGGER.info("***********************************");
	}

}
