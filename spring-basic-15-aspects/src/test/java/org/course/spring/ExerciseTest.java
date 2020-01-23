package org.course.spring;

import org.course.spring.aspects.EjemploIntroduccion;
import org.course.spring.beans.Person;
import org.course.spring.services.WelcomeService;
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
	
	private WelcomeService welcomeService;
	
	@Before
	public void beforeTest() {
		welcomeService = (WelcomeService) ctx.getBean("welcomeService");
	}

	@Test
	public void testEjecucionAspectoAfterReturning() {
		welcomeService.principalAfterReturning();
    }

	@Test
	public void testEjecucionAspectoBefore() {
		welcomeService.principalBefore();
    }

	@Test
	public void testEjecucionAspectoAfter() {
		welcomeService.principalAfter();
    }

	@Test(expected = Exception.class)
	public void testEjecucionAspectoAfterThrowing() {
		welcomeService.metodoPublicoCualquiera();
    }

	@Test
	public void testEjecucionAspectoAround() {
		welcomeService.metodoLento();
    }

	@Test
	public void testEjecucionAspectoBeforeConParametro() {
		welcomeService.principalBefore(7);
    }
	
	@Test
	public void testEjecucionAspectoIntroduccion() {
        Person persona = (Person) ctx.getBean("person");
        persona.setName("Un nombre");
        EjemploIntroduccion ejemploIntroduccion = (EjemploIntroduccion) ctx.getBean("person");
        ejemploIntroduccion.mensaje();
    }

}
