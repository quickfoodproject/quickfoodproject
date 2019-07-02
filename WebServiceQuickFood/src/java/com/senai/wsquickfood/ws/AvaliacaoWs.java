/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import com.senai.wsquickfood.dao.AvaliacaoDao;
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
@Path("avaliacao")
public class AvaliacaoWs {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioTesteWS
     */
    public AvaliacaoWs() {
    }

    /**
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("Avaliacao/insererirComentario/{idUsuario}/{idReceita}/{descricao}")
    public Response insererirComentario(@PathParam("idUsuario") int idusuario, @PathParam("idReceita") int idReceita, @PathParam("descricao") String descricao) {
        try {
            AvaliacaoDao avaliacaoDao = new AvaliacaoDao();

            String retorno = avaliacaoDao.insereComentario(idusuario, idReceita, descricao);

            return Response.status(Response.Status.OK).entity(retorno).header("Access-Control-Allow-Origin", "*").build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("Avaliacao/editarComentario/{idAvaliacao}/{descricao}")
    public Response editarComentario(@PathParam("idAvaliacao") int idAvaliacao, @PathParam("descricao") String descricao) {
        try {
            AvaliacaoDao avaliacaoDao = new AvaliacaoDao();

            String retorno = avaliacaoDao.editaComentario(idAvaliacao, descricao);

            return Response.status(Response.Status.OK).entity(retorno).header("Access-Control-Allow-Origin", "*").build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").entity(e).build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("Avaliacao/excluirComentario/{idAvaliacao}")
    public Response excluirComentario(@PathParam("idAvaliacao") int idAvaliacao) {
        try {
            AvaliacaoDao avaliacaoDao = new AvaliacaoDao();

            String retorno = avaliacaoDao.apagaComentario(idAvaliacao);

            return Response.status(Response.Status.OK).entity(retorno).header("Access-Control-Allow-Origin", "*").build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").entity(e).build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("Avaliacao/darLikeDeslike/{idUsuario}/{idReceita}")
    public Response darLikeDeslike(@PathParam("idUsuario") int idUsuario, @PathParam("idReceita") int idReceita) {
        try {
            AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
            avaliacaoDao.insereLikeDeslikeUsuario(idUsuario, idReceita);

            return Response.status(Response.Status.OK).entity("LikeDeslike com sucesso.").header("Access-Control-Allow-Origin", "*").build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).entity("Erro ao dar LikeDeslike.").header("Access-Control-Allow-Origin", "*").build();
        }
    }

    /**
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

}
