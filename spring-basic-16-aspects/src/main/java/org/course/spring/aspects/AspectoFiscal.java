/*
 * AspectoFiscal.java
 *
 * Created on 26 de junio de 2007, 13:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.course.spring.annotations.Fiscalizable;
import org.course.spring.beans.Cliente;
import org.course.spring.beans.Cuenta;

/**
 *
 * @author Administrador
 */
@Aspect()
public class AspectoFiscal {
    
    /** Creates a new instance of AspectoFiscal */
    public AspectoFiscal() {
    }
    
    @Before("@annotation(fiscalizable) && args(cliente,cuenta,importe)")
    public void ejecutarAspectoError(Fiscalizable fiscalizable, Cliente cliente, Cuenta cuenta, Double importe){
        System.out.println("Operaci�n registrada por un importe de " + importe + " euros.");
        if (importe > fiscalizable.importe()) {
            System.out.println("Esta operaci�n requiere avisar a Hacienda, ya que su importe (" + importe + ") euros, es mayor que el l�mite legal de " + fiscalizable.importe());
        }
    }
}
