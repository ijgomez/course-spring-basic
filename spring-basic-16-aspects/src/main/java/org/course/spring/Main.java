/*
 * Main.java
 *
 * Created on 25 de junio de 2007, 14:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.course.spring.beans.ClienteImpl;
import org.course.spring.beans.CuentaImpl;
import org.course.spring.services.ServicioCliente;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class Main {

    private ClassPathXmlApplicationContext ctx;
    private Log log = LogFactory.getLog(Main.class);

    /** Creates a new instance of Main */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.init();
        m.forzarEjecucionAspectos();
    }

    private void init() {
        String[] paths = {"recursos/applicationContext.xml", "recursos/aspectosContext.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        System.out.println("Contexto cargado");
    }

    private void forzarEjecucionAspectos() {
        ServicioCliente sc = (ServicioCliente) ctx.getBean("servicioCliente");
        sc.ingresar(new ClienteImpl(), new CuentaImpl(), 6000.0d);
        sc.reintegrar(new ClienteImpl(), new CuentaImpl(), 5000.0d);
    }
}