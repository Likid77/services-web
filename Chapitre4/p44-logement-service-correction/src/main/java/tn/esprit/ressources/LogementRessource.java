package tn.esprit.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.business.LogementBusiness;

@Path("logements")
public class LogementRessource {
	public static LogementBusiness logeBusiness = new LogementBusiness();


	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getLogements(@QueryParam(value = "delegation") String deleguation,
			@QueryParam(value = "gouvernorat") String gouvernorat, @QueryParam(value = "type") String type,
			@QueryParam(value = "prix") String prix, @QueryParam(value = "reference") int reference) {

		if ((deleguation == null) && (gouvernorat == null) && (type == null) && (prix == null)) {
			// si pas de queryparam (getAllLogements)
			if (logeBusiness.getLogements() == null)
				return Response
						.status(Status.NO_CONTENT)
						.header("Access-Control-Allow-Origin", "*")
						.build();

			if (logeBusiness.getLogements().size() == 0)
				return Response
						.status(Status.NO_CONTENT)
						.entity("Pas de contenu")
						.header("Access-Control-Allow-Origin", "*")
						.build();

			else
				return Response
						.status(Status.OK).entity(logeBusiness.getLogements())
						.header("Access-Control-Allow-Origin", "*")
						.build();
				//return Response.ok(logeBusiness.getLogements()).build();

		} else if ((deleguation != null) && (gouvernorat == null) && (type == null) && (prix == null)) {
			// si le paramètre envoyé est la délégation
			if (logeBusiness.getLogementsByDeleguation(deleguation) == null)
				return Response
						.status(Status.NOT_FOUND)
						.header("Access-Control-Allow-Origin", "*")
						.build();

			if (logeBusiness.getLogementsByDeleguation(deleguation).size() == 0) {
				return Response
						.status(Status.NOT_ACCEPTABLE)
						
						.entity("Pas de contenu")
						.header("Access-Control-Allow-Origin", "*")
						.build();

			} else {
				return Response.ok(logeBusiness.getLogementsByDeleguation(deleguation), MediaType.APPLICATION_JSON)
						.build();
			}

		} else if ((deleguation == null) && (gouvernorat != null) && (type == null) && (prix == null)) {

			// si le paramètre envoyé est gouvernorat
			if (logeBusiness.getLogementsByGouvernorat(gouvernorat) == null)
				return Response
						.status(Response.Status.NOT_FOUND)
						.header("Access-Control-Allow-Origin", "*")
						.build();

			if (logeBusiness.getLogementsByGouvernorat(gouvernorat).size() == 0)
				return Response
						.status(Response.Status.NO_CONTENT)
						.header("Access-Control-Allow-Origin", "*")
						.entity("Pas de contenu").build();

			else {
				return Response.ok(logeBusiness.getLogementsByGouvernorat(gouvernorat), MediaType.APPLICATION_JSON)
						.header("Access-Control-Allow-Origin", "*")
						.build();
			}

		} else
			return Response.status(Response.Status.BAD_REQUEST).entity("Requete eronnée").build();
	}
}

