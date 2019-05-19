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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Greg
 */
@Entity
@Table(name = "tbavaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbavaliacao.findAll", query = "SELECT t FROM Tbavaliacao t")
    , @NamedQuery(name = "Tbavaliacao.findByBdID", query = "SELECT t FROM Tbavaliacao t WHERE t.bdID = :bdID")
    , @NamedQuery(name = "Tbavaliacao.findByBdNota", query = "SELECT t FROM Tbavaliacao t WHERE t.bdNota = :bdNota")})
public class Tbavaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bdID")
    private Integer bdID;
    @Column(name = "bdNota")
    private Integer bdNota;
    @JoinColumn(name = "bdFKReceita", referencedColumnName = "bdID")
    @ManyToOne
    private Tbreceita bdFKReceita;
    @JoinColumn(name = "bdFKUsuario", referencedColumnName = "bdID")
    @ManyToOne
    private Tbusuario bdFKUsuario;

    public Tbavaliacao() {
    }

    public Tbavaliacao(Integer bdID) {
        this.bdID = bdID;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
        this.bdID = bdID;
    }

    public Integer getBdNota() {
        return bdNota;
    }

    public void setBdNota(Integer bdNota) {
        this.bdNota = bdNota;
    }

    public Tbreceita getBdFKReceita() {
        return bdFKReceita;
    }

    public void setBdFKReceita(Tbreceita bdFKReceita) {
        this.bdFKReceita = bdFKReceita;
    }

    public Tbusuario getBdFKUsuario() {
        return bdFKUsuario;
    }

    public void setBdFKUsuario(Tbusuario bdFKUsuario) {
        this.bdFKUsuario = bdFKUsuario;
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
        if (!(object instanceof Tbavaliacao)) {
            return false;
        }
        Tbavaliacao other = (Tbavaliacao) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbavaliacao[ bdID=" + bdID + " ]";
    }
    
}
