package org.course.spring.beans;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comunicacion implements Serializable {

	private static final long serialVersionUID = 6834947743570539923L;
	
	private String tipo;

	/**
	 * New Instance
	 */
	public Comunicacion() {
		
	}

	public boolean comunicar(String mensaje) {
		System.out.println("Establecer comunicacion original.");
		return false;
	}

}
