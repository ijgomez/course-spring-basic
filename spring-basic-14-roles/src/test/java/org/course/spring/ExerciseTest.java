package org.course.spring;

import java.util.List;

import org.course.spring.beans.Rol;
import org.course.spring.beans.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	private static ApplicationContext ctx;

	@BeforeClass
	public static void beforeInitTesting() {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		LOGGER.info("Contexto cargado");
	}
	
	@Test
	public void testTest() {
		User user = (User) ctx.getBean("user");
		LOGGER.info("{}", user);
        List<Rol> roles = user.getRoles();
        for (Rol rol : roles) {
        	LOGGER.info("{}", rol);
        }
	}

}
