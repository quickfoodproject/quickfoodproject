/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import com.senai.wsquickfood.dao.ReceitaDao;
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
 * @author victo
 */
@Path("receita")
public class ReceitaWs {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReceitaWs
     */
    public ReceitaWs() {
    }

    /**
     * Retrieves representation of an instance of
     * com.senai.wsquickfood.ws.ReceitaWs
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("receita/selecionarById/{idReceita}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selecionarById(@PathParam("idReceita") Integer idReceita) {
        ReceitaDao receitaDao = new ReceitaDao();
        
        try {

            return Response.status(200).entity(receitaDao.selecionarReceitaById(idReceita)).build();
        
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        } 
        
        
    }

    /**
     * PUT method for updating or creating an instance of ReceitaWs
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
