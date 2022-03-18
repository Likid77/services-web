package rest.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import rest.entities.Employe;
import rest.filters.Secured;

@Path("/employes")
//@Secured Ici toutes les méthodes sont sécurisées
public class GestionEmploye {

	public static List<Employe> employes = new ArrayList<Employe>();

	// @[Type de méthode] + @[Représentation des données à envoyer = configuration
	// de la requête]
	@Secured // Ici seule la méthode POST est sécurisée
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String ajouterEmploye(Employe employe) {
		if (employes.add(employe))
			return "Add Successful";
		return "Echec";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response displayEmployeesList() {
		GenericEntity<List<Employe>> result = new GenericEntity<List<Employe>>(employes) {
		};
		if (employes.size() != 0)
			return Response.status(Status.FOUND).entity(result).build();
		else
			return Response.status(Status.NO_CONTENT).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getEmploye(@PathParam(value = "id") int cin) {
		for (Employe info : employes) {
			if (info.getCin() == cin) {
				return Response.status(Status.FOUND).entity(info).build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateEmploye(Employe e) {
		int index = this.getIndexByCin(e.getCin());
		if (index != -1) {
			employes.set(index, e);
			return Response.status(Status.OK).entity("Update successful! (yeaaah!)").build();
		}
		return Response.status(Status.NOT_FOUND).entity("Update unsuccessful! (nooooo!)").build();
	}

	@DELETE
	@Path("/{id}")
//	public boolean deleteEmpl(@PathParam(value = "id") int cin) {
//		int index = getIndexByCin(cin);
//
//		if (index != -1) {
//			employes.remove(index);
//			return true;
//		} else
//			return false;
//
//	}
	public Response deleteEmpl(@PathParam(value = "id") int cin) {
		int index = getIndexByCin(cin);
		if (index != -1) {
			employes.remove(index);
			return Response.status(Status.OK).entity(true).build();
		} else
			return Response.status(Status.NOT_FOUND).entity(false).build();
	}

	public int getIndexByCin(int cin) {
		for (Employe emp : employes) {
			if (emp.getCin() == cin)
				return employes.indexOf(emp);
		}
		return -1;
	}
}
