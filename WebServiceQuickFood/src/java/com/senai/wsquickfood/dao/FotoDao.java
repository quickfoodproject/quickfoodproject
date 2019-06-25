package com.senai.wsquickfood.dao;

import com.google.gson.Gson;
import com.senai.wsquickfood.model.TbFoto;
import com.senai.wsquickfood.repository.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FotoDao {

    private String INSEREFOTO = "INSERT INTO TBFOTO (BDID, BDFOTO) VALUES (0, ?)";

    public String insereFoto(TbFoto foto) {

        Gson google = new Gson();
        int idFoto = 0;
        Repository conexao = Repository.getInstance();

        try {

            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(INSEREFOTO, PreparedStatement.RETURN_GENERATED_KEYS);
            conexao.preparedStatement.setBlob(1, foto.getBdFoto());
            conexao.preparedStatement.execute();
            ResultSet rs = conexao.preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                idFoto = rs.getInt(1);
            }

        } catch (SQLException e) {
            return "Erro ao inserir a foto: " + e.getMessage();
        } finally {
            conexao.close();
        }

        return google.toJson(idFoto);

    }

}
