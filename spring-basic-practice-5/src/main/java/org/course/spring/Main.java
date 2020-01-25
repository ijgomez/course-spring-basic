/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring;

import org.course.spring.beans.Rol;
import org.course.spring.beans.User;
import org.course.spring.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class Main {
private ClassPathXmlApplicationContext ctx;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main m = new Main();
        m.init();
        m.execute();
        m.listar();
        System.out.println("Fin de la Aplicacion");
    }

    public void init(){
        String[] paths = {"recursos/applicationContext.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        System.out.println("Contexto cargado");
    }
    
    public void execute(){
        System.out.println("Obteniendo Servicio");
        UserService userServ = (UserService)ctx.getBean("usuarioService");
        
        User usuario = new User();
        usuario.setName("Usuario1");
        
        Rol rol1 = new Rol();
        rol1.setName("Admin");
        usuario.getRoles().add(rol1);
        
        Rol rol2 = new Rol();
        rol2.setName("Consulta");
        usuario.getRoles().add(rol2);
        
        
        userServ.create(usuario);
        
        
    }
    
    public void listar(){
        UserService userServ = (UserService)ctx.getBean("usuarioService");
        
        for (User u :userServ.findAll()){
            System.out.println(u.toString());
        }
    }
}
