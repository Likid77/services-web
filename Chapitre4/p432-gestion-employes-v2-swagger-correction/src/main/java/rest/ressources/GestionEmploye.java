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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import rest.entities.Employe;

@Api
@Path("/employes")
public class GestionEmploye {
	
	public static  List<Employe> employes=new ArrayList<Employe>();
	
	/*
		
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response ajouterEmploye(Employe employe) {
		 if(employes.add(employe)) {
			 return Response.status(Status.CREATED).entity(employe).build();
		 }
			 return Response.status(Status.NO_CONTENT).build();  
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  Response  displayEmployeesList() {
		
		if(employes.size()!=0) {
			return Response.status(Status.FOUND).entity(employes).build();
		}
		else
			return Response.status(Status.NO_CONTENT).build();
					
	}
	
	
			
	@Path("/{CIN}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getEmploye(@PathParam("CIN") int cin) {
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
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateEmploye(Employe e) {
		int index= this.getIndexByCin(e.getCin());
		if (index!=-1) {
			employes.set(index, e);
			return Response.status(Status.OK).entity("update successful").build();
			
		}
		return Response.status(Status.NOT_FOUND).entity("update unsuccessful").build();
	
	}
	
	

	@DELETE
	@Path("{CIN}")
	public Response deleteEmpl(@PathParam("CIN") int cin){
		int index= getIndexByCin(cin);
		
		if (index!=-1) {
			employes.remove(index);
			return Response.status(Status.OK).entity(true).build();
		}else 
			return Response.status(Status.NO_CONTENT).entity(false).build();
			
    }
    
    
    
  public int getIndexByCin(int cin) {
		for(Employe emp: employes) {
			if (emp.getCin()==cin)
				return employes.indexOf(emp);
		}
		return -1;
	}
	*/
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@ApiOperation(value="Ajout employe")
	@ApiResponses({
		@ApiResponse(code=200, message = "Success")
	})
	public Response ajouterEmploye(Employe employe) {
		 if(employes.add(employe)) {
			// GenericEntity<List<Employe>> result = new GenericEntity<List<Employe>>(employes) {};
			 return Response.status(Status.CREATED).entity(employe).build();
		 }
			 return Response.status(Status.NO_CONTENT).build();  
		
	}

	@GET	
	@ApiOperation(value="Get Employees" ,produces=MediaType.APPLICATION_JSON)
	@ApiResponses({
		@ApiResponse(code=200, message = "Success")
	})
	@Produces(MediaType.APPLICATION_JSON)
	public  Response  displayEmployeesList() {
		
		if(employes.size()!=0) {
			return Response.status(Status.FOUND).entity(employes).build();
		}
		
		else
			return Response.status(Status.NO_CONTENT).build();
					
	}
	
	@Path("/{CIN}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@ApiOperation(value="get Employe by id")
	public Response getEmploye(@PathParam("CIN") int cin) {
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
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value="update Employe")
	@ApiResponses({
		@ApiResponse(code=200, message = "Success")
	})
	public Response updateEmploye(Employe e) {
		int index= this.getIndexByCin(e.getCin());
		if (index!=-1) {
			employes.set(index, e);
			return Response.status(Status.OK).entity("update successful").build();
			
		}
		return Response.status(Status.NOT_FOUND).entity("update unsuccessful").build();
	
	}
	

	@DELETE
	@Path("{CIN}")
	public Response deleteEmpl(@PathParam("CIN") int cin){
		int index= getIndexByCin(cin);
		
		if (index!=-1) {
			employes.remove(index);
			return Response.status(Status.OK).entity(true).build();
		}else 
			return Response.status(Status.NO_CONTENT).entity(false).build();
			
    }
	
	public int getIndexByCin(int cin) {
		for(Employe emp: employes) {
			if (emp.getCin()==cin)
				return employes.indexOf(emp);
		}
		return -1;
	}
	
		
}
