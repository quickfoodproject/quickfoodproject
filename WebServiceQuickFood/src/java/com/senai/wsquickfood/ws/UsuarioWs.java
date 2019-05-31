/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import com.senai.wsquickfood.controller.Utils;
import com.senai.wsquickfood.dao.UsuarioDAO;
import com.senai.wsquickfood.model.TbUsuario;
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

/**
 * REST Web Service
 *
 * @author Aluno
 */
@Path("quickfood")
public class UsuarioWs {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioTesteWS
     */
    public UsuarioWs() {
    }

    /**
     * Retrieves representation of an instance of
     * com.senai.wsquickfood.ws.UsuarioTesteWS
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/recuperaSenha/{login}")
    public Response solicitarNovaSenha(@PathParam("login") String login) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            TbUsuario user = dao.recuperaUsuarioEmailDAO(login);

            String novaSenha;
            String titulo;
            String mensagem;

            if (user != null) {

                novaSenha = Utils.geradorDeSenhaRandomica();
                titulo = "Solicitação de Senha";
                mensagem = "Você solicitou uma nova senha de acesso. Após o novo login com esta senha, recomendamos fazer sua alteração.\n\nNova senha: " + novaSenha
                        + "\n\n\nAtenciosamente,\nEquipe QuickFood";
                dao.gravaNovaSenha(user.getBdID(), novaSenha);
                Utils.enviaEmail(user.getBdEmail(), titulo, mensagem);

                return Response.status(Response.Status.OK).entity(user).header("Access-Control-Allow-Origin", "*").build();

            } else {
                throw new Exception("Usuário ou senha inválido(s)");
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    /**
     * PUT method for updating or creating an instance of UsuarioTesteWS
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/logar/{login}/{senha}")
    public Response logar(@PathParam("login") String login, @PathParam("senha") String senha) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            TbUsuario user = dao.validaLoginDAO(login, senha);

            if (user != null) {
                return Response.status(Response.Status.OK).entity(user).build();
            } else {
                throw new Exception("Usuário ou senha inválido(s)");
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/validasenha/{idusuario}/{senha}")
    public Response validaSenha(@PathParam("idusuario") int idusuario, @PathParam("senha") String senha) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            TbUsuario user = dao.validaSenhaDAO(idusuario, senha);

            if (user != null) {
                return Response.status(Response.Status.OK).entity(user).build();
            } else {
                throw new Exception("Senha incorreta.");
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/gravanovasenha/{idusuario}/{senha}")
    public Response gravaNovaSenha(@PathParam("idusuario") int idusuario, @PathParam("senha") String senha) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            String senhaAlterada = "Senha alterada com sucesso.";
            dao.gravaNovaSenha(idusuario, senha);
            
            return Response.status(Response.Status.OK).entity(senhaAlterada).build();     
            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

}
