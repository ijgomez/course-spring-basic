package org.course.spring.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ActivityPart implements Serializable {

	private static final long serialVersionUID = -1976067976805250025L;

	@ManyToOne
    private Employee employee;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Double hours;
    
    private String name;
    
    /**
	 * new instance
	 */
    public ActivityPart() {
    }
    
    public ActivityPart(Double hours, String name) {
    	this.hours = hours;
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
