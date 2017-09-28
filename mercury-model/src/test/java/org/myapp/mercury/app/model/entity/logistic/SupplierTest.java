package org.myapp.mercury.app.model.entity.logistic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;

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
		supplier = new Supplier();

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

	@Test
	public void testRemoveSupplySuccess() {
		Supply supply = supplier.addSupply("AA2530JJ");
		supplier.removeSupply(supply);
		assertTrue(supplier.getSupplyList().isEmpty());
	}

	@Test(expected = NullPointerException.class)
	public void testRemoveNullSupplyFailure() {
		supplier.removeSupply(null);
		assertTrue(false);
	}

	private boolean containsSupply(Supplier supplier, Supply supply) {
		return supplier.getSupplyList().contains(supply);
	}
}
