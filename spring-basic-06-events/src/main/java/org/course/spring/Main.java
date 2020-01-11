package org.course.spring;

import org.course.spring.events.MyApplicationContextAware;
import org.course.spring.lifecicle.UserFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	private static ClassPathXmlApplicationContext ctx;

	public static void main(String[] args) {
		cargarContexto();
        provocarEvento();
        probarFactoria();
	}
	
	private static void cargarContexto() {
        String[] paths = {"applicationContext.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        LOGGER.info("Contexto cargado");
        ctx.registerShutdownHook();
    }

    private static void probarFactoria() {
        UserFactoryBean factoriaUsuarioBean = (UserFactoryBean) ctx.getBean("factoriaUsuarioBean");
        LOGGER.info("Primer usuario:{}", factoriaUsuarioBean.getNewUser());
        LOGGER.info("Segundo usuario:{}", factoriaUsuarioBean.getNewUser());
    }

    private static void provocarEvento() {
        MyApplicationContextAware demoBean = (MyApplicationContextAware) ctx.getBean("demoBean");
        demoBean.generarEvento();
    }

}
