package org.course.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.course.spring.aspects.EjemploIntroduccion;
import org.course.spring.aspects.ServicioSaludo;
import org.course.spring.beans.Persona;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    private ClassPathXmlApplicationContext ctx;
    private Log log = LogFactory.getLog(Main.class);
    private ServicioSaludo ss;

    public Main() {
    }

    public static void main(String[] args) {
        Main p = new Main();
        p.inicializarSpring();
        p.forzarEjecucionAspectoAfter();
        p.forzarEjecucionAspectoAfterReturning();
        try {
            p.forzarEjecucionAspectoAfterThrowing();
        } catch (Exception e) {
            System.out.println("Capturada una excepci�n de tipo " + e.getClass().getName());
        }
        p.forzarEjecucionAspectoBefore();
        p.forzarEjecucionAspectoBeforeConParametro();
        p.forzarEjecucionAspectoAround();
        p.forzarEjecucionAspectoIntroduccion();
    }

    private void inicializarSpring() {
        String[] contextos = {"springaspectos0001/sistema/aspectosContext.xml", "springaspectos0001/introducciones/introduccionContext.xml"};
        ctx = new ClassPathXmlApplicationContext(contextos);
        ss = (ServicioSaludo) ctx.getBean("servicioSaludo");
        log.info("Spring se ha inicializado correctamente");
    }

    private void forzarEjecucionAspectoAfterReturning() {
        ss.principalAfterReturning();
    }

    private void forzarEjecucionAspectoBefore() {
        ss.principalBefore();
    }

    private void forzarEjecucionAspectoAfter() {
        ss.principalAfter();
    }

    private void forzarEjecucionAspectoAfterThrowing() {
        ss.metodoPublicoCualquiera();
    }

    private void forzarEjecucionAspectoAround() {
        ss.metodoLento();
    }

    private void forzarEjecucionAspectoBeforeConParametro() {
        ss.principalBefore(7);
    }

    private void forzarEjecucionAspectoIntroduccion() {
        Persona persona = (Persona) ctx.getBean("persona");
        persona.setNombre("Un nombre");
        EjemploIntroduccion ej = (EjemploIntroduccion) ctx.getBean("persona");
        ej.mensaje();
    }
}