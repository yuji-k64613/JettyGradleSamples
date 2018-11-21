package com.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.sample.Hello;

/*
 * http://localhost:8080/sampleAppWeb/service/main/foo?id=1
 */
@Path("main")
public class Main {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("foo")
	public String foo(@QueryParam("id") int id) {
		String message = "hello, world:" + id;
        Hello hello = new Hello();
        message = hello.hello(message);
		return message;
	}
}
