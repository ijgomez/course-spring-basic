package org.course.spring;

import org.course.spring.services.TestHerencia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	private static ClassPathXmlApplicationContext ctx;

	public static void main(String[] args) {
		initSpring();
        test();
	}
	
	 private static void initSpring() {
	        ctx = new ClassPathXmlApplicationContext("recursos/applicationContext.xml");
	        System.out.println("Contexto Cargado");
	    }

	    private static void test() {
	        TestHerencia t = (TestHerencia) ctx.getBean("testHerencia");
	        t.test();
	    }

	
}
