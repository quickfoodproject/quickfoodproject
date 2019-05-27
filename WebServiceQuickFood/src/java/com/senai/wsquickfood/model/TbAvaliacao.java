package com.senai.wsquickfood.model;

import java.io.Serializable;
import java.util.Date;

public class TbAvaliacao implements Serializable {

    private int bdID;
    private boolean bdJaCurtiu;
    private double bdNota;
    private Date bdDataAvaliacao;
    private String bdDescricao;
    private TbReceita bdFKReceita;
    private TbUsuario bdFKUsuario;

    public TbAvaliacao() {
    }

    public TbAvaliacao(int bdID) {
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

    public TbReceita getBdFKReceita() {
        return bdFKReceita;
    }

    public void setBdFKReceita(TbReceita bdFKReceita) {
        this.bdFKReceita = bdFKReceita;
    }

    public TbUsuario getBdFKUsuario() {
        return bdFKUsuario;
    }

    public void setBdFKUsuario(TbUsuario bdFKUsuario) {
        this.bdFKUsuario = bdFKUsuario;
    }

    public boolean isBdJaCurtiu() {
        return bdJaCurtiu;
    }

    public void setBdJaCurtiu(boolean bdJaCurtiu) {
        this.bdJaCurtiu = bdJaCurtiu;
    }

    public double getBdNota() {
        return bdNota;
    }

    public void setBdNota(double bdNota) {
        this.bdNota = bdNota;
    }

    public Date getBdDataAvaliacao() {
        return bdDataAvaliacao;
    }

    public void setBdDataAvaliacao(Date bdDataAvaliacao) {
        this.bdDataAvaliacao = bdDataAvaliacao;
    }

    public String getBdDescricao() {
        return bdDescricao;
    }

    public void setBdDescricao(String bdDescricao) {
        this.bdDescricao = bdDescricao;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbavaliacao[ bdID=" + bdID + " ]";
    }

}
