/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.quickfood.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Greg
 */
@Entity
@Table(name = "tbingrediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbingrediente.findAll", query = "SELECT t FROM Tbingrediente t")
    , @NamedQuery(name = "Tbingrediente.findByDbID", query = "SELECT t FROM Tbingrediente t WHERE t.dbID = :dbID")
    , @NamedQuery(name = "Tbingrediente.findByBdNome", query = "SELECT t FROM Tbingrediente t WHERE t.bdNome = :bdNome")})
public class Tbingrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbID")
    private Integer dbID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bdNome")
    private String bdNome;
    @OneToMany(mappedBy = "bdFKIngrediente")
    private Collection<Tbingredientereceita> tbingredientereceitaCollection;

    public Tbingrediente() {
    }

    public Tbingrediente(Integer dbID) {
        this.dbID = dbID;
    }

    public Tbingrediente(Integer dbID, String bdNome) {
        this.dbID = dbID;
        this.bdNome = bdNome;
    }

    public Integer getDbID() {
        return dbID;
    }

    public void setDbID(Integer dbID) {
        this.dbID = dbID;
    }

    public String getBdNome() {
        return bdNome;
    }

    public void setBdNome(String bdNome) {
        this.bdNome = bdNome;
    }

    @XmlTransient
    public Collection<Tbingredientereceita> getTbingredientereceitaCollection() {
        return tbingredientereceitaCollection;
    }

    public void setTbingredientereceitaCollection(Collection<Tbingredientereceita> tbingredientereceitaCollection) {
        this.tbingredientereceitaCollection = tbingredientereceitaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbID != null ? dbID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbingrediente)) {
            return false;
        }
        Tbingrediente other = (Tbingrediente) object;
        if ((this.dbID == null && other.dbID != null) || (this.dbID != null && !this.dbID.equals(other.dbID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingrediente[ dbID=" + dbID + " ]";
    }
    
}
