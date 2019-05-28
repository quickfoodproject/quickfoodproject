package com.senai.wsquickfood.dao;

import com.senai.wsquickfood.model.TbIngrediente;
import com.senai.wsquickfood.repository.Repository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO {

    String INSERT = "INSERT INTO TBINGREDIENTE (BDID, BDNOME) VALUES (0, ?)";
    String UPDATE = "UPDATE TBINGREDIENTE SET BDNOME = ? WHERE BDID = ?";
    String DELETE = "DELETE FROM TBINGREDIENTE WHERE ID = ?";
    String SELECTALL = "SELECT * FROM TBINGREDIENTE ORDER BY BDNOME";
    String SELECTBYID = "SELECT * FROM TBINGREDIENTE WHERE BDID = ";

    public void save(TbIngrediente pIngrediente) {
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
    
    public List<TbIngrediente> getAll() {
        List<TbIngrediente> ingredientes = new ArrayList();
        TbIngrediente ingrediente = null;

        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery(SELECTALL);

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
