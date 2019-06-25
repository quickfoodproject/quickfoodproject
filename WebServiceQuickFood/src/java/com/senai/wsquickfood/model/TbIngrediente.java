package com.senai.wsquickfood.model;

import java.io.Serializable;

public class TbIngrediente implements Serializable {
    
    private int bdID;    
    private String bdNome; 
    private double bdQuantidade; 
    private int bdUnidadeMedida;
    
    public TbIngrediente() {
    }

    public TbIngrediente(int dbID) {
        this.bdID = dbID;
    }

    public TbIngrediente(int dbID, String bdNome) {
        this.bdID = dbID;
        this.bdNome = bdNome;
    }

    public int getDbID() {
        return bdID;
    }

    public void setDbID(int dbID) {
        this.bdID = dbID;
    }

    public String getBdNome() {
        return bdNome;
    }

    public void setBdNome(String bdNome) {
        this.bdNome = bdNome;
    }     

    public double getQuantidade() {
        return bdQuantidade;
    }
    
    public void setQuantidade(double quantidade) {
        this.bdQuantidade = quantidade;
    }

    public int getUnidadeMedida() {
        return bdUnidadeMedida;
    }

    public void setUnidadeMedida(int unidadeMedida) {
        this.bdUnidadeMedida = unidadeMedida;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingrediente[ dbID=" + bdID + " ]" + "DBNOME = " + bdNome;
    }
    
}
