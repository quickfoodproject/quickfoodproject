/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.wsquickfood.ws;

import java.util.Set;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@WebServlet(loadOnStartup=1)
@ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.senai.wsquickfood.ws.IngredienteWS.class);
        resources.add(com.senai.wsquickfood.ws.ReceitaWs.class);
        resources.add(com.senai.wsquickfood.ws.UsuarioWs.class);
    }
    
}
