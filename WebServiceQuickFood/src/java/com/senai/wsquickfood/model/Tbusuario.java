package com.senai.wsquickfood.model;

import java.io.Serializable;
import java.util.Collection;

public class TbUsuario implements Serializable {
    
    private int bdID;
    private String bdLogin;
    private String bdSenha;
    private String bdEmail;
    private boolean bdUsuarioAdministrador;
    private Collection<TbReceita> tbreceitaCollection;
    private Collection<TbAvaliacao> tbavaliacaoCollection;
    private TbPessoa bdFKPessoa;

    public TbUsuario() {
    }

    public TbUsuario(int bdID) {
        this.bdID = bdID;
    }

    public TbUsuario(int bdID, String bdLogin, String bdSenha) {
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

    public Collection<TbReceita> getTbreceitaCollection() {
        return tbreceitaCollection;
    }

    public void setTbreceitaCollection(Collection<TbReceita> tbreceitaCollection) {
        this.tbreceitaCollection = tbreceitaCollection;
    }

    public TbPessoa getBdFKPessoa() {
        return bdFKPessoa;
    }

    public void setBdFKPessoa(TbPessoa bdFKPessoa) {
        this.bdFKPessoa = bdFKPessoa;
    }

    public Collection<TbAvaliacao> getTbavaliacaoCollection() {
        return tbavaliacaoCollection;
    }

    public void setTbavaliacaoCollection(Collection<TbAvaliacao> tbavaliacaoCollection) {
        this.tbavaliacaoCollection = tbavaliacaoCollection;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbusuario[ bdID=" + bdID + " ]";
    }

}
