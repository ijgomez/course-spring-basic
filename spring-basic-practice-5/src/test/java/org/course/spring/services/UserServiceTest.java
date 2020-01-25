package org.course.spring.services;

import java.util.ArrayList;

import org.course.spring.beans.Rol;
import org.course.spring.beans.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);
	
	private static ClassPathXmlApplicationContext ctx;
	
	@BeforeClass
	public static void init() {
        ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        LOGGER.info("Contexto cargado");
	}
	
	private UserService userService;
	
	@Before
	public void beforeTest() {
		userService = (UserService) ctx.getBean("userService");
	}

	@Test
	public void testFindAll() {
		for (User u : userService.findAll()){
            LOGGER.info(u.toString());
        }
	}

	@Test
	public void testCreate() {
		User usuario = new User();
        usuario.setName("Usuario1");
        usuario.setRoles(new ArrayList<>());
        
        Rol rol1 = new Rol();
        rol1.setName("Admin");
        usuario.getRoles().add(rol1);
        
        Rol rol2 = new Rol();
        rol2.setName("Consulta");
        usuario.getRoles().add(rol2);
        
        userService.create(usuario);
	}

	

}
