/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring;

import org.course.spring.beans.Rol;
import org.course.spring.beans.Usuario;
import org.course.spring.services.UsuarioService;
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
        UsuarioService userServ = (UsuarioService)ctx.getBean("usuarioService");
        
        Usuario usuario = new Usuario();
        usuario.setNombre("Usuario1");
        
        Rol rol1 = new Rol();
        rol1.setRol("Admin");
        usuario.getLista().add(rol1);
        
        Rol rol2 = new Rol();
        rol2.setRol("Consulta");
        usuario.getLista().add(rol2);
        
        userServ.addUsuario(usuario);
        
        
    }
    
    public void listar(){
        UsuarioService userServ = (UsuarioService)ctx.getBean("usuarioService");
        
        for (Usuario u :userServ.getListaUsuarios()){
            System.out.println(u.toString());
        }
    }
}
