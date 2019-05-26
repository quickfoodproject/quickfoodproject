package com.senai.wsquickfood.dao;

import com.senai.wsquickfood.controller.Utils;
import com.senai.wsquickfood.model.TbUsuario;
import com.senai.wsquickfood.repository.Repository;
import java.sql.SQLException;

public class UsuarioDAO {

    String SELECT_RECUPERA_SENHA = "SELECT BDID, BDEMAIL, BDLOGIN FROM TBUSUARIO WHERE BDLOGIN = ";
    String UPDATE_SENHA = "UPDATE TBUSUARIO SET BDSENHA = ? WHERE BDID = ?";
    String ID = "bdID";
    String EMAIL = "bdEmail";
    String LOGIN = "bdLogin";
    String SENHA = "bdSenha";

    public TbUsuario recuperaUsuarioEmailDAO(String login) {

        Repository conexao = Repository.getInstance();
        TbUsuario usuario = new TbUsuario();

        try {
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery(SELECT_RECUPERA_SENHA + "'" + login + "'");
            System.out.println(SELECT_RECUPERA_SENHA + "'" + login + "'");

            while (conexao.resultSet.next()) {
                usuario.setBdID(conexao.resultSet.getInt(ID));
                usuario.setBdEmail(conexao.resultSet.getString(EMAIL));
                usuario.setBdLogin(conexao.resultSet.getString(LOGIN));
            }

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL: UsuarioDAO.recuperaSenhaDAO - " + e.toString());
        } finally {
            conexao.close();
        }

        return usuario;
    }

    public void gravaNovaSenha(int id, String senha) {

        Repository conexao = Repository.getInstance();
        String senhaCriptografada = Utils.criptografarSHA256(senha);
        TbUsuario usuario = new TbUsuario();

        try {
            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(UPDATE_SENHA);
            conexao.preparedStatement.setString(1, senhaCriptografada);
            conexao.preparedStatement.setInt(2, id);
            conexao.preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL: UsuarioDAO.gravaNovaSenha - " + e.toString());
        } finally {
            conexao.close();
        }

    }

    public TbUsuario validaLoginDAO(String login, String senha) {

        Repository conexao = Repository.getInstance();
        String senhaCriptografada = Utils.criptografarSHA256(senha);
        TbUsuario usuario = new TbUsuario();

        try {
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery("SELECT * FROM TBUSUARIO WHERE LOGIN = '" + login + "' AND SENHA = '" + senhaCriptografada + "'");

            while (conexao.resultSet.next()) {
                usuario.setBdID(conexao.resultSet.getInt(ID));
                usuario.setBdEmail(conexao.resultSet.getString(EMAIL));
                usuario.setBdLogin(conexao.resultSet.getString(LOGIN));
            }

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL: UsuarioDAO.validaLoginDAO - " + e.toString());
        } finally {
            conexao.close();
        }

        return usuario;
    }
}
