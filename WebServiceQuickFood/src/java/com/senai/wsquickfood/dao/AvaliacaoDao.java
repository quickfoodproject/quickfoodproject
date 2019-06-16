package com.senai.wsquickfood.dao;

import com.senai.wsquickfood.model.TbAvaliacao;
import com.senai.wsquickfood.repository.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDao {

    private String INSERECOMENTARIO = "INSERT INTO TBAVALIACAO (BDFKUSUARIO, BDFKRECEITA, BDDESCRICAO)\n"
            + "VALUES (?, ?, ?)";

    private String EDITACOMENTARIO = "UPDATE TBAVALIACAO SET BDDESCRICAO = ? WHERE BDID = ?";

    private String APAGACOMENTARIO = "UPDATE TBAVALIACAO SET BDDESCRICAO = ? WHERE BDID = ?";

    private String BUSCACOMENTARIOSRECEITA = "SELECT BDID IDAVALIACAO,\n"
            + "BDDESCRICAO COMENTARIO\n"
            + "FROM TBAVALIACAO\n"
            + "WHERE BDFKRECEITA = ?";

    private String IDAVALIACAO = "IDAVALIACAO";
    private String COMENTARIO = "COMENTARIO";

    public String insereComentario(int idUsuario, int idReceita, String comentario) {

        Repository conexao = Repository.getInstance();
        TbAvaliacao avaliacao = new TbAvaliacao();

        try {

            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(INSERECOMENTARIO);
            conexao.preparedStatement.setInt(1, idUsuario);
            conexao.preparedStatement.setInt(2, idReceita);
            conexao.preparedStatement.setString(3, comentario);
            conexao.preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println("Erro ao salvar comentário: " + e.toString());
            return "Comentário não foi incluso. Erro: " + e.toString();
        } finally {
            conexao.close();
        }

        return "Comentário inserido com sucesso.";
    }

    public String editaComentario(int idAvaliacao, String comentario) {

        Repository conexao = Repository.getInstance();
        TbAvaliacao avaliacao = new TbAvaliacao();

        try {

            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(EDITACOMENTARIO);
            conexao.preparedStatement.setString(1, comentario);
            conexao.preparedStatement.setInt(2, idAvaliacao);
            conexao.preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println("Erro ao editar comentário: " + e.toString());
            return "Comentário não foi salvo. Erro: " + e.toString();
        } finally {
            conexao.close();
        }

        return "Comentário editado com sucesso.";
    }

    public String apagaComentario(int idAvaliacao) {

        Repository conexao = Repository.getInstance();
        TbAvaliacao avaliacao = new TbAvaliacao();

        try {

            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(APAGACOMENTARIO);
            conexao.preparedStatement.setString(1, "");
            conexao.preparedStatement.setInt(2, idAvaliacao);
            conexao.preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println("Erro ao excluir comentário: " + e.toString());
            return "Comentário não foi excluído. Erro: " + e.toString();
        } finally {
            conexao.close();
        }

        return "Comentário excluído com sucesso.";
    }

    public List<TbAvaliacao> buscaComentariosDaReceita(int idReceita) {

        Repository conexao = Repository.getInstance();
        TbAvaliacao avaliacao;
        List<TbAvaliacao> listaComentario = new ArrayList<>();

        try {

            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(BUSCACOMENTARIOSRECEITA);
            ps.setInt(1, idReceita);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (!rs.getString(COMENTARIO).isEmpty()) {

                    avaliacao = new TbAvaliacao();
                    avaliacao.setBdID(rs.getInt(IDAVALIACAO));
                    avaliacao.setBdDescricao(rs.getString(COMENTARIO));
                    listaComentario.add(avaliacao);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar comentários: " + e.toString());
        } finally {
            conexao.close();
        }

        return listaComentario;
    }

}
