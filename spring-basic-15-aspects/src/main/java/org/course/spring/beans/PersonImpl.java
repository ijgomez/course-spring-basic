package org.course.spring.beans;

import java.io.Serializable;


public class PersonImpl implements Person, Serializable {
    
	private static final long serialVersionUID = -7742078705286016552L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
