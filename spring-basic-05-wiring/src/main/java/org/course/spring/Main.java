package org.course.spring;

import org.course.spring.beans.Departament;
import org.course.spring.beans.Employee;
import org.course.spring.beans.TeamLeader;
import org.course.spring.beans.User;
import org.course.spring.commands.CommandManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		cargarContexto();
        cargarContextoPersona();
        cargarContextoPersonaSingleton();
        cargarContextoPersonaPrototipo();
        cargarContextoInyectar();
        cargarContextoAuto();
        cargarContextoInyectarMetodo();
        
	}
	
	private static void cargarContexto() {
        String[] paths = { "applicationContext.xml" };
        new ClassPathXmlApplicationContext(paths);
        LOGGER.info("Contexto vacío cargado");
    }

    private static void cargarContextoPersona() {
        String[] paths = { "beansContext.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        LOGGER.info("Contexto con factoría cargado");
        User defecto = (User)ctx.getBean("personaDefecto");
        LOGGER.info("{}", defecto);
        User factoria = (User)ctx.getBean("personaFactoria");
        LOGGER.info("{}", factoria);
    }

    private static void cargarContextoPersonaSingleton() {
        String[] paths = { "beansContext.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        LOGGER.info("Contexto usando singletons cargado");
        User defecto1 = (User)ctx.getBean("personaDefecto");
        LOGGER.info("{},{}\n", defecto1, defecto1.hashCode());
        User defecto2 = (User)ctx.getBean("personaDefecto");
        LOGGER.info("{},{}\n", defecto2, defecto2.hashCode());
    }

    private static void cargarContextoPersonaPrototipo() {
        String[] paths = { "beansContext.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        LOGGER.info("Contexto usando prototipos cargado");
        User defecto1 = (User)ctx.getBean("personaPrototipo");
        LOGGER.info("{},{}\n", defecto1, defecto1.hashCode());
        User defecto2 = (User)ctx.getBean("personaPrototipo");
        LOGGER.info("{},{}\n", defecto2, defecto2.hashCode());
    }

    private static void cargarContextoInyectar() {
        String[] paths = { "beansContext.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        LOGGER.info("Contexto usando inyección cargado");
        Employee defecto1 = (Employee)ctx.getBean("empleadoUno");
        LOGGER.info("{}", defecto1);
        Employee defecto2 = (Employee)ctx.getBean("empleadoDos");
        LOGGER.info("{}", defecto2);
        Departament departamento = (Departament)ctx.getBean("departamento");
        LOGGER.info("{}", departamento);
    }

    private static void cargarContextoAuto() {
        String[] paths = { "autoContext.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        LOGGER.info("Contexto usando auto enlace cargado");
        TeamLeader jefe1 = (TeamLeader)ctx.getBean("jefeUno");
        LOGGER.info("{}", jefe1);
    }

    private static void cargarContextoInyectarMetodo() {
        String[] paths = { "metodoContext.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        LOGGER.info("Contexto usando inyección de métodos cargado");
        CommandManager gestorComandos = (CommandManager)ctx.getBean("gestorComandos");
        gestorComandos.execute("Esta orden");
        gestorComandos.otherMethod();
        CommandManager gestorComandos1 = (CommandManager)ctx.getBean("gestorComandos1");
        gestorComandos1.execute("Aquella orden");
        gestorComandos1.otherMethod();
    }

}
