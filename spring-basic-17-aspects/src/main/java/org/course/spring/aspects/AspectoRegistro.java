package org.course.spring.aspects;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.course.spring.annotations.Registrable;

/*
 * AspectoRegistro.java
 *
 * Created on 26 de junio de 2007, 13:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
@Aspect()
public class AspectoRegistro {
    
    /** Creates a new instance of AspectoRegistro */
    public AspectoRegistro() {
    }
    
    @After("@annotation(registrable) && args(..,importe)")
    public void ejecutarAspectoError(Registrable registrable, Double importe){
        System.out.println("Operaci�n registrada por un importe de " + importe + " euros.");
        if (registrable.siHayError()) {
            System.out.println("Esta operaci�n debe registrarse en otro sitio en caso de que falle");
        }
    }
}
