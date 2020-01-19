package org.course.spring.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hobby {
	
    private Integer id;
    
    private String name;
    
    private Person person;

    /**
	 * New Instance
	 */
    public Hobby() {
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
