package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;

public class ClientImpl implements Serializable, Client {

	private static final long serialVersionUID = 5900649152677408506L;

	public List<Account> getAccounts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Account getAccount(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}