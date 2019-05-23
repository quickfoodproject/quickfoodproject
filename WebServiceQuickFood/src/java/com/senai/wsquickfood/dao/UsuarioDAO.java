package com.senai.wsquickfood.dao;

import com.senai.wsquickfood.model.Tbusuario;
import com.senai.wsquickfood.repository.Repository;
import java.sql.SQLException;

public class UsuarioDAO {

    String SELECT_RECUPERA_SENHA = "SELECT BDID, BDEMAIL, BDLOGIN FROM TBUSUARIO WHERE BDLOGIN = ";
    String ID = "bdID";
    String EMAIL = "bdEmail";
    String LOGIN = "bdLogin";

    public Tbusuario retornaEmailLoginUsuario(String login) {
        
        Repository conexao = Repository.getInstace();
        Tbusuario usuario = null;

        try {            
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery(SELECT_RECUPERA_SENHA + login);

            while (conexao.resultSet.next()) {
                usuario.setBdID(conexao.resultSet.getInt(ID));
                usuario.setBdEmail(conexao.resultSet.getString(EMAIL));
                usuario.setBdLogin(conexao.resultSet.getString(LOGIN));
            }

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL: UsuarioDAO.recuperaSenha - " + e.toString());
        } finally {
            conexao.close();
        }

        return usuario;
    }
}
