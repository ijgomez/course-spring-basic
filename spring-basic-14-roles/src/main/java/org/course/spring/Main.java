package org.course.spring;

import java.util.List;

import org.course.spring.beans.Rol;
import org.course.spring.beans.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	private static ApplicationContext ctx;
	
	public static void main(String[] args) {
		initSpring();
        testUsuariosRoles();
	}
	
	private static void initSpring() {
        String[] paths = {"recursos/applicationContext.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        System.out.println("Contexto cargado");
    }

    private static void testUsuariosRoles() {
        Usuario usuario = (Usuario) ctx.getBean("usuario");
        System.out.println(usuario);
        List<Rol> listaRoles = usuario.getRoles();
        for (Rol rol : listaRoles) {
            System.out.println(rol);
        }
    }
}
