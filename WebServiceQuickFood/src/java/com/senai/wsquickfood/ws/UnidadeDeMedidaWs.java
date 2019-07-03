/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import com.senai.wsquickfood.dao.IngredienteDAO;
import com.senai.wsquickfood.dao.UnidadeDeMedidaDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Patricio
 */
@Path("medida")
public class UnidadeDeMedidaWs {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UnidadeDeMedidaWs
     */
    public UnidadeDeMedidaWs() {
    }

    /**
     * Retrieves representation of an instance of
     * com.senai.wsquickfood.ws.UnidadeDeMedidaWs
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getAll/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        UnidadeDeMedidaDAO unidadesmedida = new UnidadeDeMedidaDAO();
        String retorno = unidadesmedida.getAll();

        try {
            return Response.status(200).entity(retorno).header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).entity(e.toString()).header("Access-Control-Allow-Origin", "*").build();
        }

    }

    /**
     * PUT method for updating or creating an instance of UnidadeDeMedidaWs
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
