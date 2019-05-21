package com.senai.wsquickfood.model;

import java.io.Serializable;

public class Tbingredientereceita implements Serializable {
   
    private int bdID;    
    private double bdQuantidadeIngrediente;   
    private Tbunidademedida bdFKUnidadeMedida;    
    private Tbingrediente bdFKIngrediente;   
    private Tbreceita bdFKReceita;

    public Tbingredientereceita() {
    }

    public Tbingredientereceita(int bdID) {
        this.bdID = bdID;
    }

    public Tbingredientereceita(int bdID, double bdQuantidadeIngrediente) {
        this.bdID = bdID;
        this.bdQuantidadeIngrediente = bdQuantidadeIngrediente;
    }

    public int getBdID() {
        return bdID;
    }

    public void setBdID(int bdID) {
        this.bdID = bdID;
    }

    public double getBdQuantidadeIngrediente() {
        return bdQuantidadeIngrediente;
    }

    public void setBdQuantidadeIngrediente(double bdQuantidadeIngrediente) {
        this.bdQuantidadeIngrediente = bdQuantidadeIngrediente;
    }

    public Tbunidademedida getBdFKUnidadeMedida() {
        return bdFKUnidadeMedida;
    }

    public void setBdFKUnidadeMedida(Tbunidademedida bdFKUnidadeMedida) {
        this.bdFKUnidadeMedida = bdFKUnidadeMedida;
    }

    public Tbingrediente getBdFKIngrediente() {
        return bdFKIngrediente;
    }

    public void setBdFKIngrediente(Tbingrediente bdFKIngrediente) {
        this.bdFKIngrediente = bdFKIngrediente;
    }

    public Tbreceita getBdFKReceita() {
        return bdFKReceita;
    }

    public void setBdFKReceita(Tbreceita bdFKReceita) {
        this.bdFKReceita = bdFKReceita;
    } 

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingredientereceita[ bdID=" + bdID + " ]";
    }
    
}
