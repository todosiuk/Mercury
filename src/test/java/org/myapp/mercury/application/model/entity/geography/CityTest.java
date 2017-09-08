package org.myapp.mercury.application.model.entity.geography;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Contains unit- tests to chick functionality of{@link City} class
 * 
 * @author Â
 *
 */
public class CityTest {

	private City city;

	@Before
	public void setup() {
		city = new City();
	}

	@Test
	public void testAddValidDeliveryPointSuccess() {
		Point point = new Point();
		city.addDeliveryPoint(point);
		assertTrue(containsDeliveryAddress(city, point));
		assertEquals(city, point.getCity());
	}

	private boolean containsDeliveryAddress(City city, Point point) {
		return city.getDeliveryPoint().contains(point);
	}
}
