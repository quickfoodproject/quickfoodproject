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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Greg
 */
@Entity
@Table(name = "tbunidademedida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbunidademedida.findAll", query = "SELECT t FROM Tbunidademedida t")
    , @NamedQuery(name = "Tbunidademedida.findByBdID", query = "SELECT t FROM Tbunidademedida t WHERE t.bdID = :bdID")
    , @NamedQuery(name = "Tbunidademedida.findByBdUnidade", query = "SELECT t FROM Tbunidademedida t WHERE t.bdUnidade = :bdUnidade")})
public class Tbunidademedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bdID")
    private Integer bdID;
    @Size(max = 50)
    @Column(name = "bdUnidade")
    private String bdUnidade;
    @OneToMany(mappedBy = "bdFKUnidadeMedida")
    private Collection<Tbingredientereceita> tbingredientereceitaCollection;

    public Tbunidademedida() {
    }

    public Tbunidademedida(Integer bdID) {
        this.bdID = bdID;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
        this.bdID = bdID;
    }

    public String getBdUnidade() {
        return bdUnidade;
    }

    public void setBdUnidade(String bdUnidade) {
        this.bdUnidade = bdUnidade;
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
        hash += (bdID != null ? bdID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbunidademedida)) {
            return false;
        }
        Tbunidademedida other = (Tbunidademedida) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbunidademedida[ bdID=" + bdID + " ]";
    }
    
}
