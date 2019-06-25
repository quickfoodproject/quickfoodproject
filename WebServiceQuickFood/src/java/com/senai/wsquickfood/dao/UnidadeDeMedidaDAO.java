package com.senai.wsquickfood.dao;

import com.google.gson.Gson;
import com.senai.wsquickfood.controller.Utils;
import com.senai.wsquickfood.model.TbIngrediente;
import com.senai.wsquickfood.model.TbReceita;
import com.senai.wsquickfood.model.TbUnidadeMedida;
import com.senai.wsquickfood.repository.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnidadeDeMedidaDAO {

    String SELECTALL = "SELECT BDID IDUNIDADEMEDIDA,\n"
            + "BDUNIDADE UNIDADE\n"
            + "FROM TBUNIDADEMEDIDA";

    public String getAll() {

        Repository conexao = Repository.getInstance();

        Gson google = new Gson();

        TbUnidadeMedida unidadeMedida = new TbUnidadeMedida();
        String json = "";

        try {
            conexao.open();

            PreparedStatement ps = conexao.conection.prepareStatement(SELECTALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                unidadeMedida.setBdID(rs.getInt("IDUNIDADEMEDIDA"));
                unidadeMedida.setBdUnidade(rs.getString("UNIDADE"));

                json = json + google.toJson(unidadeMedida) + ";";
            }

            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de SELECT ALL: " + e.toString());
        }
        return json;
    }

}
