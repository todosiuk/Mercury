package org.myapp.mercury.app.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.Lists;

@Path(value = "suppliers")
/**
 * {@link SupplierResource} is REST web-service that handles supplier-related
 * requests
 * 
 * @author todosuk
 *
 */
public class SupplierResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON) // in which format the data will be sent to the client
	public List<String> findSuppliers() {
		return Lists.newArrayList("ANP", "25UA");
	}

}
