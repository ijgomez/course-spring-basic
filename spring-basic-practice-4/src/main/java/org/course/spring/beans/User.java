package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User implements Serializable {

	private static final long serialVersionUID = 2551694873088202909L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
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
