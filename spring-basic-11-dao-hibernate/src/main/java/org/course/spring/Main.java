package org.course.spring;

import java.util.List;
import java.util.logging.Level;

import org.course.spring.beans.Aficion;
import org.course.spring.beans.Persona;
import org.course.spring.services.ServicioPersona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	private static ClassPathXmlApplicationContext ctx;

	public static void main(String[] args) {
		cargarContexto();
        cargarDatosPrueba();
        probarAccesoDatos();
        probarAspectoRecuperacion();
	}
	
	private static void cargarContexto() {
        String[] paths = 
        { "applicationContext.xml", "daoContext.xml", 
          "aspectosContext.xml" };
        ctx = new ClassPathXmlApplicationContext(paths);
        System.out.println("Contexto cargado");
    }

    private static void probarAccesoDatos() {
        ServicioPersona s = (ServicioPersona)ctx.getBean("servicioPersona");
        System.out.printf("Hay %d personas en la base de datos\n", 
                          s.getNumeroDePersonas());
        System.out.println("************************************************");
        System.out.println("Personas en la base de datos");
        for (Persona una: s.getPersonas()) {
            System.out.println(una);
        }
        System.out.println("************************************************");
        System.out.println("Personas en la base de datos cuyo nombre contiene la letra 'p'");
        for (Persona una: s.getPorNombreParecido("p")) {
            System.out.println(una);
        }
        System.out.println("************************************************");
        System.out.println("Datos de la persona con id 1");
        Persona p = s.getPersona(1);
        System.out.println(p);
        System.out.println("************************************************");
        System.out.println("Borrando a aa persona con id = 1");
        s.deletePersona(p);
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2");
        List<Aficion> aficiones = s.getAficiones(2);
        for (Aficion aficion: aficiones) {
            System.out.println(aficion);
        }
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2 obtenidas de otra manera");
        aficiones = s.getAficionesDeOtraManera(2);
        for (Aficion aficion: aficiones) {
            System.out.println(aficion);
        }
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2 de una tercera forma");
        aficiones = s.getAficionesDeOtraManeraMas(2);
        for (Aficion aficion: aficiones) {
            System.out.println(aficion);
        }
        System.out.println("************************************************");
    }

    private static void cargarDatosPrueba() {
        ServicioPersona s = (ServicioPersona)ctx.getBean("servicioPersona");
        LOGGER.info("Servicio de personas encontrado");
        for (int i = 0; i < 10; i++) {
            Persona p = new Persona();
            p.setNombre("pepe" + i);
            Aficion a = new Aficion();
            a.setNombre("Afici�n" + i);
            a.setPersona(p);
            p.getAficionesInternas().add(a);
            s.insertPersona(p);
        }
        System.out.println("************************************************");
    }

    private static void probarAspectoRecuperacion() {
        ServicioPersona s = (ServicioPersona)ctx.getBean("servicioPersona");
        System.out.println("Probando el aspecto de recuperaci�n...");
        try {
            Persona p = s.getPersona(20000);
        } catch (DataAccessException e) {
            System.out.println("Excepci�n de tipo DataAccessException");
        }
    }
	
}
