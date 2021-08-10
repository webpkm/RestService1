package com.rest.services1;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest")
public class RestServices1 {
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		String responseJson = "{\"responseFrom\":\"Service1\",\"users\": [{\"name\":\"Harry Potter\",\"city\":\"London\"},{\"name\":\"Don Quixote\",\"city\":\"Madrid\"},{\"name\":\"Joan of Arc\",\"city\":\"Paris\"},{\"name\":\"Rosa Park\",\"city\":\"Alabama\"}]}";
		return Response.status(200).entity(responseJson).build();
	}
	
	@GET
	@Path("/user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("userId") String userId) {
		String responseJson = "{\"name\":\"Harry Potter\",\"city\":\"London\"}";
		return Response.status(200).entity(responseJson).build();
	}
	
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveUser(String requestJsonBody) {
		String responseJson = "{\"responseFrom\":\"Service1\",\"status\":200 ,\"message\":\"User Saved successfully!\", \"requestBody\":" + requestJsonBody + "}";
		return Response.status(200).entity(responseJson).build();
	}
	
	@DELETE
	@Path("/user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("userId") String userId) {
		String responseJson = "{\"status\":200 ,\"message\":\"User deleted successfully!\"}";
		return Response.status(200).entity(responseJson).build();
	}
}
