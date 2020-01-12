package org.course.spring;

import java.util.List;

import org.course.spring.beans.Contact;
import org.course.spring.beans.ContactImpl;
import org.course.spring.services.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	private static ClassPathXmlApplicationContext ctx;

	public static void main(String[] args) {
		inicializarSpring();
        cargarDatosPrueba();
        mostrarContactos();
        actualizarContacto();
        mostrarContactos();
	}
	
	private static void inicializarSpring() {
        String[] contextos = { "applicationContext.xml" };
        ctx = new ClassPathXmlApplicationContext(contextos);
        LOGGER.info("Spring se ha inicializado correctamente");
    }

    private static void mostrarContactos() {
        ContactService servicio = (ContactService)ctx.getBean("servicioContactos");
        List<Contact> lista = servicio.getContactos();
        if (lista.size() == 0) {
        	LOGGER.info("No se han encontrado contactos en la base de datos");
        } else {
        	LOGGER.info("Se han encontrado " + lista.size() + " contactos");
            for (Contact c: lista) {
                System.out.printf("Id del contacto: %d. Nombre: %s. Comentario: %s\n",  c.getId(), c.getNombre(), c.getComentario());
            }
        }
    }

    private static void cargarDatosPrueba() {
        ContactService servicio = (ContactService)ctx.getBean("servicioContactos");
        for (int i = 0; i < 5; i++) {
            servicio.insertarContacto(new ContactImpl("Nombre " + i, "Comentario " + i));
        }
    }

    private static void actualizarContacto() {
    	Contact c = new ContactImpl("Cambiado", "Cambiado");
        c.setId(1);
        ContactService servicio = (ContactService)ctx.getBean("servicioContactos");
        servicio.actualizarContacto(c);
    }
	
}
