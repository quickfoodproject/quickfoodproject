package com.senai.wsquickfood.controller;

import com.senai.wsquickfood.model.TbUsuario;
import java.util.List;


public class Conveter {
    
    public static TbUsuario converUsuario(List<String> pListaUsuario) {
        TbUsuario usuario = new TbUsuario();
        
        usuario.setBdLogin(pListaUsuario.get(0));
        usuario.setBdSenha(pListaUsuario.get(1));
        usuario.setBdUsuarioAdministrador(Utils.retornaUsuarioAdm(pListaUsuario.get(2)));
        usuario.setBdEmail(pListaUsuario.get(3));
        
        return usuario;
    }
}
