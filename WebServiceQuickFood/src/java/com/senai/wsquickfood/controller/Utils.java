package com.senai.wsquickfood.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Utils {

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
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(emailRemetente, senhaRemetente));
        email.setSSLOnConnect(true);

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
}
