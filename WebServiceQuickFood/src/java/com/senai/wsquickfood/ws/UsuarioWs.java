/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

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

/**
 * REST Web Service
 *
 * @author Greg
 */
@Path("quickfood")
public class UsuarioWs {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Ws
     */
    public UsuarioWs() {
    }

    /**
     * Retrieves representation of an instance of com.senai.wsquickfood.ws.Ws
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/recuperaSenha/{login}")
    public Response recuperaSenha(@PathParam("login") String login) {
        UsuarioDAO dao = new UsuarioDAO();
        Tbusuario user = dao.recuperaSenhaDAO(login);
        try {
            return Response.status(Response.Status.OK).entity(user).header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    /**
     * PUT method for updating or creating an instance of Ws
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
