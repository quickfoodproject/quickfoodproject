package com.senai.quickfood.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    public static String criptografarSHA256(String pConteudo) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = md.digest(pConteudo.getBytes("UTF-8"));

        for (byte b : encodedhash) {
            sb.append(String.format("%02X", 0xFF & b));
        }

        String senhaHex = sb.toString();

        return senhaHex;
    }
}
