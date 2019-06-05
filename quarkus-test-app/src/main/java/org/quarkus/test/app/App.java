package org.quarkus.test.app;

import java.lang.reflect.Method;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.jandex.Main;
import org.quarkus.test.entities.ImportedBean;
import org.quarkus.test.entities.ImportedEntity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Produces(MediaType.TEXT_PLAIN)
@Path("/")
public class App {
    @Inject
    DirectBean db;
//    @Inject
//    ImportedBean ib;
    @Transactional
    @GET
    public String hello() {
//        System.err.println("IMPORTED ENTITY CL: "+ImportedEntity.class.getClassLoader());
        System.err.println("PANACHE ENTITY");
        for (Method method : PanacheEntity.class.getDeclaredMethods()) {
            System.err.println(method);
        }
        System.err.println("IMPORTED ENTITY");
        for (Method method : ImportedEntity.class.getDeclaredMethods()) {
            System.err.println(method);
        }
        System.err.println("DIRECT ENTITY");
        for (Method method : DirectEntity.class.getDeclaredMethods()) {
            System.err.println(method);
        }
        System.err.println("ImportedEntity count: "+ImportedEntity.count());
        System.err.println("DirectEntity count: "+DirectEntity.count());
        
        DirectEntity entity = new DirectEntity();
        entity.name = "stef";
        entity.name2 = "stef";
        entity.name3 = "stef";
        entity.persist();
        
        return "hello";
    }
    
    public static void main(String[] args) {
        AFTER_BLOCK: {
            System.err.println("Goto after");
            if(1 == 1)
                break AFTER_BLOCK;
            System.err.println("Not here");
        }
        System.err.println("Goto after success");
        
        System.err.println("Goto inside");
        switch(2) {
        case 1:
            System.err.println("Not here");
        case 2:
            System.err.println("Goto inside success");
        }
    }
}
