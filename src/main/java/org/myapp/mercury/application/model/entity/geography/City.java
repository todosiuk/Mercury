package org.myapp.mercury.application.model.entity.geography;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.myapp.mercury.application.model.entity.geography.Point;
import org.myapp.mercury.application.model.entity.transport.TransportType;
import org.myapp.mercury.application.model.entity.base.AbstractEntity;

/**
 * Any locality that contains delivery address
 * 
 * @author Â
 *
 */
public class City extends AbstractEntity {

	public City(final String name) {
		this.name = name;
	}

	private String name;

	/**
	 * Name of the district where city is placed
	 */
	private String district;
	/**
	 * Name of the region where district is located. Region is top- level area in
	 * the country
	 */
	private String region;
	/**
	 * Set of delivery addresses that is linked to this place
	 */
	private Set<Point> deliveryPoint;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Set<Point> getDeliveryPoint() {
		return deliveryPoint;
	}

	public void setDeliveryPoint(Set<Point> deliveryPoint) {
		this.deliveryPoint = deliveryPoint;
	}

	/**
	 * Adds specified delivery point to the city point list
	 * 
	 * @param point
	 */
	public Point addDeliveryPoint(final TransportType transportType) {
		if (deliveryPoint == null) {
			deliveryPoint = new HashSet<Point>();
		}
		Point point = new Point(this, transportType);
		deliveryPoint.add(point);
		return point;
	}

	/**
	 * Remove delivery point
	 * 
	 * @param point
	 */

	public void removePointSuccess(Point point) {
		Objects.requireNonNull(point, "point parameter is not initialized");
		if (point != null) {
			deliveryPoint.remove(point);
		}
	}

}
