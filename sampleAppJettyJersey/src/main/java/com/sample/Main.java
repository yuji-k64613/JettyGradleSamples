package com.sample;

import java.net.URL;
import java.security.ProtectionDomain;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;

//
// http://localhost:8080/hello
//
public class Main {
    private static String version = "123456789";

    public static void main(String[] args) throws Exception {
        Main ap = new Main();
        ap.boot();
    }

    private void boot() throws Exception {
        ServletContextHandler context = new ServletContextHandler(
            ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
            org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Jerseyに対してWebAPIエンドポイントにするクラスを渡す
        jerseyServlet.setInitParameter(
            "jersey.config.server.provider.classnames",
            Rest.class.getCanonicalName());

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
