package org.course.spring.beans;

import java.io.Serializable;

import org.course.spring.annotations.Version;
import org.course.spring.annotations.Visible;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Version(value = 3, numero = 2)
@Visible(true)
public class User implements Serializable {

	private static final long serialVersionUID = -1106504108226034428L;
	
	@Version(2)
	private String name;
	
	

}