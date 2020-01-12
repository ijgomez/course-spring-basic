package org.course.spring.exceptions;

public class UserException extends Exception {

	private static final long serialVersionUID = 167853463375311745L;

	public UserException() {
    	
    }

    public UserException(String msg) {
        super(msg);
    }
}
