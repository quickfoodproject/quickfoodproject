package com.senai.wsquickfood.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class TbPessoa implements Serializable {
       
    private int bdID;   
    private String bdNome;
    private String bdSexo;   
    private Date bdDataNascimento;    
    private Collection<TbUsuario> tbusuarioCollection;

    public TbPessoa() {
    }

    public TbPessoa(int bdID) {
        this.bdID = bdID;
    }

    public TbPessoa(int bdID, String bdNome, String bdSexo, Date bdDataNascimento) {
        this.bdID = bdID;
        this.bdNome = bdNome;
        this.bdSexo = bdSexo;
        this.bdDataNascimento = bdDataNascimento;
    }

    public int getBdID() {
        return bdID;
    }

    public void setBdID(int bdID) {
        this.bdID = bdID;
    }

    public String getBdNome() {
        return bdNome;
    }

    public void setBdNome(String bdNome) {
        this.bdNome = bdNome;
    }

    public String getBdSexo() {
        return bdSexo;
    }

    public void setBdSexo(String bdSexo) {
        this.bdSexo = bdSexo;
    }

    public Date getBdDataNascimento() {
        return bdDataNascimento;
    }

    public void setBdDataNascimento(Date bdDataNascimento) {
        this.bdDataNascimento = bdDataNascimento;
    }

    public Collection<TbUsuario> getTbusuarioCollection() {
        return tbusuarioCollection;
    }

    public void setTbusuarioCollection(Collection<TbUsuario> tbusuarioCollection) {
        this.tbusuarioCollection = tbusuarioCollection;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbpessoa[ bdID=" + bdID + " ]";
    }
    
}
