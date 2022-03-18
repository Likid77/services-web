package tn.esprit.ressources;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.business.RendezVousBusiness;
import tn.esprit.entites.RendezVous;

@Path("/rendezvous")
public class RendezVousRessource {
	
	public static RendezVousBusiness rvb = new RendezVousBusiness();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response AjouterRendezVous(RendezVous r) {
		if (rvb.addRendezVous(r)) {
			return Response.status(Status.CREATED).entity(rvb.getListeRendezVous()).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response RecupererListeRendezVous(@QueryParam(value = "refLogement") String reference) {
		List<RendezVous> resultat = new ArrayList<RendezVous>();

		if (reference == null)
			resultat = rvb.getListeRendezVous();
		else
			resultat = rvb.getListeRendezVousByLogementReference(Integer.parseInt(reference));

		if (resultat.size() != 0)
			return Response.status(Status.OK).entity(resultat).build();
		return Response.status(Status.NOT_FOUND).build();
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response RecupererRendezVousById(@PathParam("id") int identifiant) {
		RendezVous resultat = rvb.getRendezVousById(identifiant);
		if (resultat != null)
			return Response.status(Status.OK).entity(resultat).build();
		return Response.status(Status.NOT_FOUND).entity("Ce RDV n'existe pas.").build();
	}

	@Path("{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response SupprimerRendezVousById(@PathParam("id") int identifiant) {
		if (rvb.deleteRendezVous(identifiant))
			return Response.status(Status.OK).build();
		return Response.status(Status.NOT_FOUND).entity("RDV introuvable - Aucune suppression effectuée.").build();
	}

	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response ModifierRendezVousById(@PathParam("id") int identifiant, RendezVous r) {
		if (rvb.updateRendezVous(identifiant, r))
			return Response.status(Status.OK).build();
		return Response.status(Status.NOT_FOUND).entity("RDV introuvable - Aucune modification effectuée.").build();
	}

}
