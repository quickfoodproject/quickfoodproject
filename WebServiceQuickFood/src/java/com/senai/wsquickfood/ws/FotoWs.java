/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.senai.wsquickfood.dao.FotoDao;
import com.senai.wsquickfood.model.TbFoto;
import java.sql.Blob;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Greg
 */
@Path("foto")
public class FotoWs {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FotoWs
     */
    public FotoWs() {
    }

    /**
     * Retrieves representation of an instance of
     * com.senai.wsquickfood.ws.FotoWs
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarFoto(String pFoto) throws SQLException {
        try {
            FotoDao dao = new FotoDao();
            Gson google = new Gson();
            TbFoto foto = new TbFoto();

            foto = google.fromJson(pFoto, TbFoto.class);

            byte[] fotoByte = foto.getFotoJson().getBytes();
            Blob blob = new SerialBlob(fotoByte);
            
            foto.setBdFoto(blob);

            return Response.status(200).entity(dao.insereFoto(foto)).build();
        } catch (JsonSyntaxException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    /**
     * PUT method for updating or creating an instance of FotoWs
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
