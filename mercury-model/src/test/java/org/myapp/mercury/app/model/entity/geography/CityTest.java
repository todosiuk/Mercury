package org.myapp.mercury.app.model.entity.geography;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.myapp.mercury.app.model.entity.geography.City;
import org.myapp.mercury.app.model.entity.geography.Point;
import org.myapp.mercury.app.model.entity.transport.TransportType;

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
		city = new City("Kyiv");
	}

	@Test
	public void testAddValidDeliveryPointSuccess() {
		Point point = city.addDeliveryPoint(TransportType.AUTO);
		assertTrue(containsDeliveryAddress(city, point));
		assertEquals(city, point.getCity());
	}

	@Test(expected = NullPointerException.class)
	public void testAddNullDeliveryPointTransportTypeFailure() {
		city.addDeliveryPoint(null);
		assertTrue(false);
	}

	@Test
	public void testRemoveDeliveryPointSuccess() {
		Point point = city.addDeliveryPoint(TransportType.RAILWAY);
		city.removePointSuccess(point);
		assertTrue(city.getDeliveryPoint().isEmpty());

	}

	@Test(expected = NullPointerException.class)
	public void testRemoveNullDeliveryPointFailure() {
		city.removePointSuccess(null);
		assertTrue(false);
	}

	private boolean containsDeliveryAddress(City city, Point point) {
		return city.getDeliveryPoint().contains(point);
	}
}
