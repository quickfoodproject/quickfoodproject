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
@Table(name = "tbreceita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbreceita.findAll", query = "SELECT t FROM Tbreceita t")
    , @NamedQuery(name = "Tbreceita.findByBdID", query = "SELECT t FROM Tbreceita t WHERE t.bdID = :bdID")
    , @NamedQuery(name = "Tbreceita.findByBdNome", query = "SELECT t FROM Tbreceita t WHERE t.bdNome = :bdNome")
    , @NamedQuery(name = "Tbreceita.findByBdDescricao", query = "SELECT t FROM Tbreceita t WHERE t.bdDescricao = :bdDescricao")
    , @NamedQuery(name = "Tbreceita.findByBdURLlmagem", query = "SELECT t FROM Tbreceita t WHERE t.bdURLlmagem = :bdURLlmagem")})
public class Tbreceita implements Serializable {

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
    @Size(min = 1, max = 255)
    @Column(name = "bdDescricao")
    private String bdDescricao;
    @Size(max = 100)
    @Column(name = "bdURLlmagem")
    private String bdURLlmagem;
    @JoinColumn(name = "bdDKUsuario", referencedColumnName = "bdID")
    @ManyToOne
    private Tbusuario bdDKUsuario;
    @OneToMany(mappedBy = "bdFKReceita")
    private Collection<Tbcomentario> tbcomentarioCollection;
    @OneToMany(mappedBy = "bdFKReceita")
    private Collection<Tbingredientereceita> tbingredientereceitaCollection;
    @OneToMany(mappedBy = "bdFKReceita")
    private Collection<Tbavaliacao> tbavaliacaoCollection;

    public Tbreceita() {
    }

    public Tbreceita(Integer bdID) {
        this.bdID = bdID;
    }

    public Tbreceita(Integer bdID, String bdNome, String bdDescricao) {
        this.bdID = bdID;
        this.bdNome = bdNome;
        this.bdDescricao = bdDescricao;
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

    public String getBdDescricao() {
        return bdDescricao;
    }

    public void setBdDescricao(String bdDescricao) {
        this.bdDescricao = bdDescricao;
    }

    public String getBdURLlmagem() {
        return bdURLlmagem;
    }

    public void setBdURLlmagem(String bdURLlmagem) {
        this.bdURLlmagem = bdURLlmagem;
    }

    public Tbusuario getBdDKUsuario() {
        return bdDKUsuario;
    }

    public void setBdDKUsuario(Tbusuario bdDKUsuario) {
        this.bdDKUsuario = bdDKUsuario;
    }

    @XmlTransient
    public Collection<Tbcomentario> getTbcomentarioCollection() {
        return tbcomentarioCollection;
    }

    public void setTbcomentarioCollection(Collection<Tbcomentario> tbcomentarioCollection) {
        this.tbcomentarioCollection = tbcomentarioCollection;
    }

    @XmlTransient
    public Collection<Tbingredientereceita> getTbingredientereceitaCollection() {
        return tbingredientereceitaCollection;
    }

    public void setTbingredientereceitaCollection(Collection<Tbingredientereceita> tbingredientereceitaCollection) {
        this.tbingredientereceitaCollection = tbingredientereceitaCollection;
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
        if (!(object instanceof Tbreceita)) {
            return false;
        }
        Tbreceita other = (Tbreceita) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbreceita[ bdID=" + bdID + " ]";
    }
    
}
