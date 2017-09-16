package org.myapp.mercury.app.model.search.criteria;

import org.myapp.mercury.app.model.entity.transport.TransportType;

/**
 * Filtering criteria for search operation
 * 
 * @author todosuk
 *
 */
public class PointCriteria {

	private String cityName;

	private TransportType transportType;

	/**
	 * Delivery's point: street, zip code, building number
	 */
	private String address;

	/**
	 * Returns filtering criteria to search station that contains specified name
	 * parameter
	 * 
	 * @param name
	 * @return
	 */
	public static PointCriteria byName(String name) {
		return new PointCriteria(name);
	}

	public PointCriteria(final String name) {
		this.cityName = name;
	}

	public PointCriteria() {
	}

	public PointCriteria(final TransportType transportType) {
		this.transportType = transportType;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public TransportType getTransportType() {
		return transportType;
	}

	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
