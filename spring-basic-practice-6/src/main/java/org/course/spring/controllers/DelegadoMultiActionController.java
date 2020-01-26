package org.course.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public class DelegadoMultiActionController {
	
	public ModelAndView manejarEntrada(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("entrada");
		mav.addObject("mensaje", "La clase de este controlador es " + getClass().getName());
		return mav;
	}
}
