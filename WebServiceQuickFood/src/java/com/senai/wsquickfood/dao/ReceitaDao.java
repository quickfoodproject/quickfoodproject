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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDao {

    private String SELECIONARBYID = "SELECT DISTINCT C.BDNOME NOMERECEITA,\n"
            + "C.BDID IDRECEITA,\n"
            + "C.BDDESCRICAO DESCRICAORECEITA,\n"
            + "C.BDCURTIDAS CURTIDASRECEITA,\n"
            + "D.BDFOTO FOTORECEITA,\n"
            + "A.BDID IDINGREDIENTE,\n"
            + "A.BDNOME NOMEINGREDIENTE,\n"
            + "B.BDQUANTIDADEINGREDIENTE QUANTIDADEINGREDIENTE,\n"
            + "F.BDUNIDADE UNIDADEMEDIDA\n"
            + "FROM TBINGREDIENTE A\n"
            + "INNER JOIN TBINGREDIENTERECEITA B ON (A.BDID = B.BDFKINGREDIENTE)\n"
            + "INNER JOIN TBRECEITA C ON (B.BDFKRECEITA = C.BDID)\n"
            + "LEFT JOIN TBFOTO D ON (C.BDFKFOTO = D.BDID)\n"
            + "INNER JOIN TBUNIDADEMEDIDA F ON (B.BDFKUNIDADEMEDIDA = F.BDID)\n"
            + "WHERE C.BDID = ? \n"
            + "GROUP BY C.BDNOME,\n"
            + "C.BDID,\n"
            + "C.BDDESCRICAO,\n"
            + "C.BDCURTIDAS,\n"
            + "D.BDFOTO,\n"
            + "A.BDID,\n"
            + "A.BDNOME,\n"
            + "B.BDQUANTIDADEINGREDIENTE,\n"
            + "F.BDUNIDADE\n"
            + "ORDER BY A.BDID;";

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

    private String BUSCALIKESRECEITA = "SELECT BDCURTIDAS CURTIDASRECEITA \n"
            + "FROM TBRECEITA \n"
            + "WHERE BDID = ?";

    private String UPDATELIKESDARECEITA = "UPDATE TBRECEITA \n"
            + "SET BDCURTIDAS = ? \n"
            + "WHERE BDID = ?";

    private String INSERTRECEITA = "INSERT INTO TBRECEITA(BDID, BDNOME, BDDESCRICAO, BDFKFOTO, BDFKUSUARIO) VALUES (0, ?, ?, ?, ?)";
    private String INSERTINGREDIENTERECEITA = "INSERT INTO TBINGREDIENTERECEITA (BDQUANTIDADEINGREDIENTE, BDFKRECEITA, BDFKINGREDIENTE, BDFKUNIDADEMEDIDA) VALUES (?, ?, ?, ?)";
    private String SELECTNOMERECEITA = "SELECT BDNOME FROM TBRECEITA WHERE BDNOME = ?";

    private String NOMERECEITA = "NOMERECEITA";
    private String IDRECEITA = "IDRECEITA";
    private String DESCRICAORECEITA = "DESCRICAORECEITA";
    private String CURTIDASRECEITA = "CURTIDASRECEITA";
    private String FOTORECEITA = "FOTORECEITA";
    private String IDINGREDIENTE = "IDINGREDIENTE";
    private String NOMEINGREDIENTE = "NOMEINGREDIENTE";
    private String QUANTIDADEINGREDIENTE = "QUANTIDADEINGREDIENTE";
    private String UNIDADEMEDIDA = "UNIDADEMEDIDA";
    private int SEMFOTO = 0;    

    private boolean validarNomeReceita(String nomeReceita) {
        Repository conexao = Repository.getInstance();

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(SELECTNOMERECEITA);
            ps.setString(1, nomeReceita);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.getMessage().toString();
        }
        return false;
    }

    public String cadastrarReceita(TbReceita receita, List<TbIngrediente> listaIngrediente) {
        if (validarNomeReceita(receita.getBdNome())) {
            return "Já existe essa receita cadastrada";
        }
        Repository conexao = Repository.getInstance();

        try {
            conexao.open();
            conexao.preparedStatement = conexao.conection.prepareStatement(INSERTRECEITA, PreparedStatement.RETURN_GENERATED_KEYS);
            conexao.preparedStatement.setString(1, receita.getBdNome());
            conexao.preparedStatement.setString(2, receita.getBdDescricao());

            if (receita.getBdFkFoto() != null) {
                conexao.preparedStatement.setInt(3, receita.getBdFkFoto().getBdId());
            } else {
                conexao.preparedStatement.setInt(3, SEMFOTO);
            }

            conexao.preparedStatement.setInt(4, receita.getBdDKUsuario().getBdID());
            conexao.preparedStatement.execute();

            ResultSet rs = conexao.preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                receita.setBdID(rs.getInt(1));
            }

            listaIngrediente.forEach((tbIngrediente) -> {
                String erro = cadastrarIngredienteReceita(receita.getBdID(), tbIngrediente);
            });

        } catch (SQLException e) {
            return "Erro ao cadastrar uma nova receita" + e.getMessage();
        } finally {
            conexao.close();
        }

        return "Receita cadastrada com sucesso";
    }

    private String cadastrarIngredienteReceita(int idReceita, TbIngrediente ingrediente) {
        Repository conexao = Repository.getInstance();

        try {

            conexao.preparedStatement = conexao.conection.prepareStatement(INSERTINGREDIENTERECEITA);
            conexao.preparedStatement.setDouble(1, ingrediente.getQuantidade());
            conexao.preparedStatement.setInt(2, idReceita);
            conexao.preparedStatement.setInt(3, ingrediente.getDbID());
            conexao.preparedStatement.setInt(4, ingrediente.getUnidadeMedida());
            conexao.preparedStatement.execute();

        } catch (SQLException e) {
            return e.getMessage().toString();
        }

        return null;
    }

    public int updateCurtidasReceita(int idReceita, boolean incrementa) {

        int totalCurtidas = 0;
        totalCurtidas = buscaCurtidas(idReceita);

        if (incrementa) {
            totalCurtidas++;
        } else {
            totalCurtidas--;
        }

        Repository conexao = Repository.getInstance();

        try {
            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(UPDATELIKESDARECEITA);
            conexao.preparedStatement.setInt(1, totalCurtidas);
            conexao.preparedStatement.setInt(2, idReceita);
            conexao.preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar curtidas: " + e.toString());
        } finally {
            conexao.close();
        }

        return totalCurtidas;
    }

    public int buscaCurtidas(int idReceita) {
        int retorno = 0;
        Repository conexao = Repository.getInstance();

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(BUSCALIKESRECEITA);
            ps.setInt(1, idReceita);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                retorno = rs.getInt(CURTIDASRECEITA);
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.toString());
        } finally {
            conexao.close();
        }

        return retorno;
    }

    public String selecionarReceitaById(Integer pIdReceita) {

        Repository conexao = Repository.getInstance();
        TbIngrediente ingrediente;
        TbReceita receita;
        List<TbIngrediente> listaIngrediente;
        List<TbAvaliacao> listaComentario;
        AvaliacaoDao avaliacaoDao;
        Gson google = new Gson();

        String json = "";

        int idReceita = 0;
        int idIngrediente = 0;

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(SELECIONARBYID);
            ps.setInt(1, pIdReceita);
            ResultSet rs = ps.executeQuery();
            receita = new TbReceita();
            listaIngrediente = new ArrayList<>();

            while (rs.next()) {
                ingrediente = new TbIngrediente();

                if (!((rs.getInt(IDRECEITA)) == idReceita)) {

                    receita.setBdID(rs.getInt(IDRECEITA));
                    receita.setBdNome(rs.getString(NOMERECEITA));
                    receita.setBdDescricao(rs.getString(DESCRICAORECEITA));
                    receita.setBdCurtidas(rs.getInt(CURTIDASRECEITA));
                    receita.setBdURLlmagem(Utils.retiraQuebraDeLinha(rs.getString(FOTORECEITA)));

                    idReceita = rs.getInt(IDRECEITA);
                }
                if (!((rs.getInt(IDINGREDIENTE)) == idIngrediente)) {

                    ingrediente.setDbID(rs.getInt(IDINGREDIENTE));
                    ingrediente.setBdNome(rs.getString(NOMEINGREDIENTE));
                    ingrediente.setQuantidade(rs.getDouble(QUANTIDADEINGREDIENTE));
                    ingrediente.setUnidadeMedidaString(rs.getString(UNIDADEMEDIDA));

                    idIngrediente = rs.getInt(IDINGREDIENTE);

                    listaIngrediente.add(ingrediente);
                }

            }

            avaliacaoDao = new AvaliacaoDao();
            listaComentario = new ArrayList<>();
            listaComentario = avaliacaoDao.buscaComentariosDaReceita(pIdReceita, false);

            receita.setTbingredienteCollection(listaIngrediente);
            receita.setTbavaliacaoCollection(listaComentario);

            google = new Gson();
            json = google.toJson(receita);

        } catch (SQLException e) {
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
        String json = "[";

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(SELECIONARBYINGREDIENTE);
            ps.setString(1, Utils.listaParaString(pNomeIngredientes, ','));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                receita.setBdID(rs.getInt(IDRECEITA));
                receita.setBdNome(rs.getString(NOMERECEITA));
                receita.setBdCurtidas(rs.getInt(CURTIDASRECEITA));
                receita.setBdURLlmagem(Utils.retiraQuebraDeLinha(rs.getString(FOTORECEITA)));

                json = json + google.toJson(receita) + ",";
            }
            
            json = json.substring(0, json.length() - 1);
            
            json += "]";

        } catch (SQLException e) {
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
        String json = "[";

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(SELECIONARRECEITASTOP5);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                receita.setBdID(rs.getInt(IDRECEITA));
                receita.setBdNome(rs.getString(NOMERECEITA));
                receita.setBdCurtidas(rs.getInt(CURTIDASRECEITA));
                receita.setBdURLlmagem(Utils.retiraQuebraDeLinha(rs.getString(FOTORECEITA)));

                json = json + google.toJson(receita) + ",";
            }
            
            json = json.substring(0, json.length() - 1);
            
            json += "]";

        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            conexao.close();
        }

        return json;
    }

}
