package com.senai.quickfood.model;

import java.io.Serializable;
import java.util.Collection;

public class Tbusuario implements Serializable {
   
    private int bdID;   
    private String bdLogin;        
    private String bdSenha;
    private boolean bdUsuarioAdministrador;
    private Collection<Receita> tbreceitaCollection;
    private Collection<Comentario> tbcomentarioCollection;    
    private Collection<Avaliacao> tbavaliacaoCollection;
    private Pessoa bdFKPessoa; 

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

    public void setBdUsuarioAdministrador(boolean bdUsuarioAdministrador) {
        this.bdUsuarioAdministrador = bdUsuarioAdministrador;
    }

    public Collection<Receita> getTbreceitaCollection() {
        return tbreceitaCollection;
    }

    public void setTbreceitaCollection(Collection<Receita> tbreceitaCollection) {
        this.tbreceitaCollection = tbreceitaCollection;
    }

    public Collection<Comentario> getTbcomentarioCollection() {
        return tbcomentarioCollection;
    }

    public void setTbcomentarioCollection(Collection<Comentario> tbcomentarioCollection) {
        this.tbcomentarioCollection = tbcomentarioCollection;
    }

    public Pessoa getBdFKPessoa() {
        return bdFKPessoa;
    }

    public void setBdFKPessoa(Pessoa bdFKPessoa) {
        this.bdFKPessoa = bdFKPessoa;
    }

    public Collection<Avaliacao> getTbavaliacaoCollection() {
        return tbavaliacaoCollection;
    }

    public void setTbavaliacaoCollection(Collection<Avaliacao> tbavaliacaoCollection) {
        this.tbavaliacaoCollection = tbavaliacaoCollection;
    }
  
    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbusuario[ bdID=" + bdID + " ]";
    }
    
}
