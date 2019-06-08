/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import com.google.gson.Gson;
import com.senai.wsquickfood.dao.PessoaDAO;
import com.senai.wsquickfood.model.TbPessoa;
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
 * @author victo
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of com.senai.wsquickfood.ws.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_XML)
    public Response salvarIngrediente(@PathParam("name") String name) {
        //TODO return proper representation object
        Gson google = new Gson();
        
        TbPessoa tpessoa = new TbPessoa();
        PessoaDAO dao = new PessoaDAO();
        
        tpessoa = google.fromJson(name, TbPessoa.class);
        
        return Response.status(200).entity(dao.Salvar(tpessoa)).build();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
