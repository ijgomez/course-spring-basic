package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person implements Serializable {

	private static final long serialVersionUID = 7118202339957776972L;

	private Long id;
    
	private String name;
    
	private Set<Hobby> internalHobbies;
    
	private List<Hobby> hobbies;

	/**
	 * New Instance
	 */
    public Person() {
    	super();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
