package org.myapp.mercury.app.model.search.criteria;

import java.time.LocalDateTime;

/**
 * Filtering criteria for search operation
 * 
 * @author todosuk
 *
 */
public class SupplyCriteria {

	private String carNumber;
	private String driverName;
	private String phone;
	private String product;
	private String documentReceiving;
	private String department;
	private String storekeeper;
	private LocalDateTime firstCreated;
	private String supplierName;

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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public LocalDateTime getFirstCreated() {
		return firstCreated;
	}

	public void setFirstCreated(LocalDateTime firstCreated) {
		this.firstCreated = firstCreated;
	}

	

}
