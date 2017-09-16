package org.myapp.mercury.app.service;

import java.util.List;

import org.myapp.mercury.app.model.entity.geography.City;

/**
 * Entry point to perform operations over geographic entities
 * 
 * @author todosuk
 *
 */
public interface GeographicService {
	/**
	 * Returns list of existing cities
	 * 
	 * @return
	 */
	List<City> findCities();

	/**
	 * Saves specified city instance
	 * 
	 * @param city
	 */
	void saveCity(City city);
}
