package com.senai.wsquickfood.model;

import java.io.Serializable;

public class ExemploDeModel implements Serializable {

    private int id;
    private String login;
    private String password;
    private String nome;
    private String telefone;
    private String email;
    private String repostaSeguranca;
    private String iePermissao;

    public ExemploDeModel() {
    }

    public ExemploDeModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepostaSeguranca() {
        return repostaSeguranca;
    }

    public void setRepostaSeguranca(String respostaSeguranca) {
        this.repostaSeguranca = respostaSeguranca;
    }

    public String getIePermissao() {
        return iePermissao;
    }

    public void setIePermissao(String iePermissao) {
        this.iePermissao = iePermissao;
    }  

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", password=" + password + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", repostaSeguranca=" + repostaSeguranca + ", iePermissao=" + iePermissao + '}';
    }
    
}
