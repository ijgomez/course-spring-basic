package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable {

	private static final long serialVersionUID = 8753748940581266366L;

	private Long id;
    
    private List<Rol> roles;

    /**
     * New Instance
     */
    public User() {
    	
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
