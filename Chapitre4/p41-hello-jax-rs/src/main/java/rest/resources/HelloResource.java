package rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("greetings")
public class HelloResource {

//	1- Aucun paramètre
//	------------------
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String SayHello() {
//		return "Hello from JAX-RS";
//	}

//	2- @PathParam
//	-------------
	@GET
	@Path("{FirstName}/{LastName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String SayHelloPathParam(@PathParam(value = "FirstName") String prenom,
			@PathParam(value = "LastName") String nom) {
		return "Hello from JAX-RS " + prenom + " " + nom;
	}

//	3- @QueryParam
//	--------------
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String SayHelloQueryParam(@QueryParam(value = "FirstName")String prenom, @QueryParam(value="LastName")String nom) {
//		return "Hello from JAX-RS " + prenom + " " + nom;
//	}

//	4- @QueryParam et aucun paramètre combinés
//	------------------------------------------
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String SayHelloCombined(@QueryParam(value = "FirstName") String prenom,
			@QueryParam(value = "LastName") String nom) {
		if (prenom == null && nom == null) {
			return "Hello from JAX-RS";
		} else {
			return "Hello from JAX-RS " + prenom + " " + nom;
		}
	}

}
