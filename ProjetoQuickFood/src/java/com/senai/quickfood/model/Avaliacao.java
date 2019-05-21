package com.senai.quickfood.model;

import java.io.Serializable;

public class Avaliacao implements Serializable {

    private int bdID;
    private boolean bdJaCurtiu;
    private Receita bdFKReceita;
    private Tbusuario bdFKUsuario;

    public Avaliacao() {
    }

    public Avaliacao(int bdID) {
        this.bdID = bdID;
    }

    public int getBdID() {
        return bdID;
    }

    public void setBdID(int bdID) {
        this.bdID = bdID;
    }

    public boolean getbdJaCurtiu() {
        return bdJaCurtiu;
    }

    public void setbdJaCurtiu(boolean bdJaCurtiu) {
        this.bdJaCurtiu = bdJaCurtiu;
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
        return "com.senai.quickfood.dao.Tbavaliacao[ bdID=" + bdID + " ]";
    }
    
}
