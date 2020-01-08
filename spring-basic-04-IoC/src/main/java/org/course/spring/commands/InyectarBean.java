package org.course.spring.commands;

import org.course.spring.beans.Employee;
import org.course.spring.utils.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InyectarBean implements Command {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InyectarBean.class);

    public void execute() {
    	
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"applicationContext0005.xml", "applicationContext0006.xml"});
        LOGGER.info("Context loaded.");
        
       
        Employee empleado1 = (Employee) ctx.getBean("empleado1");
        LOGGER.info(String.format("Datos del empleado1:\n\tNombre:%s\n\tClave:%s\n\tEdad:%d\n\tImporte de la nómina:%f\n",empleado1.getName(),empleado1.getPassword(),empleado1.getAge(),empleado1.getPayroll().getAmount()));
        
        Employee empleado2 = (Employee) ctx.getBean("empleado2");
        LOGGER.info(String.format("Datos del empleado2:\n\tNombre:%s\n\tClave:%s\n\tEdad:%d\n\tImporte de la nómina:%f\n",empleado2.getName(),empleado2.getPassword(),empleado2.getAge(),empleado2.getPayroll().getAmount()));
    }
    
}
