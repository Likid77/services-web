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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import rest.entities.Employe;


@Path("employes")
public class GestionEmploye {
	
	public static  List<Employe> employes=new ArrayList<Employe>();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_XML)	
	public Response ajouterEmploye(Employe employe) {
		 if(employes.add(employe))
	return Response.status(Status.CREATED).entity(employes).build();
	return Response.status(Status.NO_CONTENT).build();
	  
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  Response  displayEmployeesList() {
		
		if(employes.size()!=0)
			return Response.status(Status.FOUND).entity(employes).build();
		else
			return Response.status(Status.NOT_FOUND).build();
					
	}
	
	@GET
	@Path("/{id}/")
	@Produces(MediaType.APPLICATION_XML)
	public Response getEmploye(@PathParam("id") int cin) {
		for (Employe info:employes) {
	       if(info.getCin()==cin) {
	    	   return  Response.status(Status.FOUND)
						.entity(info)
						.build(); 
	    	
	       }
		}
	       		
			return  Response.status(Status.NOT_FOUND).build();
		
		
	}
	
		
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateEmploye(Employe e) {
		int index= this.getIndexByCin(e.getCin());
		if (index!=-1) {
			employes.set(index, e);
			return Response.status(Status.OK).entity("update successful").build();
			
		}
		return Response.status(Status.NOT_FOUND).entity("update unsuccessful").build();
	
	}
	
	@DELETE
	@Path("/{CIN}")
	public Response deleteEmpl(@PathParam("CIN") int cin){
		int index= getIndexByCin(cin);
		
		if (index!=-1) {
			employes.remove(index);
			return Response.status(Status.OK).entity(true).build();
			
		}
		else 
			return Response.status(Status.NOT_FOUND).entity(false).build();
			
    }
	
	public int getIndexByCin(int cin) {
		for(Employe emp: employes) {
			if (emp.getCin()==cin)
				return employes.indexOf(emp);
		}
		return -1;
	}
	
		
}
