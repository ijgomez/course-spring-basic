/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author Administrador
 */
@Aspect
public class UsuarioAspectos {

    @Pointcut("execution(* dao.*.*(..))")
    public void puntoDeCorte1(){
        
    }
    
    
    @Before("puntoDeCorte1()")
    public void imprinirTrazaAnterior(){
       
       System.err.println(">>>>>>>>>>>>>> Before.");
    }
    
    @After("puntoDeCorte1()")
    public void imprinirTrazaPosteror(){
       
       System.err.println("<<<<<<<<<<<<<< After. ");
    }
}
