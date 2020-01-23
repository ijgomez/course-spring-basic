package org.course.spring.beans;

import java.util.List;

public interface Client {
	
	List<Account> getAccounts();

	Account getAccount(Long id);

	void setName(String name);

	String getName();
}
