package org.course.spring.beans;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends Person {

	private static final long serialVersionUID = -8605874580760664910L;

	private String password;
    
    private List<Rol> roles;
    
    private Profile profiles;

    public User() {
    	
    }

    public User(String name, String password) {
        super(name);
        this.password = password;
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
