package org.course.spring.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

@Aspect
public class Recuperacion {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Recuperacion.class);

    @AfterThrowing(pointcut = "execution(* *..PersonService.read(..))",  throwing = "ex")
    public void realizarRecuperacion(DataAccessException ex) {
    	LOGGER.error("Ha ocurrido un error al acceder a datos: {}", ex);
    }
}
