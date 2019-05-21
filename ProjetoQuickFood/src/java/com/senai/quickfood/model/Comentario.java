/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.quickfood.model;

import java.io.Serializable;

public class Comentario implements Serializable {
      
    private int bdID;
    private String bdDescricao;
    private Receita bdFKReceita;
    private Tbusuario bdFKUsuario;

    public Comentario() {
    }

    public Comentario(int bdID) {
        this.bdID = bdID;
    }

    public Comentario(int bdID, String bdDescricao) {
        this.bdID = bdID;
        this.bdDescricao = bdDescricao;
    }

    public int getBdID() {
        return bdID;
    }

    public void setBdID(int bdID) {
        this.bdID = bdID;
    }

    public String getBdDescricao() {
        return bdDescricao;
    }

    public void setBdDescricao(String bdDescricao) {
        this.bdDescricao = bdDescricao;
    }

    public Receita getBdFKReceita() {
        return bdFKReceita;
    }

    public void setBdFKReceita(Receita bdFKReceita) {
        this.bdFKReceita = bdFKReceita;
    }

    public Tbusuario getBdFKUsuario() {
        return bdFKUsuario;
    }

    public void setBdFKUsuario(Tbusuario bdFKUsuario) {
        this.bdFKUsuario = bdFKUsuario;
    }
  
    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbcomentario[ bdID=" + bdID + " ]";
    }
    
}
