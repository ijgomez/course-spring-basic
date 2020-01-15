package org.course.spring.aspects;

public class ServicioSaludo {
    public ServicioSaludo() {
    }

    public void principalAfter() {
        System.out.println("En " + getClass().getName() + " usando after");
    }

    public Long principalAfterReturning() {
        System.out.println("En " + getClass().getName() + 
                           " usando after returning");
        return System.currentTimeMillis();
    }

    public void metodoPublicoCualquiera() {
        System.out.println("En " + getClass().getName() + 
                           " usando after throwing");
        throw new IllegalArgumentException("Error de prueba");
    }

    public void principalBefore() {
        System.out.println("En " + getClass().getName() + " usando before");
    }
    
    public void principalBefore(Integer unInteger) {
        System.out.println("En " + getClass().getName() + " usando before con un par�metro, cuyo valor es " + unInteger);
    }

    public void metodoLento() {
        double otro = 0;
        for (int i = 0; i < 1000000; i++)
            otro = Math.random();
    }
}
