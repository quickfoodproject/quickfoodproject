package com.senai.quickfood.model;

import java.io.Serializable;

public class Ingredientereceita implements Serializable {
   
    private int bdID;    
    private double bdQuantidadeIngrediente;   
    private UnidadeMedida bdFKUnidadeMedida;    
    private Ingrediente bdFKIngrediente;   
    private Receita bdFKReceita;

    public Ingredientereceita() {
    }

    public Ingredientereceita(int bdID) {
        this.bdID = bdID;
    }

    public Ingredientereceita(int bdID, double bdQuantidadeIngrediente) {
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

    public UnidadeMedida getBdFKUnidadeMedida() {
        return bdFKUnidadeMedida;
    }

    public void setBdFKUnidadeMedida(UnidadeMedida bdFKUnidadeMedida) {
        this.bdFKUnidadeMedida = bdFKUnidadeMedida;
    }

    public Ingrediente getBdFKIngrediente() {
        return bdFKIngrediente;
    }

    public void setBdFKIngrediente(Ingrediente bdFKIngrediente) {
        this.bdFKIngrediente = bdFKIngrediente;
    }

    public Receita getBdFKReceita() {
        return bdFKReceita;
    }

    public void setBdFKReceita(Receita bdFKReceita) {
        this.bdFKReceita = bdFKReceita;
    } 

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingredientereceita[ bdID=" + bdID + " ]";
    }
    
}
