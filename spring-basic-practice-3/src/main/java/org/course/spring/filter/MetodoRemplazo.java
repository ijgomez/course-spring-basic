package org.course.spring.filter;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.MethodReplacer;

public class MetodoRemplazo implements MethodReplacer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MetodoRemplazo.class);

    public Object reimplement(Object obj, Method method, Object[] objects) throws Throwable {
        
    	LOGGER.info("Nueva Comunicacion. Method Name: " + method.getName());
        
    	LOGGER.info("Parametro: " + objects[0].toString());
    	
        return Boolean.TRUE;
    }

}
