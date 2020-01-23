package org.course.spring.aspects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntroduccionImpl implements Introduccion {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntroduccionImpl.class);
	
    public void mensaje() {
    	LOGGER.info("Mensaje del objeto introducido");
    }
}
