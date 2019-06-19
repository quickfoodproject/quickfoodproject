package com.senai.wsquickfood.dao;

import com.google.gson.Gson;
import com.senai.wsquickfood.model.TbIngrediente;
import com.senai.wsquickfood.repository.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;

public class IngredienteDAO {

    String INSERT = "INSERT INTO TBINGREDIENTE (BDID, BDNOME) VALUES (0, ?)";
    String UPDATE = "UPDATE TBINGREDIENTE SET BDNOME = ? WHERE BDID = ?";
    String DELETE = "DELETE FROM TBINGREDIENTE WHERE ID = ?";
    String SELECTALL = "SELECT * FROM TBINGREDIENTE ORDER BY BDNOME";
    String SELECTBYID = "SELECT * FROM TBINGREDIENTE WHERE BDID = ";
    String SELECTNOME = "SELECT * FROM TBINGREDIENTE WHERE BDNOME = ?";

    public String salvar(TbIngrediente pIngrediente) {
        if (validaNome(pIngrediente.getBdNome())) {
            return "O nome informado já existe";
        }
        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(INSERT);
            conexao.preparedStatement.setString(1, pIngrediente.getBdNome());

            conexao.preparedStatement.execute();
            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de INSERT: " + e.toString());
        }

        return "Ingrediente salvo com sucesso";
    }

    public void update(TbIngrediente pIngrediente) {
        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(UPDATE);
            conexao.preparedStatement.setString(1, pIngrediente.getBdNome());
            conexao.preparedStatement.setInt(2, pIngrediente.getDbID());

            conexao.preparedStatement.execute();
            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de UPDATE: " + e.toString());
        }
    }

    public String getAll() {
        String json = "";
        TbIngrediente ingrediente = null;
        Gson g = new Gson();
        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery(SELECTALL);

            while (conexao.resultSet.next()) {
                ingrediente = new TbIngrediente();

                ingrediente.setDbID(conexao.resultSet.getInt("BDID"));
                ingrediente.setBdNome(conexao.resultSet.getString("BDNOME"));

                json = json + g.toJson(ingrediente) + ";";
            }

            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de SELECT ALL: " + e.toString());
        }
        return json;
    }

    public boolean validaNome(String pNome) {
        Repository conexao = Repository.getInstance();

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(SELECTNOME);
            ps.setString(1, pNome);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao tentar selecionar o nome do ingrediente = " + e.toString());
        } finally {
            conexao.close();
        }

        return false;
    }

    public List<TbIngrediente> getAllNome(String pNome) {
        List<TbIngrediente> ingredientes = new ArrayList();
        TbIngrediente ingrediente = null;

        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery("SELECT * FROM TBINGREDIENTE WHERE BDNOME LIKE '" + pNome + "%' ORDER BY BDNOME");

            while (conexao.resultSet.next()) {

                ingrediente = new TbIngrediente();

                ingrediente.setDbID(conexao.resultSet.getInt("BDID"));
                ingrediente.setBdNome(conexao.resultSet.getString("BDNOME"));

                ingredientes.add(ingrediente);

            }

            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de SELECT ALL: " + e.toString());
        }
        return ingredientes;
    }

    public TbIngrediente getById(int id) {
        TbIngrediente ingrediente = null;

        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery(SELECTBYID + id);

            while (conexao.resultSet.next()) {
                ingrediente = new TbIngrediente();

                ingrediente.setDbID(conexao.resultSet.getInt("BDID"));
                ingrediente.setBdNome(conexao.resultSet.getString("BDNOME"));

            }

            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de SELECT por ID: " + e.toString());
        }
        return ingrediente;
    }

}
