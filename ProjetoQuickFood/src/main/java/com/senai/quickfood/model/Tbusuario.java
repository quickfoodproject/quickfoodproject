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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbusuario.findAll", query = "SELECT t FROM Tbusuario t")
    , @NamedQuery(name = "Tbusuario.findByBdID", query = "SELECT t FROM Tbusuario t WHERE t.bdID = :bdID")
    , @NamedQuery(name = "Tbusuario.findByBdLogin", query = "SELECT t FROM Tbusuario t WHERE t.bdLogin = :bdLogin")
    , @NamedQuery(name = "Tbusuario.findByBdSenha", query = "SELECT t FROM Tbusuario t WHERE t.bdSenha = :bdSenha")
    , @NamedQuery(name = "Tbusuario.findByBdUsuarioAdministrador", query = "SELECT t FROM Tbusuario t WHERE t.bdUsuarioAdministrador = :bdUsuarioAdministrador")})
public class Tbusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bdID")
    private Integer bdID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bdLogin")
    private String bdLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bdSenha")
    private String bdSenha;
    @Column(name = "bdUsuarioAdministrador")
    private Boolean bdUsuarioAdministrador;
    @OneToMany(mappedBy = "bdDKUsuario")
    private Collection<Tbreceita> tbreceitaCollection;
    @OneToMany(mappedBy = "bdFKUsuario")
    private Collection<Tbcomentario> tbcomentarioCollection;
    @JoinColumn(name = "bdFKPessoa", referencedColumnName = "bdID")
    @ManyToOne
    private Tbpessoa bdFKPessoa;
    @OneToMany(mappedBy = "bdFKUsuario")
    private Collection<Tbavaliacao> tbavaliacaoCollection;

    public Tbusuario() {
    }

    public Tbusuario(Integer bdID) {
        this.bdID = bdID;
    }

    public Tbusuario(Integer bdID, String bdLogin, String bdSenha) {
        this.bdID = bdID;
        this.bdLogin = bdLogin;
        this.bdSenha = bdSenha;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
        this.bdID = bdID;
    }

    public String getBdLogin() {
        return bdLogin;
    }

    public void setBdLogin(String bdLogin) {
        this.bdLogin = bdLogin;
    }

    public String getBdSenha() {
        return bdSenha;
    }

    public void setBdSenha(String bdSenha) {
        this.bdSenha = bdSenha;
    }

    public Boolean getBdUsuarioAdministrador() {
        return bdUsuarioAdministrador;
    }

    public void setBdUsuarioAdministrador(Boolean bdUsuarioAdministrador) {
        this.bdUsuarioAdministrador = bdUsuarioAdministrador;
    }

    @XmlTransient
    public Collection<Tbreceita> getTbreceitaCollection() {
        return tbreceitaCollection;
    }

    public void setTbreceitaCollection(Collection<Tbreceita> tbreceitaCollection) {
        this.tbreceitaCollection = tbreceitaCollection;
    }

    @XmlTransient
    public Collection<Tbcomentario> getTbcomentarioCollection() {
        return tbcomentarioCollection;
    }

    public void setTbcomentarioCollection(Collection<Tbcomentario> tbcomentarioCollection) {
        this.tbcomentarioCollection = tbcomentarioCollection;
    }

    public Tbpessoa getBdFKPessoa() {
        return bdFKPessoa;
    }

    public void setBdFKPessoa(Tbpessoa bdFKPessoa) {
        this.bdFKPessoa = bdFKPessoa;
    }

    @XmlTransient
    public Collection<Tbavaliacao> getTbavaliacaoCollection() {
        return tbavaliacaoCollection;
    }

    public void setTbavaliacaoCollection(Collection<Tbavaliacao> tbavaliacaoCollection) {
        this.tbavaliacaoCollection = tbavaliacaoCollection;
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
        if (!(object instanceof Tbusuario)) {
            return false;
        }
        Tbusuario other = (Tbusuario) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbusuario[ bdID=" + bdID + " ]";
    }
    
}
