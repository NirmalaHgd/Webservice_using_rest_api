package org.learning.showroom.resources;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class Demo {
	
	@Context
	private UriInfo uriInfo;
	
	@Context
	private ServletContext servletContext;
	
	@GET
	public String usefulAnnotation() {
	//public String usefulAnnotation(@HeaderParam("HeaderValue") String headerAttrib, @CookieParam("xsrf") String xsrf) {
		return "Hello Everyone!";
		//return "Hello!!!! Header : " + headerAttrib + " Cookie : " + xsrf;
	}
	
	
	@GET
	@Path("demo")
	public String contextDemo(//@Context HttpHeaders header
			@HeaderParam("HeaderValue") String headerAttrib) throws Exception {
		Response response = Response.status(404).entity("Header value not found").build();
		if(headerAttrib == null) {
			throw new WebApplicationException(response);
			//throw new NotFoundException();
		}
		return  "Absolute path : " + uriInfo.getAbsolutePath().toString() +  "\n Header : " + headerAttrib;
		//header.getRequestHeaders().keySet().toString();
	}
}
