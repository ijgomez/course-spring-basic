package org.course.spring;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.course.spring.beans.Contact;
import org.course.spring.beans.ContactImpl;
import org.course.spring.services.ContactService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	private static ClassPathXmlApplicationContext ctx;
	
	@BeforeClass
	public static void before() throws Exception {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        LOGGER.info("Spring se ha inicializado correctamente");
        
		DataSource datasource = (DataSource) ctx.getBean("dataSource");
		try (Connection connection = datasource.getConnection(); Statement statement = connection.createStatement();) {
            statement.execute("CREATE TABLE contacts (id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY, name VARCHAR(255), comments VARCHAR(255), PRIMARY KEY (ID))");
            connection.commit();
        }
		
		ContactService servicio = (ContactService)ctx.getBean("contactService");
        for (int i = 0; i < 5; i++) {
            servicio.create(new ContactImpl("Nombre " + i, "Comentario " + i));
        }
	}
	
	private ContactService contactService;
	
	@Before
	public void beforeTest() throws Exception {
		contactService = (ContactService) ctx.getBean("contactService");
	}

	@Test
	public void testMostrarContactos() throws Exception  {
        List<Contact> lista = contactService.findAll();
        if (lista.size() == 0) {
        	LOGGER.info("No se han encontrado contactos en la base de datos");
        } else {
        	LOGGER.info("Se han encontrado " + lista.size() + " contactos");
            for (Contact c: lista) {
				LOGGER.info("Id del contacto: {}. Nombre: {}. Comentario: {}", new Object[] { c.getId(), c.getNombre(), c.getComentario() });
            }
        }
    }
	
	@Test
	public void testActualizarContacto() throws Exception  {
    	Contact c = new ContactImpl("Cambiado", "Cambiado");
        c.setId(1);

        contactService.update(c);
    }
}
