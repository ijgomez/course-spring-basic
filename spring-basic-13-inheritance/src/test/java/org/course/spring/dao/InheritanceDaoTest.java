package org.course.spring.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InheritanceDaoTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(InheritanceDaoTest.class);

	private static ApplicationContext ctx;

	@BeforeClass
	public static void beforeInitTesting() {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		LOGGER.info("Contexto cargado");
	}
	
	private InheritanceDao inheritanceDao;
	
	@Before
	public void beforeTest() {
		inheritanceDao = (InheritanceDao) ctx.getBean("inheritanceDao");
	}
	
	@Test
	public void testTest() {
		inheritanceDao.test();
	}

}
