package tn.esprit.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.business.LogementBusiness;
import tn.esprit.entities.Logement;


@Path("/logements")
public class LogementRessource {
	public static LogementBusiness lb = new LogementBusiness();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response RecupererListeLogements(
			@QueryParam(value = "reference") String referenceReference,
			@QueryParam(value = "delegation") String referenceDelegation,
			@QueryParam(value = "gouvernorat") String referenceGouvernorat,
//			@QueryParam(value = "type") String referenceType,
			@QueryParam(value = "prix") String referencePrix) {
		List<Logement> resultat = new ArrayList<Logement>();
		Logement resultatReference = new Logement();
		resultatReference = null;

		if (referenceReference != null)
			resultatReference = lb.getLogementsByReference(Integer.parseInt(referenceReference));
		else if (referenceDelegation != null)
			resultat = lb.getLogementsByDelegation(referenceDelegation);
		else if (referenceGouvernorat != null)
			resultat = lb.getLogementsByGouvernorat(referenceGouvernorat);
//		else if (referenceType != null)
//			resultat = lb.getLogementsByType(referenceDelegation);
		else if (referencePrix != null)
			resultat = lb.getLogementsByPrix(Float.parseFloat(referencePrix));
		else
			resultat = lb.getLogements();

		if (resultatReference != null)
			return Response.status(Status.OK).entity(resultatReference).build();
		else if (resultat.size() != 0)
			return Response.status(Status.OK).entity(resultat).build();
		else
			return Response.status(Status.NOT_FOUND).build();
	}

}
