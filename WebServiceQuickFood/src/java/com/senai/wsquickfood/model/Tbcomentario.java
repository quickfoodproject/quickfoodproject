/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.model;

import java.io.Serializable;

public class Tbcomentario implements Serializable {
      
    private int bdID;
    private String bdDescricao;
    private Tbreceita bdFKReceita;
    private Tbusuario bdFKUsuario;

    public Tbcomentario() {
    }

    public Tbcomentario(int bdID) {
        this.bdID = bdID;
    }

    public Tbcomentario(int bdID, String bdDescricao) {
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
    public String toString() {
        return "com.senai.quickfood.dao.Tbcomentario[ bdID=" + bdID + " ]";
    }
    
}
