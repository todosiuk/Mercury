package org.myapp.mercury.application.model.entity.logistics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Contains unit- tests to chick functionality of{@link Supplier} class
 * 
 * @author todosuk
 *
 */
public class SupplierTest {

	private Supplier supplier;

	@Before
	public void setup() {
		supplier = new Supplier("ANG");

	}

	@Test
	public void addValidSupplySuccess() {
		Supply supply = supplier.addSupply("AA2630KJ");
		assertTrue(containsSupply(supplier, supply));
		assertEquals(supply, supplier.addSupply(supply.getCarNumber()));
	}

	@Test(expected = NullPointerException.class)
	public void addNullSupplyFailure() {
		supplier.addSupply(null);
		assertTrue(false);
	}
	

	private boolean containsSupply(Supplier supplier, Supply supply) {
		return supplier.getSupplyList().contains(supply);
	}
}
