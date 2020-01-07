package org.course.spring.beans;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account implements Serializable {

	private static final long serialVersionUID = -1106504108226034428L;
	
	private Double amount;

	/**
	 * New Instance
	 */
	public Account() {
	}
}