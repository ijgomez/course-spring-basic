package org.course.spring.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.course.spring.annotations.Registrable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect()
public class RegistryAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistryAspect.class);

    @After("@annotation(registrable) && args(..,amount)")
    public void ejecutarAspectoError(Registrable registrable, Double amount){
        LOGGER.info("Operación registrada por un importe de " + amount + " euros.");
        if (registrable.siHayError()) {
        	LOGGER.info("Esta operación debe registrarse en otro sitio en caso de que falle");
        }
    }
}
