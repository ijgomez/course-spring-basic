package org.course.spring.beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rol implements Serializable {

	private static final long serialVersionUID = 6125548992419439547L;
	
	private String name;

    /**
     * New Instance
     */
    public Rol() {
    	
    }

    @Override
    public boolean equals(Object obj) {
    	return EqualsBuilder.reflectionEquals(this, obj, false);
    }
    
    @Override
    public int hashCode() {
    	return HashCodeBuilder.reflectionHashCode(this, false);
    }
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}
