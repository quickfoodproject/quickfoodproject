/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import com.senai.wsquickfood.controller.Utils;
import com.senai.wsquickfood.dao.UsuarioDAO;
import com.senai.wsquickfood.model.Tbusuario;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("quickfood")
public class UsuarioWs {

    @Context
    private UriInfo context;

    public UsuarioWs() {
    }
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/recuperaSenha/{login}")
    public Response solicitarNovaSenha(@PathParam("login") String login) {
        UsuarioDAO dao = new UsuarioDAO();
        Tbusuario user = dao.recuperaUsuarioEmailDAO(login);
        
        String novaSenha;
        String titulo;
        String mensagem;        
        
        if(user.getBdID() != 0) {
            
            novaSenha = Utils.geradorDeSenhaRandomica();
            titulo = "Solicitação de Senha";            
            mensagem = "Sua nova senha foi enviada por email. Após o novo login com esta senha, recomendamos você fazer sua alteração.\n\n Nova senha: " + novaSenha;
            dao.gravaNovaSenha(user.getBdID(), novaSenha);
            Utils.enviaEmail(user.getBdEmail(), titulo, mensagem);
        
        }       
        
        try {            
            return Response.status(Response.Status.OK).entity(user).header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
}
