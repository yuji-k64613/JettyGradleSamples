package com.sample;

import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

@javax.ws.rs.ApplicationPath("service")
//public class ApplicationConfig extends Application {
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig(){
        packages("com.sample");
    }
}
