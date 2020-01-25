package org.course.spring;

import org.course.spring.beans.Rol;
import org.course.spring.beans.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PracticeTest.class);

	@Test
	public void testPractice() throws Exception {

		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });) {
			User usuario = (User) ctx.getBean("user");

			if (usuario != null) {
				LOGGER.info("User cargado");
			}

			for (Rol rol : usuario.getRoles()) {
				LOGGER.info(rol.getName());
			}
		}
	
	}
}
