
package com.senai.wsquickfood.ws;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.senai.wsquickfood.ws.IngredienteWS.class);
        resources.add(com.senai.wsquickfood.ws.UsuarioWs.class);
    }
    
}
