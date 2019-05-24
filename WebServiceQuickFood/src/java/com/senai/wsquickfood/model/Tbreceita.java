package com.senai.wsquickfood.model;

import java.io.Serializable;
import java.util.Collection;

public class Tbreceita implements Serializable {
   
    private int bdID;    
    private String bdNome;    
    private String bdDescricao;   
    private String bdURLlmagem;  
    private int bdCurtidas;   
    private Tbusuario bdDKUsuario;  
    private Collection<Tbingrediente> tbingredienteCollection;    
    private Collection<Tbavaliacao> tbavaliacaoCollection;

    public Tbreceita() {
    }

    public Tbreceita(int bdID) {
        this.bdID = bdID;
    }

    public Tbreceita(int bdID, String bdNome, String bdDescricao) {
        this.bdID = bdID;
        this.bdNome = bdNome;
        this.bdDescricao = bdDescricao;
    }

    public int getBdID() {
        return bdID;
    }

    public void setBdID(int bdID) {
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

    public int getBdCurtidas() {
        return bdCurtidas;
    }

    public void setBdCurtidas(int bdCurtidas) {
        this.bdCurtidas = bdCurtidas;
    }    
    
    public Tbusuario getBdDKUsuario() {
        return bdDKUsuario;
    }

    public void setBdDKUsuario(Tbusuario bdDKUsuario) {
        this.bdDKUsuario = bdDKUsuario;
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
    public String toString() {
        return "com.senai.quickfood.dao.Tbreceita[ bdID=" + bdID + " ]";
    }
    
}
