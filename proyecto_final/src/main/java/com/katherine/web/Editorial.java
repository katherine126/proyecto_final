/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.katherine.web;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author SE
 */
@Entity
@Table(name = "editorial")
@NamedQueries({
    @NamedQuery(name = "Editorial.findAll", query = "SELECT e FROM Editorial e")})
public class Editorial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_editorial")
    private Integer idEditorial;
    @Size(max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 80)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 80)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "idEditorial")
    private Collection<Autor> autorCollection;

    public Editorial() {
    }

    public Editorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Collection<Autor> getAutorCollection() {
        return autorCollection;
    }

    public void setAutorCollection(Collection<Autor> autorCollection) {
        this.autorCollection = autorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEditorial != null ? idEditorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editorial)) {
            return false;
        }
        Editorial other = (Editorial) object;
        if ((this.idEditorial == null && other.idEditorial != null) || (this.idEditorial != null && !this.idEditorial.equals(other.idEditorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.katherine.web.Editorial[ idEditorial=" + idEditorial + " ]";
    }
    
}
