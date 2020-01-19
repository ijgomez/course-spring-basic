package org.course.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

@Aspect
public class TimeProfilerAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeProfilerAspect.class);

    @Around("execution(* *..PersonService.find*(..))")
    public Object calculateTime(ProceedingJoinPoint pjp) throws Throwable {
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
