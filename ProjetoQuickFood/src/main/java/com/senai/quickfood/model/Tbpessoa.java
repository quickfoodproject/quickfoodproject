package com.senai.quickfood.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class Tbpessoa implements Serializable {
   
    private Integer bdID;   
    private String bdNome;
    private String bdSexo;   
    private Date bdDataNascimento;    
    private Collection<Tbusuario> tbusuarioCollection;

    public Tbpessoa() {
    }

    public Tbpessoa(Integer bdID) {
        this.bdID = bdID;
    }

    public Tbpessoa(Integer bdID, String bdNome, String bdSexo, Date bdDataNascimento) {
        this.bdID = bdID;
        this.bdNome = bdNome;
        this.bdSexo = bdSexo;
        this.bdDataNascimento = bdDataNascimento;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
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

    public Collection<Tbusuario> getTbusuarioCollection() {
        return tbusuarioCollection;
    }

    public void setTbusuarioCollection(Collection<Tbusuario> tbusuarioCollection) {
        this.tbusuarioCollection = tbusuarioCollection;
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
        if (!(object instanceof Tbpessoa)) {
            return false;
        }
        Tbpessoa other = (Tbpessoa) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbpessoa[ bdID=" + bdID + " ]";
    }
    
}
