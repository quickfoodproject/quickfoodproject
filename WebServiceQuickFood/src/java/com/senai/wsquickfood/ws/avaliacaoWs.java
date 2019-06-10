/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author victo
 */
@Path("avaliacao")
public class avaliacaoWs {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of avaliacaoWs
     */
    public avaliacaoWs() {
    }

    /**
     * Retrieves representation of an instance of com.senai.wsquickfood.ws.avaliacaoWs
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("avaliacao/insererirComentario/{idUsuario}/{idReceita}/{descricao}")
    public Response insererirComentario(@PathParam("idUsuario") int idusuario, @PathParam("idReceita") int idReceita, @PathParam("descricao") String descricao) {
        try {            
            //AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
            
           // String retorno = avaliacaoDao.insereComentario(idusuario, idReceita, descricao);
            
            return null;
            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
    
    /**
     * PUT method for updating or creating an instance of avaliacaoWs
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
