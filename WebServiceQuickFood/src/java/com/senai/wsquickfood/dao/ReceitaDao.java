/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.dao;

import com.google.gson.Gson;
import com.senai.wsquickfood.controller.Utils;
import com.senai.wsquickfood.model.TbAvaliacao;
import com.senai.wsquickfood.model.TbIngrediente;
import com.senai.wsquickfood.model.TbReceita;
import com.senai.wsquickfood.repository.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDao {

    private String SELECIONARBYID = "SELECT C.BDNOME NOMERECEITA,\n"
            + "C.BDID IDRECEITA,\n"
            + "C.BDDESCRICAO DESCRICAORECEITA,\n"
            + "C.BDCURTIDAS CURTIDASRECEITA,\n"
            + "D.BDFOTO FOTORECEITA,\n"
            + "A.BDID IDINGREDIENTE,\n"
            + "A.BDNOME NOMEINGREDIENTE,\n"
            + "B.BDQUANTIDADEINGREDIENTE QUANTIDADEINGREDIENTE,\n"
            + "F.BDUNIDADE UNIDADEMEDIDA,\n"
            + "E.BDID IDAVALIACAO,\n"
            + "E.BDDESCRICAO COMENTARIO\n"
            + "FROM TBINGREDIENTE A\n"
            + "INNER JOIN TBINGREDIENTERECEITA B ON (A.BDID = B.BDFKINGREDIENTE)\n"
            + "INNER JOIN TBRECEITA C ON (B.BDFKRECEITA = C.BDID)\n"
            + "LEFT JOIN TBFOTO D ON (C.BDFKFOTO = D.BDID)\n"
            + "LEFT JOIN TBAVALIACAO E ON (C.BDID = E.BDFKRECEITA)\n"
            + "INNER JOIN TBUNIDADEMEDIDA F ON (B.BDFKUNIDADEMEDIDA = F.BDID)\n"
            + "WHERE C.BDID = ? ORDER BY E.BDDESCRICAO";

    private String SELECIONARBYINGREDIENTE = "SELECT DISTINCT C.BDID IDRECEITA,\n"
            + "D.BDFOTO FOTORECEITA,\n"
            + "C.BDNOME NOMERECEITA,\n"
            + "C.BDCURTIDAS CURTIDASRECEITA\n"
            + "FROM TBINGREDIENTE A\n"
            + "INNER JOIN TBINGREDIENTERECEITA B ON (A.BDID = B.BDFKINGREDIENTE)\n"
            + "INNER JOIN TBRECEITA C ON (B.BDFKRECEITA = C.BDID)\n"
            + "LEFT JOIN TBFOTO D ON (C.BDFKFOTO = D.BDID)\n"
            + "WHERE A.BDNOME IN (?)\n"
            + "ORDER BY C.BDCURTIDAS DESC";

    private String SELECIONARRECEITASTOP5 = "SELECT DISTINCT A.BDID IDRECEITA,\n"
            + " B.BDFOTO FOTORECEITA,\n"
            + " A.BDNOME NOMERECEITA,\n"
            + " A.BDCURTIDAS CURTIDASRECEITA\n"
            + " FROM TBRECEITA A\n"
            + " LEFT JOIN TBFOTO B ON (A.BDFKFOTO = B.BDID)\n"
            + " ORDER BY A.BDCURTIDAS DESC\n"
            + " LIMIT 5";

    private String NOMERECEITA = "NOMERECEITA";
    private String IDRECEITA = "IDRECEITA";
    private String DESCRICAORECEITA = "DESCRICAORECEITA";
    private String CURTIDASRECEITA = "CURTIDASRECEITA";
    private String FOTORECEITA = "FOTORECEITA";
    private String IDINGREDIENTE = "IDINGREDIENTE";
    private String NOMEINGREDIENTE = "NOMEINGREDIENTE";
    private String QUANTIDADEINGREDIENTE = "QUANTIDADEINGREDIENTE";
    private String UNIDADEMEDIDA = "UNIDADEMEDIDA";
    private String IDAVALIACAO = "IDAVALIACAO";
    private String COMENTARIO = "COMENTARIO";

    public String selecionarReceitaById(Integer pIdReceita) {

        Repository conexao = Repository.getInstance();
        List<TbIngrediente> listaIngrediente = new ArrayList<>();
        List<TbAvaliacao> listaComentario = new ArrayList<>();

        Gson google = new Gson();

        TbIngrediente ingrediente = new TbIngrediente();
        TbReceita receita = new TbReceita();
        TbAvaliacao avaliacao = new TbAvaliacao();

        String json = "";

        String comentario = "";
        String nomeIngrediente = "";
        int idReceita = 0;

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(SELECIONARBYID);
            ps.setInt(1, pIdReceita);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                avaliacao = new TbAvaliacao();
                ingrediente = new TbIngrediente();
                if (!((rs.getInt(IDRECEITA)) == idReceita)) {

                    receita.setBdID(rs.getInt(IDRECEITA));
                    receita.setBdNome(rs.getString(NOMERECEITA));
                    receita.setBdDescricao(rs.getString(DESCRICAORECEITA));
                    receita.setBdCurtidas(rs.getInt(CURTIDASRECEITA));
                    receita.setBdURLlmagem(rs.getString(FOTORECEITA));

                    idReceita = rs.getInt(IDRECEITA);
                }
                if (!rs.getString(NOMEINGREDIENTE).equals(nomeIngrediente)) {

                    ingrediente.setDbID(rs.getInt(IDINGREDIENTE));
                    ingrediente.setBdNome(rs.getString(NOMEINGREDIENTE));
                    ingrediente.setQuantidade(rs.getDouble(QUANTIDADEINGREDIENTE));
                    ingrediente.setUnidadeMedida(rs.getString(UNIDADEMEDIDA));

                    nomeIngrediente = rs.getString(NOMEINGREDIENTE);
                    listaIngrediente.add(ingrediente);
                }

                if (!rs.getString(COMENTARIO).equals(comentario)) {

                    avaliacao.setBdID(rs.getInt(IDAVALIACAO));
                    avaliacao.setBdDescricao(rs.getString(COMENTARIO));
                    comentario = rs.getString(COMENTARIO);
                    listaComentario.add(avaliacao);
                }

            }

            receita.setTbingredienteCollection(listaIngrediente);
            receita.setTbavaliacaoCollection(listaComentario);

            json = google.toJson(receita);

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            conexao.close();
        }

        return json;
    }

    public String selecionarByIngrediente(List<String> pNomeIngredientes) {

        Repository conexao = Repository.getInstance();

        Gson google = new Gson();

        TbReceita receita = new TbReceita();
        String json = "";

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(SELECIONARBYINGREDIENTE);
            ps.setString(1, Utils.listaParaString(pNomeIngredientes, ','));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                receita.setBdID(rs.getInt(IDRECEITA));
                receita.setBdNome(rs.getString(NOMERECEITA));
                receita.setBdCurtidas(rs.getInt(CURTIDASRECEITA));
                receita.setBdURLlmagem(rs.getString(FOTORECEITA));
            }

            json = google.toJson(receita);

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            conexao.close();
        }

        return json;
    }
    
    public String listarReceitasTop() {

        Repository conexao = Repository.getInstance();

        Gson google = new Gson();

        TbReceita receita = new TbReceita();
        String json = "";

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(SELECIONARRECEITASTOP5);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                receita.setBdID(rs.getInt(IDRECEITA));
                receita.setBdNome(rs.getString(NOMERECEITA));
                receita.setBdCurtidas(rs.getInt(CURTIDASRECEITA));
                receita.setBdURLlmagem(rs.getString(FOTORECEITA));
            }

            json = google.toJson(receita);

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            conexao.close();
        }

        return json;
    }
}
