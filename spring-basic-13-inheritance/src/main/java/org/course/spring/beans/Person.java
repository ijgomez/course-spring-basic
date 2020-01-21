package org.course.spring.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

/*
 * Probar con las otras dos estrategias: JOINED y TABLE_PER_CLASS
 * Toplink dice no soportar esta última, por ello estamos usando Hibernate
 */
@Entity(name = "PersonSingleTable")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Person implements Serializable {

	private static final long serialVersionUID = 9114428321967185527L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
	private String name;

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
