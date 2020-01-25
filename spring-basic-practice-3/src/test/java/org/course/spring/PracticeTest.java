package org.course.spring;

import org.course.spring.beans.Comunicacion;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(PracticeTest.class);

	@Test
	public void testPractice() throws Exception {

		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });) {

			Comunicacion c = (Comunicacion) ctx.getBean("comunicacion");
			LOGGER.info("Comunicar: " + c.comunicar("Mensaje para Spring"));

		}

	}
}
