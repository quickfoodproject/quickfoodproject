package com.senai.quickfood.model;

import java.io.Serializable;

public class Tbunidademedida implements Serializable {
   
    private Integer bdID;   
    private String bdUnidade;   

    public Tbunidademedida() {
    }

    public Tbunidademedida(Integer bdID) {
        this.bdID = bdID;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
        this.bdID = bdID;
    }

    public String getBdUnidade() {
        return bdUnidade;
    }

    public void setBdUnidade(String bdUnidade) {
        this.bdUnidade = bdUnidade;
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
        if (!(object instanceof Tbunidademedida)) {
            return false;
        }
        Tbunidademedida other = (Tbunidademedida) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbunidademedida[ bdID=" + bdID + " ]";
    }
    
}
