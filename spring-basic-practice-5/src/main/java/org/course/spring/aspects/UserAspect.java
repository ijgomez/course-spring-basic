package org.course.spring.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class UserAspect {

	
    @Pointcut("execution(* dao.*.*(..))")
    public void puntoDeCorte1(){
        
    }
    
    
    @Before("puntoDeCorte1()")
    public void imprinirTrazaAnterior(){
       log.info(">>>>>>>>>>>>>> Before.");
    }
    
    @After("puntoDeCorte1()")
    public void imprinirTrazaPosteror(){
       
       log.info("<<<<<<<<<<<<<< After. ");
    }
}
