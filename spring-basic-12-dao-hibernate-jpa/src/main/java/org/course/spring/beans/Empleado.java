/*
 * Empleado.java
 *
 * Created on 20 de junio de 2007, 13:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.Email;
import org.hibernate.validator.Length;

/**
 * Entity class Empleado
 *
 * @author Administrador
 */
@Entity
public class Empleado implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "empleado",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
    private List<ParteActividad> actividades;
    @Length(max=100,min=1,message="EL nombre debe tener de 10 a 20 caracteres")
    private String nombre;
    @Email(message="Direcci�n de correo incorrecta")
    private String email;
    /** Creates a new instance of Empleado */
    public Empleado() {
    }
    
    public Empleado(String nombre, String email) {
        setNombre(nombre);
        setEmail(email);
    }
    
    /**
     * Gets the id of this Empleado.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }
    
    /**
     * Sets the id of this Empleado to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Returns a hash code value for the object.  This implementation computes
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this Empleado.  The result is
     * <code>true</code> if and only if the argument is not null and is a Empleado object that
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado)object;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "beans.entidad.Empleado[id=" + getId() + "]";
    }
    
    public List<ParteActividad> getActividades() {
        if(actividades == null)
            actividades = new ArrayList<ParteActividad>();
        return actividades;
    }
    
    public void setActividades(List<ParteActividad> actividades) {
        this.actividades = actividades;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
}
