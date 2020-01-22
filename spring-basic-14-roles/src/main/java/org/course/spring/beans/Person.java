package org.course.spring.beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class Person implements Serializable {

	private static final long serialVersionUID = -6080757354086615828L;
	
	private String name;

    public Person() {
    	
    }

    public Person(String name) {
        this.setName(name);
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }
  
    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object, false);
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
