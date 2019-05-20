package com.senai.quickfood.model;

import java.io.Serializable;

public class Tbingrediente implements Serializable {
    
    private Integer dbID;    
    private String bdNome; 

    public Tbingrediente() {
    }

    public Tbingrediente(Integer dbID) {
        this.dbID = dbID;
    }

    public Tbingrediente(Integer dbID, String bdNome) {
        this.dbID = dbID;
        this.bdNome = bdNome;
    }

    public Integer getDbID() {
        return dbID;
    }

    public void setDbID(Integer dbID) {
        this.dbID = dbID;
    }

    public String getBdNome() {
        return bdNome;
    }

    public void setBdNome(String bdNome) {
        this.bdNome = bdNome;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbID != null ? dbID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbingrediente)) {
            return false;
        }
        Tbingrediente other = (Tbingrediente) object;
        if ((this.dbID == null && other.dbID != null) || (this.dbID != null && !this.dbID.equals(other.dbID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingrediente[ dbID=" + dbID + " ]";
    }
    
}
