/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import com.google.gson.Gson;
import com.senai.wsquickfood.dao.IngredienteDAO;
import com.senai.wsquickfood.dao.PessoaDAO;
import com.senai.wsquickfood.model.TbIngrediente;
import com.senai.wsquickfood.model.TbPessoa;
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
@Path("ingrediente")
public class IngredienteWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of IngredienteWS
     */
    public IngredienteWS() {
    }

    /**
     * Retrieves representation of an instance of com.senai.wsquickfood.ws.IngredienteWS
     * @return an instance of java.lang.String
     */
    @GET
    @Path("Ingrediente/SalvarIngrediente/{objIngrediente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarIngrediente(@PathParam("objIngrediente") String objIngrediente) {
        //TODO return proper representation object
        Gson google = new Gson();
        
        TbIngrediente tIngrediente = new TbIngrediente();
        IngredienteDAO iDao = new IngredienteDAO();               
        
        tIngrediente = google.fromJson(objIngrediente, TbIngrediente.class);
        
        return Response.status(200).entity(iDao.salvar(tIngrediente)).build();
    }
    
    @GET
    @Path("Ingrediente/getAll/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        //TODO return proper representation object
        IngredienteDAO iDao = new IngredienteDAO();               
                
        return Response.status(200).entity(iDao.getAll()).build();
    }

    /**
     * PUT method for updating or creating an instance of IngredienteWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putXml(String content) {
    }
}
