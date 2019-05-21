package com.senai.quickfood.model;

import java.io.Serializable;

public class UnidadeMedida implements Serializable {
   
    private int bdID;   
    private String bdUnidade;   

    public UnidadeMedida() {
    }

    public UnidadeMedida(int bdID) {
        this.bdID = bdID;
    }

    public int getBdID() {
        return bdID;
    }

    public void setBdID(int bdID) {
        this.bdID = bdID;
    }

    public String getBdUnidade() {
        return bdUnidade;
    }

    public void setBdUnidade(String bdUnidade) {
        this.bdUnidade = bdUnidade;
    }   
  
    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbunidademedida[ bdID=" + bdID + " ]";
    }
    
}
