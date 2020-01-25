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

import lombok.Data;

@Entity
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 656779805888574825L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Rol> roles;
    
}
