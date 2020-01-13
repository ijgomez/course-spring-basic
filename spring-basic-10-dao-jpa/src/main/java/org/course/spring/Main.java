package org.course.spring;

import java.util.Collection;
import java.util.List;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.course.spring.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	private static ClassPathXmlApplicationContext ctx;

	public static void main(String[] args) {
		init();
        ejecutarSpringJpa();
        ejecutarSpringJpaRelaciones();
	}
	
	private static void init() {
        String[] paths = {"applicationContext.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        LOGGER.info("Contexto cargado");
    }
    
    private static void ejecutarSpringJpa() {
        ClientService servicio = (ClientService) ctx.getBean("servicioCliente");
        final Integer MAX_ELEMENTOS = 5;
        for(int i = 0; i < MAX_ELEMENTOS; i++)
            servicio.insertarContacto(new Contact("Nombre" + System.currentTimeMillis()));
        Collection<Contact> todosContactos = servicio.getTodosLosContactos();
        LOGGER.info("se han encontrado {} contactos",todosContactos.size());
        for (Contact contacto : todosContactos) {
            LOGGER.info("El nombre del contacto es {} y su clave es {}",contacto.getName(), contacto.getId());
        }
        for(int i = 0; i < MAX_ELEMENTOS; i++)
            servicio.insertarComercial(new Comercial("Nombre" + System.currentTimeMillis()));
        Collection<Comercial> todosComerciales = servicio.getTodosLosComerciales();
        LOGGER.info("se han encontrado {} comerciales",todosComerciales.size());
        for (Comercial comercial : todosComerciales) {
            LOGGER.info("El nombre del comercial es {} y su clave es {}",comercial.getName(), comercial.getId());
        }
        
    }
    
    private static void ejecutarSpringJpaRelaciones() {
        Comercial comercial = new Comercial("Comercial con contactos" + System.currentTimeMillis());
        Contact contacto = new Contact("Contact para un comercial" + System.currentTimeMillis());
        ClientService servicio = (ClientService) ctx.getBean("servicioCliente");
        servicio.asignarContacto(comercial,contacto);
        List<Contact> contactos = servicio.getContactosDeUnComercial(comercial);
        LOGGER.info("se han encontrado {} contactos",contactos.size());
        for (Contact elem : contactos) {
            LOGGER.info("El nombre del contacto es {} y su clave es {}",elem.getName(), elem.getId());
        }
    }
	
}
