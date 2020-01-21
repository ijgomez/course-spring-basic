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
import org.hibernate.validator.Email;
import org.hibernate.validator.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee implements Serializable {

	private static final long serialVersionUID = 4790990943480100582L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ActivityPart> activities;

	@Length(max = 100, min = 1, message = "EL name debe tener de 10 a 20 caracteres")
	private String name;

	@Email(message = "Dirección de correo incorrecta")
	private String email;
    
	/**
	 * new instance
	 */
	public Employee() {
		
	}
    
    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
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
