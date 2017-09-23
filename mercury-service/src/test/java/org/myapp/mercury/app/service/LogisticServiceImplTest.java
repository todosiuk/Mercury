package org.myapp.mercury.app.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.service.LogisticService;
import org.myapp.mercury.app.service.impl.LogisticServiceImpl;

/**
 * Contain unit- tests for {@link LogisticServiceImpl}
 * 
 * @author todosuk
 *
 */
public class LogisticServiceImplTest {

	private LogisticService service;

	@Before
	public void setup() {
		service = new LogisticServiceImpl();
	}

	@Test
	public void testNoDataReturnedAtStart() {
		List<Supplier> suppliers = service.findSuppliers();
		assertTrue(suppliers.isEmpty());
	}

	@Test
	public void testSaveNewSupplierSuccess() {
		Supplier supplier = new Supplier();
		supplier.setName("Epic");
		service.saveSupplier(supplier);

		List<Supplier> suppliers = service.findSuppliers();
		assertEquals(suppliers.size(), 1);
		assertEquals(suppliers.get(0).getName(), "Epic");
	}
}
