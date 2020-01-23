package org.course.spring.aspects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EjemploIntroduccionImpl implements EjemploIntroduccion {

	private static final Logger LOGGER = LoggerFactory.getLogger(EjemploIntroduccionImpl.class);
	
    public void mensaje() {
    	LOGGER.info("Mensaje del objeto introducido");
    }
}
