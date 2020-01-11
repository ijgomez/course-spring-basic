package org.course.spring;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.course.spring.annotations.Version;
import org.course.spring.beans.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		buscarAnotacionesEnLaClasePersona();
        buscarAnotacionesEnLosMetodosDeLaClasePersona();
	}
	
	private static void buscarAnotacionesEnLaClasePersona() {
        LOGGER.info("Buscando anotaciones en la clase " + User.class.getName());
        for (Annotation anotacion : User.class.getAnnotations()) {
            LOGGER.info("Encontrada la siguiente anotación: " + anotacion);
        }
        Version v = User.class.getAnnotation(Version.class);
        if (v == null) {
            LOGGER.info("La clase User no tiene la anotación @Version");
        } else {
            String f1 = "La clase {} tiene la anotación {}";
            LOGGER.info(f1, User.class.getSimpleName(), v.toString());
            String f2 = "La clase {} tiene como versión {}";
            LOGGER.info(f2, User.class.getSimpleName(), v.numero());
        }
    }

    private static void buscarAnotacionesEnLosMetodosDeLaClasePersona() {
        Method[] metodos = User.class.getMethods();
        for (Method metodo : metodos) {
            Annotation[] a = metodo.getAnnotations();
            if (a.length == 0) {
                LOGGER.info("No se han encontrado anotaciones para " + metodo);
            } else {
                LOGGER.info("Encontradas anotaciones para " + metodo);
                for (Annotation anotacion : a) {
                    LOGGER.info("La anotación es " + anotacion);
                }
            }
        }
    }
}
