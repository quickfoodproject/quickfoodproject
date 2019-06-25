package com.senai.wsquickfood.testes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senai.wsquickfood.dao.AvaliacaoDao;
import com.senai.wsquickfood.dao.IngredienteDAO;
import com.senai.wsquickfood.dao.PessoaDAO;
import com.senai.wsquickfood.dao.ReceitaDao;
import com.senai.wsquickfood.dao.UsuarioDAO;
import com.senai.wsquickfood.model.TbFoto;
import com.senai.wsquickfood.model.TbIngrediente;
import com.senai.wsquickfood.model.TbPessoa;
import com.senai.wsquickfood.model.TbReceita;
import com.senai.wsquickfood.model.TbUsuario;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teste {

    public static void main(String[] args) throws SQLException {
//        String jsonReceita = "{	\"bdnome\": \"gregzera \",	\"bdDescricao \": \"123\",	\"bdFkfoto\": {	\"bdId\": \"1\"	},	\"bdDKUsuario\": 	{	\"bdId\": \"1\"	}	}";
//        String jsonlistaingrediente = "[{	\"bdID\": \"2\",	\"bdQuantidade\": \"100\",	\"bdUnidadeMedida\": \"1\"}, {	\"bdID\": \"2\",	\"bdQuantidade\": \"100\",	\"bdUnidadeMedida\": \"1\"}]";
//        Gson google = new Gson();
//        TbReceita receita = new TbReceita();
//        TypeToken token = new TypeToken<List<TbIngrediente>>() {
//        };
//        
//        ReceitaDao dao = new ReceitaDao();
////        TbReceita receita = new TbReceita(0, "Teste patricio", "Victor teste");
////        TbFoto foto = new TbFoto(1);
////        TbUsuario usuario = new TbUsuario(2);
////        
////        receita.setBdDKUsuario(usuario);
////        receita.setBdFkFoto(foto);
////        
//        TbIngrediente ingrediente = new TbIngrediente();        
////        ingrediente.setDbID(1);
////        ingrediente.setQuantidade(10000);
////        ingrediente.setUnidadeMedida(2);
////      
//
//        List<TbIngrediente> listaIngrediente = google.fromJson(jsonlistaingrediente, token.getType());
//        receita = google.fromJson(jsonReceita, TbReceita.class);
////        listaIngrediente.add(ingrediente);
////        listaIngrediente.add(ingrediente);
////        listaIngrediente.add(ingrediente);
////        
//        
        String jsonusuario = "{	\"bdLogin\": \"gregzera\",	\"bdSenha\": \"123\",	\"bdEmail\": \"gha.alves@gmai.com\",	\"bdUsuarioAdministrador\": null    }";
        String jsonPessoa = "{	\"bdNome\": \"gregoryalves\",	\"bdSexo\": \"m\",	\"bdDataNascimento\": null      }";
        
        
        Gson google = new Gson();
                
        TbUsuario pUsuario = new TbUsuario();
        TbPessoa pPessoa = new TbPessoa();
        
        pUsuario = google.fromJson(jsonusuario, TbUsuario.class);
        pPessoa = google.fromJson(jsonPessoa, TbPessoa.class);
        UsuarioDAO dao = new UsuarioDAO();        
        
        System.out.println(dao.Salvar(pUsuario, pPessoa));

    }
}
