package com.senai.wsquickfood.testes;

import com.google.gson.Gson;
import com.senai.wsquickfood.dao.AvaliacaoDao;
import com.senai.wsquickfood.dao.IngredienteDAO;
import com.senai.wsquickfood.dao.PessoaDAO;
import com.senai.wsquickfood.dao.ReceitaDao;
import com.senai.wsquickfood.dao.UsuarioDAO;
import com.senai.wsquickfood.model.TbIngrediente;
import com.senai.wsquickfood.model.TbPessoa;
import com.senai.wsquickfood.model.TbUsuario;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teste {

    public static void main(String[] args) throws SQLException {

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
//        TbIngrediente ingrediente = new TbIngrediente();
//        IngredienteDAO ingredienteDAO = new IngredienteDAO();
//        List<TbIngrediente> ingredientes = new ArrayList();
//        
//        ingrediente.setBdNome("Algas");
//        
//        ingredienteDAO.save(ingrediente);
//        ingredientes.addAll(ingredienteDAO.getAllNome(pNome));
//        
//        for (TbIngrediente ingrediente1 : ingredientes) {
//            System.out.println(ingrediente1.toString());
//            
//        }
//      SimpleDateFormat sdf = new SimpleDateFormat();
//        TbPessoa p = new TbPessoa();
//        
//        p.setBdSexo("Masculino");
//        p.setBdDataNascimento(new Date());
//        
//        TbUsuario usuario = new TbUsuario();        
//        usuario.setBdEmail("victorcordova014@gmail.com");
//        UsuarioDAO uDAO = new UsuarioDAO();
//        uDAO.atualizar(usuario, p.getBdID());
//        usuario.setBdLogin("victor");
//        usuario.setBdSenha("senha");
//        usuario.setBdEmail("victor@");
//        usuario.setBdUsuarioAdministrador(true);
//        
//        uDAO.Salvar(usuario, p);
//        
//        System.out.println(usuario.getBdID());
//        TbPessoa pessoa = new TbPessoa();
//        PessoaDAO pessoaDAO = new PessoaDAO();
//        List<TbPessoa> pessoas = new ArrayList();
//        
//        pessoas.addAll(pessoaDAO.Selecionar(602, "Victor"));
//        
//        for (TbPessoa pessoa1 : pessoas) {
//            System.out.println(pessoa1.toString());
//            
//        }
//        Gson google = new Gson();
//        
//        TbUsuario tusuario = new TbUsuario();
//        UsuarioDAO udao = new UsuarioDAO();             
//        TbPessoa tpessoa = new TbPessoa();
//        PessoaDAO pdao = new PessoaDAO();
//        
//        tusuario = google.fromJson("{	\"bdLogin\": \"123qwe12345\",	\"bdSenha\": \"123qwe123\",	\"bdEmail\": \"123qwe@gmai.com\",	\"bdUsuarioAdministrador\": null    }", TbUsuario.class);
//        tpessoa = google.fromJson("{	\"bdNome\": \"Victor cordova\",	\"bdSexo\": \"123qwe\",	\"bdDataNascimento\": null      }", TbPessoa.class);
//        
//        udao.Salvar(tusuario, tpessoa);
//        Gson google = new Gson();
//        
//        TbIngrediente tIngrediente = new TbIngrediente();
//        IngredienteDAO iDao = new IngredienteDAO();               
//        
//        //tIngrediente = google.fromJson("{	\"bdNome\": \"teste ingrediente\"      }", TbIngrediente.class);
//        
//        System.out.println(iDao.getAll());
//          ReceitaDao dao = new ReceitaDao();
//          
//          System.out.println(dao.selecionarReceitaById(1));

            ReceitaDao reDao = new ReceitaDao();
            List<String> lista = new ArrayList<>();
            
            lista.add("Açúcar");
            
            System.out.println(reDao.selecionarByIngrediente(lista));
    }
}
