/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.filter;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

/**
 *
 * @author Administrador
 */
public class MetodoRemplazo implements MethodReplacer {

    public Object reimplement(Object obj, Method method, Object[] objects) throws Throwable {
        System.out.println("Nueva Comunicacion. Method Name: " + method.getName());
        
        System.out.println("Parametro: " + objects[0].toString());
        return Boolean.TRUE;
    }

}
