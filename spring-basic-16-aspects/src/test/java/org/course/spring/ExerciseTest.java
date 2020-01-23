package org.course.spring;

import org.course.spring.beans.ClientImpl;
import org.course.spring.beans.AccountImpl;
import org.course.spring.services.ClientService;
import org.junit.Before;
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
	
	private ClientService clientService;
	
	@Before
	public void beforeTest() {
		clientService = (ClientService) ctx.getBean("clientService");
	}

	@Test
	public void testExercise() {
		
        clientService.ingresar(new ClientImpl(), new AccountImpl(), 6000.0d);
        clientService.reintegrar(new ClientImpl(), new AccountImpl(), 5000.0d);
    }

}
