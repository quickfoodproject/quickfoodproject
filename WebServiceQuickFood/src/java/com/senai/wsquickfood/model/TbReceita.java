package com.senai.wsquickfood.model;

import java.io.Serializable;
import java.util.Collection;

public class TbReceita implements Serializable {

    private int bdID;
    private String bdNome;
    private String bdDescricao;
    private String bdURLlmagem;
    private TbFoto bdFkFoto;
    private int bdCurtidas;
    private TbUsuario bdDKUsuario;
    private Collection<TbIngrediente> tbingredienteCollection;
    private Collection<TbAvaliacao> tbavaliacaoCollection;

    public TbReceita() {
    }

    public TbReceita(int bdID) {
        this.bdID = bdID;
    }

    public TbReceita(int bdID, String bdNome, String bdDescricao) {
        this.bdID = bdID;
        this.bdNome = bdNome;
        this.bdDescricao = bdDescricao;
    }

    public TbFoto getBdFkFoto() {
        return bdFkFoto;
    }

    public void setBdFkFoto(TbFoto bdFkFoto) {
        this.bdFkFoto = bdFkFoto;
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

    public TbUsuario getBdDKUsuario() {
        return bdDKUsuario;
    }

    public void setBdDKUsuario(TbUsuario bdDKUsuario) {
        this.bdDKUsuario = bdDKUsuario;
    }

    public Collection<TbIngrediente> getTbingredienteCollection() {
        return tbingredienteCollection;
    }

    public void setTbingredienteCollection(Collection<TbIngrediente> tbingredienteCollection) {
        this.tbingredienteCollection = tbingredienteCollection;
    }

    public Collection<TbAvaliacao> getTbavaliacaoCollection() {
        return tbavaliacaoCollection;
    }

    public void setTbavaliacaoCollection(Collection<TbAvaliacao> tbavaliacaoCollection) {
        this.tbavaliacaoCollection = tbavaliacaoCollection;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbreceita[ bdID=" + bdID + " ]";
    }

}
