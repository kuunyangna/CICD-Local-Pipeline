package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class WebApp {
    public static void main(String[] args) throws Exception {
        // Start Jetty server on port 8080
        Server server = new Server(8080);

        // Setup context to serve static files from resources
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setResourceBase(WebApp.class.getClassLoader().getResource("").toExternalForm());
        context.addServlet(DefaultServlet.class, "/");

        server.setHandler(context);

        System.out.println("Jetty server running at http://localhost:8080");
        server.start();
        server.join();
    }
}
