package com.senai.quickfood.testes;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Teste {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

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
        try {
            System.out.println(criptografar("Senha"));
        } catch (Exception e) {
        }

    }

    private static String criptografar(String pSenha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = md.digest(pSenha.getBytes("UTF-8"));

        for (byte b : encodedhash) {
            sb.append(String.format("%02X", 0xFF & b));
        }

        String senhaHex = sb.toString();

        return senhaHex;
    }

}
