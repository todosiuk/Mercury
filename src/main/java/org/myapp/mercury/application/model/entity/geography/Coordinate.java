package org.myapp.mercury.application.model.entity.geography;

import org.myapp.mercury.application.model.entity.base.AbstractEntity;

/**
 * Geographical coordinate of an object
 * 
 * @author Â
 *
 */
public class Coordinate extends AbstractEntity {

	private double x;

	private double y;

	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
