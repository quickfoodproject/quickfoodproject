package com.senai.wsquickfood.dao;

import com.senai.wsquickfood.model.TbAvaliacao;
import com.senai.wsquickfood.repository.Repository;
import java.sql.SQLException;

public class AvaliacaoDao {

    String INSERECOMENTARIO = "INSERT INTO TBAVALIACAO (BDFKUSUARIO, BDFKRECEITA, BDDESCRICAO)\n"
            + "VALUES (?, ?, ?)";

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
}
