/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.quickfood.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Greg
 */
@Entity
@Table(name = "tbpessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbpessoa.findAll", query = "SELECT t FROM Tbpessoa t")
    , @NamedQuery(name = "Tbpessoa.findByBdID", query = "SELECT t FROM Tbpessoa t WHERE t.bdID = :bdID")
    , @NamedQuery(name = "Tbpessoa.findByBdNome", query = "SELECT t FROM Tbpessoa t WHERE t.bdNome = :bdNome")
    , @NamedQuery(name = "Tbpessoa.findByBdSexo", query = "SELECT t FROM Tbpessoa t WHERE t.bdSexo = :bdSexo")
    , @NamedQuery(name = "Tbpessoa.findByBdDataNascimento", query = "SELECT t FROM Tbpessoa t WHERE t.bdDataNascimento = :bdDataNascimento")})
public class Tbpessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bdID")
    private Integer bdID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bdNome")
    private String bdNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "bdSexo")
    private String bdSexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bdDataNascimento")
    @Temporal(TemporalType.DATE)
    private Date bdDataNascimento;
    @OneToMany(mappedBy = "bdFKPessoa")
    private Collection<Tbusuario> tbusuarioCollection;

    public Tbpessoa() {
    }

    public Tbpessoa(Integer bdID) {
        this.bdID = bdID;
    }

    public Tbpessoa(Integer bdID, String bdNome, String bdSexo, Date bdDataNascimento) {
        this.bdID = bdID;
        this.bdNome = bdNome;
        this.bdSexo = bdSexo;
        this.bdDataNascimento = bdDataNascimento;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
        this.bdID = bdID;
    }

    public String getBdNome() {
        return bdNome;
    }

    public void setBdNome(String bdNome) {
        this.bdNome = bdNome;
    }

    public String getBdSexo() {
        return bdSexo;
    }

    public void setBdSexo(String bdSexo) {
        this.bdSexo = bdSexo;
    }

    public Date getBdDataNascimento() {
        return bdDataNascimento;
    }

    public void setBdDataNascimento(Date bdDataNascimento) {
        this.bdDataNascimento = bdDataNascimento;
    }

    @XmlTransient
    public Collection<Tbusuario> getTbusuarioCollection() {
        return tbusuarioCollection;
    }

    public void setTbusuarioCollection(Collection<Tbusuario> tbusuarioCollection) {
        this.tbusuarioCollection = tbusuarioCollection;
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
        if (!(object instanceof Tbpessoa)) {
            return false;
        }
        Tbpessoa other = (Tbpessoa) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbpessoa[ bdID=" + bdID + " ]";
    }
    
}
