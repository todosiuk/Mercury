package org.myapp.mercury.application.model.entity.geography;

import org.myapp.mercury.application.model.entity.base.AbstractEntity;

/**
 * Stores address attributes
 * 
 * @author Â
 *
 */
public class Address extends AbstractEntity {

	private String zipCode;

	private String street;

	private String houseNo;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

}
