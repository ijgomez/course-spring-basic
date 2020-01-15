package org.course.spring;

import java.util.List;
import java.util.Random;

import org.course.spring.beans.Empleado;
import org.course.spring.beans.ParteActividad;
import org.course.spring.services.ServicioEmpleado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	private static ClassPathXmlApplicationContext ctx;

	public static void main(String[] args) {
		init();
        ejecutarSpringHibernateJpa();
        ejecutarSpringHibernateJpaRelaciones();
	}
	
	private static void init() {
        String[] paths = {"recursos/applicationContext.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        System.out.println("Contexto cargado");
    }
    
    private static void ejecutarSpringHibernateJpa() {
        ServicioEmpleado servicio = (ServicioEmpleado) ctx.getBean("servicioEmpleado");
        final Integer MAX_ELEMENTOS = 5;
        for(int i = 0; i < MAX_ELEMENTOS; i++)
            servicio.insertarEmpleado(new Empleado("Nombre" + i,"xyz@abc.com"));
        List<Empleado> empleados = servicio.getEmpleados();
        System.out.printf("se han encontrado %d empleados\n",empleados.size());
        for (Empleado empleado : empleados) {
            System.out.printf("El nombre del empleado es %s y su clave es %d\n",empleado.getNombre(), empleado.getId());
        }
    }
    
    private static void ejecutarSpringHibernateJpaRelaciones() {
        Random r = new Random();
        Empleado empleado = new Empleado("Empleado con actividades" + System.currentTimeMillis(),"abc@xyz.com");
        ParteActividad parte = new ParteActividad(r.nextDouble(), "Actividad" + System.currentTimeMillis());
        ServicioEmpleado servicio = (ServicioEmpleado) ctx.getBean("servicioEmpleado");
        servicio.asignarParteActividad(empleado,parte);
        List<ParteActividad> actividades = servicio.getActividades(empleado);
        System.out.printf("se han encontrado %d partes de actividad \n",actividades.size());
        for (ParteActividad elem : actividades) {
            System.out.printf("El nombre de la actividad es %s y re realiz� en %f horas\n",elem.getNombre(), elem.getHoras());
        }
    }
	
}
