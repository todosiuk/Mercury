package org.myapp.mercury.app.model.search.criteria;

import java.time.LocalDateTime;
import java.util.Objects;

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
	private LocalDateTime firstCreatedStartDate;
	private LocalDateTime firstCreatedEndDate;
	private String supplierName;

	public SupplyCriteria(String str) {
	}

	public SupplyCriteria(String firstCreatedStartDate, String firstCreatedEndDate) {
	}

	public static SupplyCriteria byCarNumber(String carNumber) {
		return new SupplyCriteria(carNumber);
	}

	public static SupplyCriteria byDriverName(String driverName) {
		return new SupplyCriteria(driverName);
	}

	public static SupplyCriteria byPhone(String phone) {
		return new SupplyCriteria(phone);
	}

	public static SupplyCriteria byProduct(String product) {
		return new SupplyCriteria(product);
	}

	public static SupplyCriteria byDocumentReceiving(String documentReceiving) {
		return new SupplyCriteria(documentReceiving);
	}

	public static SupplyCriteria byDepartment(String department) {
		return new SupplyCriteria(department);
	}

	public static SupplyCriteria byStorekeeper(String storekeeper) {
		return new SupplyCriteria(storekeeper);
	}

	public static SupplyCriteria bySupplierName(String supplierName) {
		return new SupplyCriteria(supplierName);
	}

	public static SupplyCriteria betweenDate(String firstCreatedStartDate, String firstCreatedEndDate) {
		return new SupplyCriteria(firstCreatedStartDate, firstCreatedEndDate);
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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public LocalDateTime getFirstCreatedStartDate() {
		return firstCreatedStartDate;
	}

	public void setFirstCreatedStartDate(LocalDateTime firstCreatedStartDate) {
		this.firstCreatedStartDate = firstCreatedStartDate;
	}

	public LocalDateTime getFirstCreatedEndDate() {
		return firstCreatedEndDate;
	}

	public void setFirstCreatedEndDate(LocalDateTime firstCreatedEndDate) {
		this.firstCreatedEndDate = firstCreatedEndDate;
	}
}
