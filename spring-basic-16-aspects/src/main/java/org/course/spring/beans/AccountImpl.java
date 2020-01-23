package org.course.spring.beans;

import java.io.Serializable;

public class AccountImpl implements Serializable, Account {

	private static final long serialVersionUID = -2898384848169327835L;

	public Client getClient() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double getAmount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ingresar(Double amount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double reintegrar(Double amount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}