package rest.utilities;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import rest.ressources.GestionEmploye;

//@ApplicationPath("")
@ApplicationPath("/api")
public class RestActivator extends Application {
// Cette classe sert à activer les ressources du projet (@ApplicationPath + extends Application)
	public RestActivator() {
		super();

		BeanConfig beanConfig = new BeanConfig();

		beanConfig.setVersion("1.0.0");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8090");
		beanConfig.setBasePath("p432-gestion-employes-v2-swagger/api");
		beanConfig.setResourcePackage("rest.ressources");
		beanConfig.setScan(true);

	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(GestionEmploye.class);
		// Available at localhost:8090/swagger.json
		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		return resources;
	}
}
