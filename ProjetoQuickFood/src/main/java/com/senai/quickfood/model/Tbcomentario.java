/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.quickfood.model;

import java.io.Serializable;

public class Tbcomentario implements Serializable {
      
    private Integer bdID;
    private String bdDescricao;
    private Tbreceita bdFKReceita;
    private Tbusuario bdFKUsuario;

    public Tbcomentario() {
    }

    public Tbcomentario(Integer bdID) {
        this.bdID = bdID;
    }

    public Tbcomentario(Integer bdID, String bdDescricao) {
        this.bdID = bdID;
        this.bdDescricao = bdDescricao;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
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
    public int hashCode() {
        int hash = 0;
        hash += (bdID != null ? bdID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbcomentario)) {
            return false;
        }
        Tbcomentario other = (Tbcomentario) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbcomentario[ bdID=" + bdID + " ]";
    }
    
}
