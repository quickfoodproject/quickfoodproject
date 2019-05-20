package com.senai.quickfood.model;

import java.io.Serializable;
import java.util.Collection;

public class Tbreceita implements Serializable {
   
    private Integer bdID;    
    private String bdNome;    
    private String bdDescricao;   
    private String bdURLlmagem;   
    private Tbusuario bdDKUsuario;
    private Collection<Tbcomentario> tbcomentarioCollection;    
    private Collection<Tbingrediente> tbingredienteCollection;    
    private Collection<Tbavaliacao> tbavaliacaoCollection;

    public Tbreceita() {
    }

    public Tbreceita(Integer bdID) {
        this.bdID = bdID;
    }

    public Tbreceita(Integer bdID, String bdNome, String bdDescricao) {
        this.bdID = bdID;
        this.bdNome = bdNome;
        this.bdDescricao = bdDescricao;
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

    public String getBdDescricao() {
        return bdDescricao;
    }

    public void setBdDescricao(String bdDescricao) {
        this.bdDescricao = bdDescricao;
    }

    public String getBdURLlmagem() {
        return bdURLlmagem;
    }

    public void setBdURLlmagem(String bdURLlmagem) {
        this.bdURLlmagem = bdURLlmagem;
    }

    public Tbusuario getBdDKUsuario() {
        return bdDKUsuario;
    }

    public void setBdDKUsuario(Tbusuario bdDKUsuario) {
        this.bdDKUsuario = bdDKUsuario;
    }

    public Collection<Tbcomentario> getTbcomentarioCollection() {
        return tbcomentarioCollection;
    }

    public void setTbcomentarioCollection(Collection<Tbcomentario> tbcomentarioCollection) {
        this.tbcomentarioCollection = tbcomentarioCollection;
    }
    
    public Collection<Tbingrediente> getTbingredienteCollection() {
        return tbingredienteCollection;
    }

    public void setTbingredienteCollection(Collection<Tbingrediente> tbingredienteCollection) {
        this.tbingredienteCollection = tbingredienteCollection;
    }
   
    public Collection<Tbavaliacao> getTbavaliacaoCollection() {
        return tbavaliacaoCollection;
    }

    public void setTbavaliacaoCollection(Collection<Tbavaliacao> tbavaliacaoCollection) {
        this.tbavaliacaoCollection = tbavaliacaoCollection;
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
        if (!(object instanceof Tbreceita)) {
            return false;
        }
        Tbreceita other = (Tbreceita) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbreceita[ bdID=" + bdID + " ]";
    }
    
}
