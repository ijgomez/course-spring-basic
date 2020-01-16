/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring;

import org.course.spring.beans.Comunicacion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] paths = {"recursos/applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        
        Comunicacion c = (Comunicacion)ctx.getBean("comunicacion");
        System.out.println("Comunicar: " + c.comunicar("Mensaje para Spring"));
    }

    
    
}
