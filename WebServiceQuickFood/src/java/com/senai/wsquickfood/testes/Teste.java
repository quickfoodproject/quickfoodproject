package com.senai.wsquickfood.testes;

import com.senai.wsquickfood.dao.IngredienteDAO;
import com.senai.wsquickfood.model.TbIngrediente;
import java.util.ArrayList;

import java.util.List;

import com.senai.wsquickfood.controller.Utils;
import com.senai.wsquickfood.dao.UsuarioDAO;
import com.senai.wsquickfood.model.TbUsuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Teste {

    public static void main(String[] args) {

//        UsuarioTeste u = new UsuarioTeste();
//        UsuarioTesteDao userDao = new UsuarioTesteDao();
//        List<UsuarioTeste> usuarios = new ArrayList();
//
//        u.setId(52);
//        u.setNome("Teste");
//        u.setTelefone("1151");
//        u.setEmail("teste@teste.com");
//        u.setRepostaSeguranca("asdasds");
//        u.setIePermissao("asdasds");
//        //u.setId(32);
//        u.setLogin("TestePadrao");
//        u.setPassword("13456789100");
//        
//        userDao.save(u);        
        //userDao.delete(u);
        //userDao.update(u);
//        usuarios = userDao.getAll();
//        
//        for (Usuario usuario : usuarios) {
//            System.out.println(usuario.toString());
//            System.out.println("");
//        }
//        System.out.println(userDao.getById(42).toString());
//       if(userDao.logar("gregoryalves2", "abc123") != null){
//           System.out.println("Usuário logado com sucesso.");
//       } else {
//           System.out.println("Usuário ou senha inválidos!");
//       }
//        try {
//            System.out.println(Utils.criptografarSHA256("Senha"));
//        } catch (Exception e) {
//        }
//    Tbusuario user = new Tbusuario();
//    
//    UsuarioDAO usuario = new UsuarioDAO();
//    
//    user = usuario.recuperaSenhaDAO("Leonardo");
//    
//        System.out.println(user.toString());
//    
//Utils.enviaEmail("gregoryalves@hotmail.com", "Teste", "Teste Java");
        TbIngrediente ingrediente = new TbIngrediente();
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        List<TbIngrediente> ingredientes = new ArrayList();
        
        String pNome = "";
        
        ingredientes.addAll(ingredienteDAO.getAllNome(pNome));
        
        for (TbIngrediente ingrediente1 : ingredientes) {
            System.out.println(ingrediente1.toString());
            
        }

    }
}
