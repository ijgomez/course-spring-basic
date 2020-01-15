/*
 * Cliente.java
 *
 * Created on 26 de junio de 2007, 12:54
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity class Cliente
 * 
 * 
 * @author Administrador
 */
@Entity
public class Cliente implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4532997683437056692L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "cliente",cascade=CascadeType.PERSIST)
    private List<Cuenta> cuentas;
    /**
     * Creates a new instance of Cliente
     */
    public Cliente() {
    }

    /**
     * Gets the id of this Cliente.
     * 
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Cliente to the specified value.
     * 
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
     * Determines whether another object is equal to this Cliente.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Cliente object that 
     * has the same id field values as this object.
     * 
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente)object;
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
        return "dominio.ClienteImpl[id=" + getId() + "]";
    }

    public List<Cuenta> getCuentas() {
        if (cuentas==null) {
            cuentas = new ArrayList<Cuenta>();
        }

        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
}
