package org.myapp.mercury.app.model.entity.logistic;

import java.util.Objects;

import org.myapp.mercury.app.model.entity.base.AbstractEntity;

/**
 * Goods supply
 * 
 * @author todosuk
 *
 */
public class Supply extends AbstractEntity {
	/**
	 * Car's number that delivered goods
	 */
	private String carNumber;
	/**
	 * Driver's first and second names
	 */
	private String driverName;
	/**
	 * Driver's phone
	 */
	private String phone;
	/**
	 * Goods that was delivered
	 */
	private String product;
	/**
	 * Incoming document's number
	 */
	private String documentReceiving;
	/**
	 * Department for which delivered goods
	 */
	private String department;
	/**
	 * Store keeper who unloaded and accepted the goods
	 */
	private String storekeeper;

	private Supplier supplier;

	public Supply(Supplier supplier, String carsNumber) {
		this.supplier = Objects.requireNonNull(supplier);
		this.carNumber = Objects.requireNonNull(carsNumber);
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDocumentReceiving() {
		return documentReceiving;
	}

	public void setDocumentReceiving(String documentReceiving) {
		this.documentReceiving = documentReceiving;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStorekeeper() {
		return storekeeper;
	}

	public void setStorekeeper(String storekeeper) {
		this.storekeeper = storekeeper;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
