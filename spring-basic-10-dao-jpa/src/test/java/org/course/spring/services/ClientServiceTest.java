package org.course.spring.services;

import java.util.Collection;
import java.util.List;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceTest.class);

	private static ApplicationContext ctx;

	@BeforeClass
	public static void beforeInitTesting() {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		LOGGER.info("Contexto cargado");
		loadDataTest();
	}
	
	private static void loadDataTest() {
		ClientService clientService = (ClientService) ctx.getBean("clientService");
		final Integer MAX_ELEMENTOS = 5;
        for(int i = 0; i < MAX_ELEMENTOS; i++) {
            clientService.create(new Contact("Name" + System.currentTimeMillis()));
        }
        
        for(int i = 0; i < MAX_ELEMENTOS; i++) {
        	clientService.create(new Comercial("Name" + System.currentTimeMillis()));
        }
            
	}
	
	private ClientService clientService;

	@Before
	public void beforeTest() {
		clientService = (ClientService) ctx.getBean("clientService");
	}

	@Test
	public void testFindAllContacts() {
		Collection<Contact> contacts = clientService.findAllContacts();
        LOGGER.info("se han encontrado {} contacts",contacts.size());
        for (Contact contact : contacts) {
            LOGGER.info("El nombre del contacto es {} y su clave es {}",contact.getName(), contact.getId());
        }
	}

	@Test
	public void testFindAllComercials() {
		Collection<Comercial> comercials = clientService.findAllComercials();
        LOGGER.info("se han encontrado {} comercials",comercials.size());
        for (Comercial comercial : comercials) {
        	LOGGER.info("El nombre del comercial es {} y su clave es {}",comercial.getName(), comercial.getId());
        }
	}
	
	@Test
	public void testAssociate() {
		Comercial comercial = new Comercial("Comercial con contactos" + System.currentTimeMillis());
        Contact contact = new Contact("Contact para un comercial" + System.currentTimeMillis());

        clientService.associate(comercial,contact);
        
        List<Contact> contacts = clientService.findContactsBy(comercial);
        LOGGER.info("se han encontrado {} contactos",contacts.size());
        for (Contact c : contacts) {
            LOGGER.info("El nombre del contacto es {} y su clave es {}",c.getName(), c.getId());
        }
	}

}
