package org.course.spring;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.course.spring.beans.Contact;
import org.course.spring.beans.ContactImpl;
import org.course.spring.services.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void beforeTest() throws Exception {
		inicializarSpring();
		DataSource datasource = (DataSource) ctx.getBean("dataSource");
		try (Connection connection = datasource.getConnection(); Statement statement = connection.createStatement();) {
            statement.execute("CREATE TABLE contacts (id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY, name VARCHAR(255), comments VARCHAR(255), PRIMARY KEY (ID))");
            connection.commit();
        }
	}
	
	@Test
	public void testExercise() throws Exception {
        cargarDatosPrueba();
        mostrarContactos();
        
        actualizarContacto();
        mostrarContactos();
	}
	
	
	private void inicializarSpring() {
        String[] contextos = { "applicationContext.xml" };
        ctx = new ClassPathXmlApplicationContext(contextos);
        LOGGER.info("Spring se ha inicializado correctamente");
    }
	
	 private void cargarDatosPrueba() {
	        ContactService servicio = (ContactService)ctx.getBean("servicioContactos");
	        for (int i = 0; i < 5; i++) {
	            servicio.insertarContacto(new ContactImpl("Nombre " + i, "Comentario " + i));
	        }
	    }

    private void mostrarContactos() {
        ContactService servicio = (ContactService)ctx.getBean("servicioContactos");
        List<Contact> lista = servicio.getContactos();
        if (lista.size() == 0) {
        	LOGGER.info("No se han encontrado contactos en la base de datos");
        } else {
        	LOGGER.info("Se han encontrado " + lista.size() + " contactos");
            for (Contact c: lista) {
				LOGGER.info("Id del contacto: {}. Nombre: {}. Comentario: {}", new Object[] { c.getId(), c.getNombre(), c.getComentario() });
            }
        }
    }

    private void actualizarContacto() {
    	Contact c = new ContactImpl("Cambiado", "Cambiado");
        c.setId(1);
        ContactService servicio = (ContactService) ctx.getBean("servicioContactos");
        servicio.actualizarContacto(c);
    }
}
