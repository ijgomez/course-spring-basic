package org.course.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class IntroduccionAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IntroduccionAspect.class);
    
	@DeclareParents(value = "org.course.spring.beans.*+", defaultImpl = IntroduccionImpl.class)
    public static Introduccion mixin;

    @Before("execution(* *..Person.set*(..)) && this(ejemploIntroduccion) && args(unNombre)")
    public void usoIntroduccion(Introduccion ejemploIntroduccion, String unNombre) {
        ejemploIntroduccion.mensaje();
        LOGGER.info("El nombre de la persona es " + unNombre);
    }

}
