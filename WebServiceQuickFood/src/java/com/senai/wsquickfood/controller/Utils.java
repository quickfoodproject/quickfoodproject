package com.senai.wsquickfood.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Utils {

    public static String retiraQuebraDeLinha(String string) {

        if (string == null) {
            return string;

        }
        
        return string.replaceAll("\n", "");
    }

    public static boolean retornaUsuarioAdm(String prString) {
        boolean retorno = false;

        if (prString.equals("0")) {
            retorno = true;
        }

        return retorno;

    }

    public static String criptografarSHA256(String pConteudo) {
        String senhaHex = "";

        try {
            StringBuilder sb = new StringBuilder();

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            try {
                byte[] encodedhash = md.digest(pConteudo.getBytes("UTF-8"));

                for (byte b : encodedhash) {
                    sb.append(String.format("%02X", 0xFF & b));
                }

            } catch (UnsupportedEncodingException e) {
                System.err.println("Não foi possível criptografar o conteúdo: Utils.criptografarSHA256  - " + e.toString());
            }

            senhaHex = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Não foi possível criptografar o conteúdo: Utils.criptografarSHA256 - " + e.toString());
        }

        return senhaHex;
    }

    public static String enviaEmail(String destinatario, String titulo, String mensagem) {

        String emailRemetente = "senai.quickfood@gmail.com";
        String senhaRemetente = "@Senai2019";

        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(emailRemetente, senhaRemetente));
        email.setTLS(true);

        try {
            email.setFrom(emailRemetente);
            email.setSubject(titulo);
            email.setMsg(mensagem);
            email.addTo(destinatario);
            email.send();

        } catch (EmailException e) {
            System.err.println("Falha ao enviar email: Utils.enviaEmail - " + e.toString());
        }

        return destinatario;
    }

    public static String geradorDeSenhaRandomica() {

        UUID randomico = UUID.randomUUID();
        String senha = randomico.toString().substring(0, 8);

        return senha;
    }

    public static boolean verificaEmail(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    public static String listaParaString(List<String> listaString, char caracter) {
        String retorno = "";

        for (String string : listaString) {
            retorno = retorno + string + caracter;
        }
        retorno = retorno.substring(0, retorno.length() - 1);

        return retorno;
    }
}
