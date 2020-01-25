package org.course.spring.beans;

import java.io.Serializable;

public class UserImpl implements User, Serializable {

	private static final long serialVersionUID = -4979906101608785715L;

	private Integer id;
	
    private String name;
    
    /**
     * New Instance
     */
    public UserImpl() {
		
	}
        
    /**
     * New Instance
     */
	public UserImpl(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
