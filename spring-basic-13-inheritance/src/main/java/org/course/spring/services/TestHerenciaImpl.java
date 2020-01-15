/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.course.spring.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.course.spring.beans.Empleado;
import org.course.spring.beans.Empresa;
import org.course.spring.beans.Persona;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chema
 */
@Repository
@Transactional
public class TestHerenciaImpl implements TestHerencia {

    @PersistenceContext
    private EntityManager em;

    public void test() {
//        Empresa e = new Empresa();
//        Empleado emp=new Empleado();
//        e.getPersonal().add(emp);
//        emp.setEmpresa(e);
//        em.persist(e);
        
        Persona e0 = new Persona();
        e0.setNombre("Numero1");
        
        em.persist(e0);
        
        Empleado e1 = new Empleado();
        e1.setNombre("Numero1");
        e1.setSueldo(1.0);
        
        em.persist(e1);
        
        Empleado e2 = new Empleado();
        e2.setNombre("Numero1");
        e2.setSueldo(2.0);
        
        em.persist(e2);
        
         Empleado e3 = new Empleado();
        e3.setSueldo(2.0);
        
        em.persist(e3);
        
        List<Persona> todos = em.createQuery("select p from PersonaSingleTable as p").getResultList();
        for (Persona persona : todos) {
            System.out.println(persona.getClass().getSimpleName());
        }
    }
}
