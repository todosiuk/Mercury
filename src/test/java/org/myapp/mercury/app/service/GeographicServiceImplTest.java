package org.myapp.mercury.app.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.myapp.mercury.app.model.entity.geography.City;
import org.myapp.mercury.app.service.GeographicService;
import org.myapp.mercury.app.service.impl.GeographicServiceImpl;

/**
 * Contain unit-tests for {@link GeographicServiceImpl}
 * 
 * @author todosuk
 *
 */
public class GeographicServiceImplTest {

	private GeographicService service;

	@Before
	public void setup() {
		service = new GeographicServiceImpl();
	}

	@Test
	public void testNoDataReturnedAtStart() {
		List<City> cities = service.findCities();
		assertTrue(cities.isEmpty());
	}

	@Test
	public void testSaveNewCitySuccess() {
		City city = new City("Kharkiv");
		service.saveCity(city);

		List<City> cities = service.findCities();

		assertEquals(cities.size(), 1);
		assertEquals(cities.get(0).getName(), "Kharkiv");
	}
}
