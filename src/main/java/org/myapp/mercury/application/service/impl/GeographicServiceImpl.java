package org.myapp.mercury.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.myapp.mercury.application.infrastructure.util.CommonUtil;
import org.myapp.mercury.application.model.entity.geography.City;
import org.myapp.mercury.application.service.GeographicService;

/**
 * Default implementation of the {@link GeographicService}
 * 
 * @author todosuk
 *
 */
public class GeographicServiceImpl implements GeographicService {

	private final List<City> cities;

	public GeographicServiceImpl() {
		cities = new ArrayList<City>();
	}

	@Override
	public List<City> findCities() {
		return CommonUtil.getSafeList(cities);
	}

	@Override
	public void saveCity(City city) {
		if (!cities.contains(city)) {
			cities.add(city);
		}
	}

}
