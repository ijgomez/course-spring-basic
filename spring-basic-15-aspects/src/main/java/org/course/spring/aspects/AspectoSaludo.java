package org.course.spring.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.util.StopWatch;


@Aspect
public class AspectoSaludo {
    private Log log = LogFactory.getLog(this.getClass());

    @Pointcut("execution(* principalAfter(..))")
    public void metodoAfter() {
    }

    @After("metodoAfter()")
    public void saludoAfter() {
        System.out.println("Mensaje de saludo after");
    }

    @Pointcut("execution(public * *(..))")
    public void metodoAfterThrowing() {
    }

    @AfterThrowing(pointcut = "metodoAfterThrowing()", throwing = "ex")
    public void logExcepcion(Exception ex) {
        log.info("Ha ocurrido un error: " + ex.getMessage());
    }

    @AfterReturning(pointcut = "execution(* principalAfterReturning(..))", 
                    returning = "valor")
    public void saludoAfterReturning(Long valor) {
        System.out.println("Mensaje de saludo after returning");
        System.out.println("Valor devuelto: " + valor);
    }

    @Pointcut("execution(public void springaspectos0001.basico.ServicioSaludo.*Before())")
    public void metodoBefore() {
    }

    @Before("metodoBefore()")
    public void saludoBefore() {
        System.out.println("Mensaje de saludo before");
    }

    @Pointcut("execution(* *Before(..)) && args(unInteger)")
    public void metodoBeforeConParametro(Integer unInteger) {
    }

    @Before("metodoBeforeConParametro(unInteger)")
    public void saludoBeforeConParametro(Integer unInteger) {
        System.out.println("Mensaje de saludo before con un par�metro que vale " + unInteger);
    }
    
    @Around("execution(* metodoLento(..))")
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
