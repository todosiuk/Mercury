package org.myapp.mercury.app.model.entity.geography;

import java.util.Objects;

import org.myapp.mercury.app.model.entity.base.AbstractEntity;
import org.myapp.mercury.app.model.entity.geography.Coordinate;
import org.myapp.mercury.app.model.entity.transport.TransportType;

/**
 * Delivery point
 * 
 * @author Â
 *
 */
public class Point extends AbstractEntity {
	
	/**
     * You shouldn't create point object directly. Use
     * {@link City} functionality instead
     * @param city
     * @param transportType
     */

	public Point(final City city, final TransportType transportType) {
		this.city = Objects.requireNonNull(city);
		this.transportType = Objects.requireNonNull(transportType);
	}

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
