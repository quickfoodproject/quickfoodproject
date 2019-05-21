package com.senai.quickfood.model;

import java.io.Serializable;
import java.util.Collection;

public class Receita implements Serializable {
   
    private int bdID;    
    private String bdNome;    
    private String bdDescricao;   
    private String bdURLlmagem;  
    private int bdCurtidas;   
    private Tbusuario bdDKUsuario;
    private Collection<Comentario> tbcomentarioCollection;    
    private Collection<Ingrediente> tbingredienteCollection;    
    private Collection<Avaliacao> tbavaliacaoCollection;

    public Receita() {
    }

    public Receita(int bdID) {
        this.bdID = bdID;
    }

    public Receita(int bdID, String bdNome, String bdDescricao) {
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

    public Collection<Comentario> getTbcomentarioCollection() {
        return tbcomentarioCollection;
    }

    public void setTbcomentarioCollection(Collection<Comentario> tbcomentarioCollection) {
        this.tbcomentarioCollection = tbcomentarioCollection;
    }
    
    public Collection<Ingrediente> getTbingredienteCollection() {
        return tbingredienteCollection;
    }

    public void setTbingredienteCollection(Collection<Ingrediente> tbingredienteCollection) {
        this.tbingredienteCollection = tbingredienteCollection;
    }
   
    public Collection<Avaliacao> getTbavaliacaoCollection() {
        return tbavaliacaoCollection;
    }

    public void setTbavaliacaoCollection(Collection<Avaliacao> tbavaliacaoCollection) {
        this.tbavaliacaoCollection = tbavaliacaoCollection;
    }
   
    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbreceita[ bdID=" + bdID + " ]";
    }
    
}
