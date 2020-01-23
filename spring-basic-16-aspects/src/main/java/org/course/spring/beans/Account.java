package org.course.spring.beans;

public interface Account {
	
	Client getClient();

	Double getAmount();

	void ingresar(Double amount);

	Double reintegrar(Double amount);
	
}
