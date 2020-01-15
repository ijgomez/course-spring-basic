package org.course.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class AspectoIntroduccion {
    @DeclareParents(value = "springaspectos0001.dominio.*+", 
                    defaultImpl = EjemploIntroduccionImpl.class)
    public static EjemploIntroduccion mixin;

    @Before("execution(* *..Persona.set*(..)) && this(ejemploIntroduccion) && args(unNombre)")
    public void usoIntroduccion(EjemploIntroduccion ejemploIntroduccion, 
                                String unNombre) {
        ejemploIntroduccion.mensaje();
        System.out.println("El nombre de la persona es " + unNombre);
    }

}
