package org.course.spring.services.impl.hsql;

import org.course.spring.services.ContactServiceBase;

public class ContactServiceHsqlImpl extends ContactServiceBase {

	private static final long serialVersionUID = -4851406648205254649L;

	@Override
    protected String getIdentidad(){
        return "select last_insert_id()";
    }
}
