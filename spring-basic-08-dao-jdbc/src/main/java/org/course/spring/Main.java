package org.course.spring;

import java.util.Collection;

import org.course.spring.beans.User;
import org.course.spring.beans.UserImpl;
import org.course.spring.dao.UserDao;
import org.course.spring.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	private static ClassPathXmlApplicationContext ctx;

	public static void main(String[] args) {
		try {
			init();
			ejecutarJdbcSpring();
			ejecutarInsercionDevolviendoLaClavePrimaria();
		} catch (UserException ex) {
			LOGGER.error("{}", ex);
		}
	}
	
	private static void init() {
        String paths[] = {"applicationContext-jdbc.xml","applicationContext-tx.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        LOGGER.info("Contexto jdbc cargado");
    }
    
    private static void ejecutarJdbcSpring() throws UserException {
        final int MAX_PERSONAS = 5;
        UserDao personaDao = (UserDao) ctx.getBean("personaDao");
        LOGGER.info("Insertando algunas personas en la base de datos...");
        for(int i = 0; i < MAX_PERSONAS; i++){
            personaDao.create(new UserImpl(i,"nombre"+i));
        }
        LOGGER.info("Se han encontrado {} personas en la base de datos",personaDao.countAll());
        LOGGER.info("Se han encontrado {} personas en la base de datos cuyo nombre empieza por {}",personaDao.countByName("n"),"n");
        final Integer id = 3;
        LOGGER.info("Buscando una persona con Id = " + id);
        User p;
        try {
            p = personaDao.read(id);
            LOGGER.info("Id %d. Nombre %s\n",p.getId(),p.getName());
        } catch (DataAccessException ex) {
            LOGGER.info("No se ha encontrado a nadie con el identificador " + id);
        }
        try {
            personaDao.update(new UserImpl(id,"Nuevo nombre") );
            personaDao.delete(new UserImpl(id + 1,"Da igual") );
        } catch (DataAccessException ex) {
            LOGGER.info("Ha ocurrido un error: " + ex.getMessage());
        }
        LOGGER.info("Lista de todas las personas en la base de datos");
        try {
            Collection<User> todos = personaDao.findAll();
            LOGGER.info("Se han encontrado {} persona(s) en la base de datos\n",todos.size());
            for (User persona : todos) {
                LOGGER.info("Id {}. Nombre {}",persona.getId(),persona.getName());
            }
        } catch (DataAccessException ex) {
            LOGGER.info("Ha ocurrido un error: " + ex.getMessage());
        }
    }
    
    private static void ejecutarInsercionDevolviendoLaClavePrimaria() {
        UserDao personaDao = (UserDao) ctx.getBean("personaDao");
        try {
            Integer clave = personaDao.createByObject(new UserImpl(null,"Clave primaria"));
            LOGGER.info("La clave primaria es " + clave);
        } catch (DataAccessException ex) {
            LOGGER.info("Ha ocurrido un error: " + ex.getMessage());
        }
    }
}
