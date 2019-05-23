package com.senai.wsquickfood.model;

import java.io.Serializable;
import java.util.Collection;

public class Tbusuario implements Serializable {

    private int bdID;
    private String bdLogin;
    private String bdSenha;
    private String bdEmail;
    private boolean bdUsuarioAdministrador;
    private Collection<Tbreceita> tbreceitaCollection;
    private Collection<Tbcomentario> tbcomentarioCollection;
    private Collection<Tbavaliacao> tbavaliacaoCollection;
    private Tbpessoa bdFKPessoa;

    public Tbusuario() {
    }

    public Tbusuario(int bdID) {
        this.bdID = bdID;
    }

    public Tbusuario(int bdID, String bdLogin, String bdSenha) {
        this.bdID = bdID;
        this.bdLogin = bdLogin;
        this.bdSenha = bdSenha;
    }

    public int getBdID() {
        return bdID;
    }

    public void setBdID(int bdID) {
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

    public boolean getBdUsuarioAdministrador() {
        return bdUsuarioAdministrador;
    }

    public String getBdEmail() {
        return bdEmail;
    }

    public void setBdEmail(String bdSEmail) {
        this.bdEmail = bdSEmail;
    }

    public void setBdUsuarioAdministrador(boolean bdUsuarioAdministrador) {
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
    public String toString() {
        return "com.senai.quickfood.dao.Tbusuario[ bdID=" + bdID + " ]";
    }

}
