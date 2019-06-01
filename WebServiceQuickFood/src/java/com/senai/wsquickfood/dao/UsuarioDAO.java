package com.senai.wsquickfood.dao;

import com.senai.wsquickfood.controller.Utils;
import com.senai.wsquickfood.model.TbPessoa;
import com.senai.wsquickfood.model.TbUsuario;
import com.senai.wsquickfood.repository.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    String SELECT_RECUPERA_SENHA = "SELECT BDID, BDEMAIL, BDLOGIN FROM TBUSUARIO WHERE BDLOGIN = ";
    String UPDATE_SENHA = "UPDATE TBUSUARIO SET BDSENHA = ? WHERE BDID = ?";
    String INSERT = "INSERT INTO TBUSUARIO (BDID, BDLOGIN, BDSENHA, BDEMAIL, BDUSUARIOADMINISTRADOR, BDFKPESSOA) VALUE(0, ?, ?, ?, ?, ?)";
    String UPDATE = "UPDATE TBUSUARIO SET BDLOGIN = ?, BDEMAIL = ?, BDUSUARIOADMINISTRADOR = ?, BDFKPESSOA = ? WHERE BDID = ?";
    String SELECT = "SELECT * FROM TBUSUARIO WHERE BDLOGIN = ";
    String SELECTALLLOGIN = "SELECT BDLOGIN FROM TBUSUARIO WHERE BDLOGIN = ?";

    String ID = "bdID";
    String EMAIL = "bdEmail";
    String LOGIN = "bdLogin";
    String SENHA = "bdSenha";
    String USUARIO_ADMINISTRADOR = "bdUsuarioAdministrador";
    String FKPESSOA = "bdFKPessoa";

    public TbUsuario Salvar(TbUsuario pUsuario, TbPessoa pPessoa) {
        if (!selecionarLogin(pUsuario.getBdLogin())) {
            try {
                TbPessoa pessoaAux = new TbPessoa();
                PessoaDAO pessoaDao = new PessoaDAO();
                pessoaAux = pessoaDao.Salvar(pPessoa);

                Repository conexao = Repository.getInstance();

                conexao.open();

                String SenhaCriptografada = Utils.criptografarSHA256(pUsuario.getBdSenha());

                conexao.preparedStatement = conexao.conection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
                conexao.preparedStatement.setString(1, pUsuario.getBdLogin());
                conexao.preparedStatement.setString(2, SenhaCriptografada);
                conexao.preparedStatement.setString(3, pUsuario.getBdEmail());
                conexao.preparedStatement.setBoolean(4, pUsuario.getBdUsuarioAdministrador());
                conexao.preparedStatement.setInt(5, pessoaAux.getBdID());
                conexao.preparedStatement.execute();
                conexao.close();

                System.out.println(pUsuario.getBdID());
            } catch (SQLException e) {
                System.err.println("Erro na execução SQL de INSERT: " + e.toString());
            }
        } else {
            System.err.println("Não foi possível cadastro por que esse login já existe!");
        }

        return pUsuario;

    }

    public TbUsuario recuperaUsuarioEmailDAO(String login) {

        Repository conexao = Repository.getInstance();
        TbUsuario usuario = new TbUsuario();

        try {
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery(SELECT_RECUPERA_SENHA + "'" + login + "'");

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

    public void atualizar(TbUsuario pUsuario, Integer pPessoaID) {

        Repository conexao = Repository.getInstance();
        String senhaCriptografada = Utils.criptografarSHA256(pUsuario.getBdSenha());

        try {
            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(UPDATE);
            conexao.preparedStatement.setString(1, pUsuario.getBdLogin());
            conexao.preparedStatement.setString(2, pUsuario.getBdEmail());
            conexao.preparedStatement.setBoolean(3, pUsuario.getBdUsuarioAdministrador());
            conexao.preparedStatement.setInt(4, pPessoaID);
            conexao.preparedStatement.setInt(5, pUsuario.getBdID());
            conexao.preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL: UsuarioDAO.gravaNovaSenha - " + e.toString());
        } finally {
            conexao.close();
        }

    }

    public boolean selecionarLogin(String pNome) {
        Repository conexao = Repository.getInstance();

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(SELECTALLLOGIN);
            ps.setString(1, pNome);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.err.println("Falha ao selecionar o usuário para login = " + e.toString());
        } finally {
            conexao.close();
        }

        return false;
    }

    public void gravaNovaSenha(int id, String senha) {

        Repository conexao = Repository.getInstance();
        String senhaCriptografada = Utils.criptografarSHA256(senha);

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
