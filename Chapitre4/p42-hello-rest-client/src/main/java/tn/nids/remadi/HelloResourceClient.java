package tn.nids.remadi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class HelloResourceClient {

	public static void main(String[] args) {
		
		// 1- Consommation de la ressource non paramétrée
		// ----------------------------------------------
		
		// Create new JAX-RS client
		Client client = ClientBuilder.newClient();
		
		// Set the base URL of the target
		WebTarget target = client.target("http://localhost:8090/hello-jax-rs/rest/greetings/");
		
		// Consuming the SayHello method…
		
		// Get the response from the target URL
		Response response = target.request().get();
		
		// Read the result as a String
		String result = response.readEntity(String.class);
		
		// Print the result of the standard input
		System.out.println(result);
		response.close();
		
		// 2- Consommation de la ressource paramétrée @PathParam
		// -----------------------------------------------------
		WebTarget helloTo1 = target.path("Tahar").path("Remadi");
		Response response1 = helloTo1.request().get();
		String result1 = response1.readEntity(String.class);
		System.out.println(result1);
		response1.close();
		
		// 3- Consommation de la ressource paramétrée @QueryParam
		// ------------------------------------------------------
		WebTarget helloTo2 = target.queryParam("FirstName", "Tahar").queryParam("LastName", "Remadi");
		Response response2 = helloTo2.request().get();
		String result2 = response2.readEntity(String.class);
		System.out.println(result2);
		response2.close();
		
		client.close();
	}
}
