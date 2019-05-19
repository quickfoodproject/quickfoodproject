/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.quickfood.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Greg
 */
@Entity
@Table(name = "tbingredientereceita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbingredientereceita.findAll", query = "SELECT t FROM Tbingredientereceita t")
    , @NamedQuery(name = "Tbingredientereceita.findByBdID", query = "SELECT t FROM Tbingredientereceita t WHERE t.bdID = :bdID")
    , @NamedQuery(name = "Tbingredientereceita.findByBdQuantidadeIngrediente", query = "SELECT t FROM Tbingredientereceita t WHERE t.bdQuantidadeIngrediente = :bdQuantidadeIngrediente")})
public class Tbingredientereceita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bdID")
    private Integer bdID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bdQuantidadeIngrediente")
    private double bdQuantidadeIngrediente;
    @JoinColumn(name = "bdFKUnidadeMedida", referencedColumnName = "bdID")
    @ManyToOne
    private Tbunidademedida bdFKUnidadeMedida;
    @JoinColumn(name = "bdFKIngrediente", referencedColumnName = "dbID")
    @ManyToOne
    private Tbingrediente bdFKIngrediente;
    @JoinColumn(name = "bdFKReceita", referencedColumnName = "bdID")
    @ManyToOne
    private Tbreceita bdFKReceita;

    public Tbingredientereceita() {
    }

    public Tbingredientereceita(Integer bdID) {
        this.bdID = bdID;
    }

    public Tbingredientereceita(Integer bdID, double bdQuantidadeIngrediente) {
        this.bdID = bdID;
        this.bdQuantidadeIngrediente = bdQuantidadeIngrediente;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
        this.bdID = bdID;
    }

    public double getBdQuantidadeIngrediente() {
        return bdQuantidadeIngrediente;
    }

    public void setBdQuantidadeIngrediente(double bdQuantidadeIngrediente) {
        this.bdQuantidadeIngrediente = bdQuantidadeIngrediente;
    }

    public Tbunidademedida getBdFKUnidadeMedida() {
        return bdFKUnidadeMedida;
    }

    public void setBdFKUnidadeMedida(Tbunidademedida bdFKUnidadeMedida) {
        this.bdFKUnidadeMedida = bdFKUnidadeMedida;
    }

    public Tbingrediente getBdFKIngrediente() {
        return bdFKIngrediente;
    }

    public void setBdFKIngrediente(Tbingrediente bdFKIngrediente) {
        this.bdFKIngrediente = bdFKIngrediente;
    }

    public Tbreceita getBdFKReceita() {
        return bdFKReceita;
    }

    public void setBdFKReceita(Tbreceita bdFKReceita) {
        this.bdFKReceita = bdFKReceita;
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
        if (!(object instanceof Tbingredientereceita)) {
            return false;
        }
        Tbingredientereceita other = (Tbingredientereceita) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingredientereceita[ bdID=" + bdID + " ]";
    }
    
}
