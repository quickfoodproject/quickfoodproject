package com.senai.quickfood.model;

import java.io.Serializable;

public class Tbingredientereceita implements Serializable {
   
    private Integer bdID;    
    private double bdQuantidadeIngrediente;   
    private Tbunidademedida bdFKUnidadeMedida;    
    private Tbingrediente bdFKIngrediente;   
    private Tbreceita bdFKReceita;

    public Tbingredientereceita() {
    }

    public Tbingredientereceita(Integer bdID) {
        this.bdID = bdID;
    }

    public Tbingredientereceita(Integer bdID, double bdQuantidadeIngrediente) {
        this.bdID = bdID;
        this.bdQuantidadeIngrediente = bdQuantidadeIngrediente;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
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
    public int hashCode() {
        int hash = 0;
        hash += (bdID != null ? bdID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbingredientereceita)) {
            return false;
        }
        Tbingredientereceita other = (Tbingredientereceita) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingredientereceita[ bdID=" + bdID + " ]";
    }
    
}
