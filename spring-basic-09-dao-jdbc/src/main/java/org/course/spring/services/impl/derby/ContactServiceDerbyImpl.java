/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.services.impl.derby;

import org.course.spring.services.ContactServiceBase;

/**
 *
 * @author user
 */
public class ContactServiceDerbyImpl extends ContactServiceBase {

	private static final long serialVersionUID = 934358804681604625L;

	@Override
    protected String getIdentidad() {
        return "values IDENTITY_VAL_LOCAL()";
    }

}
