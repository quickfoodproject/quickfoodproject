package com.senai.quickfood.model;

import java.io.Serializable;
import java.util.Collection;

public class Tbusuario implements Serializable {
   
    private Integer bdID;   
    private String bdLogin;        
    private String bdSenha;
    private Boolean bdUsuarioAdministrador;
    private Collection<Tbreceita> tbreceitaCollection;
    private Collection<Tbcomentario> tbcomentarioCollection;    
    private Collection<Tbavaliacao> tbavaliacaoCollection;
    private Tbpessoa bdFKPessoa; 

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

    public Collection<Tbreceita> getTbreceitaCollection() {
        return tbreceitaCollection;
    }

    public void setTbreceitaCollection(Collection<Tbreceita> tbreceitaCollection) {
        this.tbreceitaCollection = tbreceitaCollection;
    }

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
