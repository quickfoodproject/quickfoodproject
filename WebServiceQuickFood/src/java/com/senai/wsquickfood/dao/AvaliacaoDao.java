package com.senai.wsquickfood.dao;

import com.senai.wsquickfood.model.TbAvaliacao;
import com.senai.wsquickfood.repository.Repository;
import java.sql.SQLException;

public class AvaliacaoDao {

    String INSERECOMENTARIO = "INSERT INTO TBAVALIACAO (BDFKUSUARIO, BDFKRECEITA, BDDESCRICAO)\n"
            + "VALUES (?, ?, ?)";

    String EDITACOMENTARIO = "UPDATE TBAVALIACAO SET BDDESCRICAO = ? WHERE BDID = ?";

    String EXCUICOMENTARIO = "DELETE FROM TBAVALIACAO WHERE BDID = ?";

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

    public String excluiComentario(int idAvaliacao) {

        Repository conexao = Repository.getInstance();
        TbAvaliacao avaliacao = new TbAvaliacao();

        try {

            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(EXCUICOMENTARIO);
            conexao.preparedStatement.setInt(1, idAvaliacao);
            conexao.preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println("Erro ao excluir comentário: " + e.toString());
            return "Comentário não foi excluído. Erro: " + e.toString();
        } finally {
            conexao.close();
        }

        return "Comentário excluído com sucesso.";
    }

}
