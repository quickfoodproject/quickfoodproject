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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Greg
 */
@Entity
@Table(name = "tbcomentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbcomentario.findAll", query = "SELECT t FROM Tbcomentario t")
    , @NamedQuery(name = "Tbcomentario.findByBdID", query = "SELECT t FROM Tbcomentario t WHERE t.bdID = :bdID")
    , @NamedQuery(name = "Tbcomentario.findByBdDescricao", query = "SELECT t FROM Tbcomentario t WHERE t.bdDescricao = :bdDescricao")})
public class Tbcomentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bdID")
    private Integer bdID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bdDescricao")
    private String bdDescricao;
    @JoinColumn(name = "bdFKReceita", referencedColumnName = "bdID")
    @ManyToOne
    private Tbreceita bdFKReceita;
    @JoinColumn(name = "bdFKUsuario", referencedColumnName = "bdID")
    @ManyToOne
    private Tbusuario bdFKUsuario;

    public Tbcomentario() {
    }

    public Tbcomentario(Integer bdID) {
        this.bdID = bdID;
    }

    public Tbcomentario(Integer bdID, String bdDescricao) {
        this.bdID = bdID;
        this.bdDescricao = bdDescricao;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
        this.bdID = bdID;
    }

    public String getBdDescricao() {
        return bdDescricao;
    }

    public void setBdDescricao(String bdDescricao) {
        this.bdDescricao = bdDescricao;
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
        if (!(object instanceof Tbcomentario)) {
            return false;
        }
        Tbcomentario other = (Tbcomentario) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbcomentario[ bdID=" + bdID + " ]";
    }
    
}
