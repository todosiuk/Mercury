package org.myapp.mercury.app.rest.service;

import static org.junit.Assert.*;
import java.util.List;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.myapp.mercury.app.rest.service.config.JerseyConfig;

/**
 * {@link SupplierResourceTest} is integration test that verifies
 * {@link SupplierResource}
 * 
 * @author todosuk
 *
 */
public class SupplierResourceTest extends JerseyTest {

	protected Application configure() {
		return new JerseyConfig();
	}

	@Test
	public void testFindCitiesSuccess() {
		List<?> suppliers = target("suppliers").request().get(List.class);
		assertNotNull(suppliers);
		assertTrue(suppliers.contains("ANP"));
		assertTrue(suppliers.contains("25UA"));
	}
}
