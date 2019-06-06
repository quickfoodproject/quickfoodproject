package com.senai.wsquickfood.dao;

import java.sql.PreparedStatement;
import com.senai.wsquickfood.model.TbPessoa;
import com.senai.wsquickfood.repository.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaDAO {

    String SELECT = "SELECT BDID, BDNOME, BDSEXO, BDDATANASCIMENTO  FROM TBPESSOA WHERE BDID = ? AND BDNOME = ?";
    String UPDATE = "UPDATE TBPESSOA SET BDNOME = ?, BDSEXO = ?, BDDATANASCIMENTO = ? WHERE BDID = ?";
    String INSERT = "INSERT INTO TBPESSOA (BDID, BDNOME, BDSEXO, BDDATANASCIMENTO) VALUES (0, ?, ?, ?)";

    String ID = "bdID";
    String NOME = "bdNome";
    String SEXO = "bdSexo";
    String DATANASCIMENTO = "bdDataNascimento";

    SimpleDateFormat sdf = new SimpleDateFormat();

    public TbPessoa Salvar(TbPessoa pPessoa) {

        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            conexao.preparedStatement.setString(1, pPessoa.getBdNome());
            conexao.preparedStatement.setString(2, pPessoa.getBdSexo());
            conexao.preparedStatement.setString(3, sdf.format(pPessoa.getBdDataNascimento()));
            conexao.preparedStatement.execute();
            ResultSet rs = conexao.preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                pPessoa.setBdID(rs.getInt(1));
            }
            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de INSERT: " + e.toString());
        }

        return pPessoa;
    }

    public void Atualizar(TbPessoa pPessoa) {

        Repository conexao = Repository.getInstance();

        TbPessoa usuario = new TbPessoa();
        
        try {
            conexao.open();
            
            conexao.preparedStatement = conexao.conection.prepareStatement(UPDATE);
            conexao.preparedStatement.setString(1, pPessoa.getBdNome());
            conexao.preparedStatement.setString(2, pPessoa.getBdSexo());
            conexao.preparedStatement.setString(3, sdf.format(pPessoa.getBdDataNascimento()));
            conexao.preparedStatement.setInt(4, pPessoa.getBdID());
            conexao.preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL: UsuarioDAO.gravaNovaSenha - " + e.toString());
        } finally {
            conexao.close();
        }

    }

    public TbPessoa Selecionar(Integer pId, String pNome) {        
        TbPessoa pessoa = null;

        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery("SELECT BDID, BDNOME, BDSEXO, BDDATANASCIMENTO FROM TBPESSOA WHERE BDID = " + pId + " AND BDNOME = '" + pNome +"'");
            
                pessoa = new TbPessoa();

                pessoa.setBdID(conexao.resultSet.getInt("BDID"));
                pessoa.setBdNome(conexao.resultSet.getString("BDNOME"));
                pessoa.setBdSexo(conexao.resultSet.getString("BDSEXO"));
                pessoa.setBdDataNascimento(conexao.resultSet.getDate("BDDATANASCIMENTO"));
                
            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de SELECT ALL: " + e.toString());
        }
        return pessoa;
    }

}
