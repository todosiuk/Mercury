package org.myapp.mercury.application.model.entity.geography;

import org.myapp.mercury.application.model.entity.base.AbstractEntity;
import org.myapp.mercury.application.model.entity.transport.TransportType;
import org.myapp.mercury.application.model.entity.geography.Coordinate;

/**
 * Delivery point
 * 
 * @author Â
 *
 */
public class Point extends AbstractEntity {
	private City city;

	private String phone;

	private Coordinate coordinate;

	private TransportType transportType;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public TransportType getTransportType() {
		return transportType;
	}

	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}

}
