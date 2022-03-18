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
import tn.esprit.entites.Logement;

//Tahar Remadi - 4NIDS1
// Convention: le path de la ressource doit être au pluriel
@Path("/logements")
public class LogementRessource {

	public static LogementBusiness lb = new LogementBusiness();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response RecupererListeLogements(@QueryParam(value = "delegation") String referenceDelegation,
			@QueryParam(value = "gouvernorat") String referenceGouvernorat,
			@QueryParam(value = "type") String referenceType, @QueryParam(value = "prix") String referencePrix,
			@QueryParam(value = "reference") String referenceReference) {

		List<Logement> resultat = new ArrayList<Logement>();
		Logement resultatReference = new Logement();

		if (referenceDelegation != null)
			resultat = lb.getLogementsByDelegation(referenceDelegation);
		else if (referenceGouvernorat != null)
			resultat = lb.getLogementsByGouvernorat(referenceGouvernorat);
//		else if (referenceType != null)
//			resultat = lb.getLogementsByType(referenceType);
		else if (referencePrix != null)
			resultat = lb.getLogementsByPrix(Float.parseFloat(referencePrix));
		else if (referenceReference != null)
			resultatReference = lb.getLogementsByReference(Integer.parseInt(referenceReference));
		else
			resultat = lb.getLogements();

		if (resultatReference != null)
			return Response.status(Status.OK).entity(resultatReference).build();
		else if (resultat.size() != 0)
			return Response.status(Status.OK).entity(resultat).build();
		return Response.status(Status.NOT_FOUND).build();
	}

}
