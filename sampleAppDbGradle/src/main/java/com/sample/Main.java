package com.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ejb.EJB;

import javax.enterprise.context.RequestScoped;
import javax.annotation.ManagedBean;
import javax.inject.Inject;

import javax.servlet.annotation.WebServlet;

/*
 * http://localhost:8080/sampleAppDbWeb/service/main/foo?id=1
 */
@Path("main")
//@RequestScoped
@ManagedBean
public class Main {
    @EJB
    private PersonDB db;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("foo")
	public String foo(@QueryParam("id") int id) {
        Person p = db.find(id);
        String message = "hello: " + id;
		return message;
	}
}
