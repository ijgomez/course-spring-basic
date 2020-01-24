package org.course.spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TercerInterceptor implements HandlerInterceptor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SegundoInterceptor.class);
    
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        LOGGER.info("Ejecución del tercer interceptor, método preHandle. Handler: {}", object.getClass().getName());
        LOGGER.info("URI: {}", httpServletRequest.getRequestURI());
        if (httpServletRequest.getRequestURI().endsWith("cuarta.course")) {
            httpServletResponse.sendRedirect("quinta.course");
            return false;
        } else {
            return true;
        }
        
    }
    
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, ModelAndView modelAndView) throws Exception {
    	LOGGER.info("Ejecución del tercer interceptor, método postHandle. Handler: {}", object.getClass().getName());
        
    }
    
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, Exception exception) throws Exception {
    	LOGGER.info("Ejecución del tercer interceptor, método afterCompletion. Handler: {}", object.getClass().getName());
        
    }
    
}
