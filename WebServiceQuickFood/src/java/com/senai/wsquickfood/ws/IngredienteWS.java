/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import com.senai.wsquickfood.controller.Utils;
import com.senai.wsquickfood.dao.IngredienteDAO;
import com.senai.wsquickfood.model.TbIngrediente;
import java.util.List;


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
import org.jboss.logging.Param;

@Path("quickfood")
public class IngredienteWS {

    @Context
    private UriInfo context;

    public IngredienteWS() {
    }
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Ingrediente/listarIngrediente/")
    public Response listarAllIngrediente() {
        IngredienteDAO dao = new IngredienteDAO();
        List<TbIngrediente> ingredientes = dao.getAll();
        
        try {            
            return Response.status(Response.Status.OK).entity(ingredientes).header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Ingrediente/listarIngrediente/{pNome}")
    public Response listarAllIngredienteNome(@PathParam("pNome") String nome) {
        IngredienteDAO dao = new IngredienteDAO();
        List<TbIngrediente> ingredientes = dao.getAllNome(nome);
        
        try {            
            return Response.status(Response.Status.OK).entity(ingredientes).header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Ingrediente/listarIngrediente/{pId}")
    public Response listarAllIngredienteID(@PathParam("pId") int id) {
        IngredienteDAO dao = new IngredienteDAO();
        TbIngrediente ingrediente = dao.getById(id);
        
        try {            
            return Response.status(Response.Status.OK).entity(ingrediente).header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
}
