/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring;

import org.course.spring.beans.Rol;
import org.course.spring.beans.Usuario;
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
        
        Usuario usuario = (Usuario)ctx.getBean("usuario");
        
        if (usuario != null){
            System.out.println("Usuario cargado");
        }
        
        for (Rol rol : usuario.getLista()) {
            System.out.println(rol.getRol());
        }
    }

}
