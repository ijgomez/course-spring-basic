package org.course.spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PrimerInterceptor extends HandlerInterceptorAdapter {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(PrimerInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	LOGGER.info("Ejecución del primer interceptor, método preHandle. Handler: {}", handler.getClass().getName());
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	LOGGER.info("Ejecución del primer interceptor, método postHandle. Handler: {}", handler.getClass().getName());
    }
    
}
