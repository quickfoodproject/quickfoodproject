package com.senai.wsquickfood.model;

import java.io.Serializable;

public class TbIngredienteReceita implements Serializable {
   
    private int bdID;    
    private double bdQuantidadeIngrediente;   
    private TbUnidadeMedida bdFKUnidadeMedida;    
    private TbIngrediente bdFKIngrediente;   
    private TbReceita bdFKReceita;

    public TbIngredienteReceita() {
    }

    public TbIngredienteReceita(int bdID) {
        this.bdID = bdID;
    }

    public TbIngredienteReceita(int bdID, double bdQuantidadeIngrediente) {
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

    public TbUnidadeMedida getBdFKUnidadeMedida() {
        return bdFKUnidadeMedida;
    }

    public void setBdFKUnidadeMedida(TbUnidadeMedida bdFKUnidadeMedida) {
        this.bdFKUnidadeMedida = bdFKUnidadeMedida;
    }

    public TbIngrediente getBdFKIngrediente() {
        return bdFKIngrediente;
    }

    public void setBdFKIngrediente(TbIngrediente bdFKIngrediente) {
        this.bdFKIngrediente = bdFKIngrediente;
    }

    public TbReceita getBdFKReceita() {
        return bdFKReceita;
    }

    public void setBdFKReceita(TbReceita bdFKReceita) {
        this.bdFKReceita = bdFKReceita;
    } 

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingredientereceita[ bdID=" + bdID + " ]";
    }
    
}
