/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrador
 */
public class DelegadoMultiActionControler {
public ModelAndView manejarEntrada(HttpServletRequest request, 
                                       HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("entrada");
        mav.addObject("mensaje", 
                      "La clase de este controlador es " + getClass().getName());
        return mav;
    }
}
