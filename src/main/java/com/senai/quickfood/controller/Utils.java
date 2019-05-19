package com.senai.quickfood.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
                System.err.println("Não foi possível criptografar o conteúdo: UnsupportedEncodingException: " + e.toString());
            }

            senhaHex = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Não foi possível criptografar o conteúdo: NoSuchAlgorithmException: " + e.toString());
        }

        return senhaHex;
    }
}
