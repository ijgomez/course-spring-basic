package org.course.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;


@Aspect
public class WelcomeAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeAspect.class);

    @Pointcut("execution(* principalAfter(..))")
    public void metodoAfter() {
    	
    }

    @After("metodoAfter()")
    public void saludoAfter() {
        LOGGER.info("Mensaje de saludo after");
    }

    @Pointcut("execution(public * *(..))")
    public void metodoAfterThrowing() 
    {
    }

    @AfterThrowing(pointcut = "metodoAfterThrowing()", throwing = "ex")
    public void logExcepcion(Exception ex) {
    	LOGGER.error("Ha ocurrido un error: {}", ex.getMessage());
    }

    @AfterReturning(pointcut = "execution(* principalAfterReturning(..))", returning = "value")
    public void saludoAfterReturning(Long value) {
    	LOGGER.info("Mensaje de saludo after returning");
    	LOGGER.info("Valor devuelto: " + value);
    }

    @Pointcut("execution(public void org.course.spring.services.WelcomeService.*Before())")
    public void metodoBefore() {
    }

    @Before("metodoBefore()")
    public void saludoBefore() {
    	LOGGER.info("Mensaje de saludo before");
    }

    @Pointcut("execution(* *Before(..)) && args(unInteger)")
    public void metodoBeforeConParametro(Integer unInteger) {
    }

    @Before("metodoBeforeConParametro(unInteger)")
    public void saludoBeforeConParametro(Integer unInteger) {
    	LOGGER.info("Mensaje de saludo before con un parámetro que vale " + unInteger);
    }
    
    @Around("execution(* metodoLento(..))")
    public Object calcularTiempo(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch clock = new StopWatch("Calculando tiempo de ejecución...");
        try {
            clock.start(pjp.toShortString());
            return pjp.proceed();
        } finally {
            clock.stop();
            LOGGER.info(clock.prettyPrint());
        }
    }
}
