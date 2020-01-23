package org.course.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.course.spring.annotations.Fiscalizable;
import org.course.spring.beans.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.course.spring.beans.Account;

@Aspect()
public class FiscalAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FiscalAspect.class);

    @Before("@annotation(fiscalizable) && args(client,account,amount)")
    public void ejecutarAspectoError(Fiscalizable fiscalizable, Client client, Account account, Double amount){
        LOGGER.info("Operación registrada por un importe de " + amount + " euros.");
        if (amount > fiscalizable.importe()) {
        	LOGGER.info("Esta operación requiere avisar a Hacienda, ya que su importe (" + amount + ") euros, es mayor que el límite legal de " + fiscalizable.importe());
        }
    }
}
