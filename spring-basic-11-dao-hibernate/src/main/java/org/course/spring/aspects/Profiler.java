package org.course.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.util.StopWatch;

@Aspect
public class Profiler {
    public Profiler() {
    }

    @Around("execution(* *..ServicioPersona.get*(..))")
    public Object calcularTiempo(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch clock = new StopWatch("Calculando tiempo de ejecuci�n...");
        try {
            clock.start(pjp.toShortString());
            return pjp.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
    }
}
