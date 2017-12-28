package org.myapp.mercury.app.model.entity.logistic;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.myapp.mercury.app.model.entity.base.AbstractEntity;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;
import org.apache.commons.lang3.StringUtils;

/**
 * Goods supply
 * 
 * @author todosuk
 *
 */
@Entity
@Table(name = "SUPPLY")
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

	public Supply() {
	}

	@Column(name = "CAR_NUMBER", nullable = false, length = 10)
	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	@Column(name = "DRIVER_NAME", nullable = false)
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Column(name = "PHONE", nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "PRODUCT")
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Column(name = "DOCUMENT_RECEIVING")
	public String getDocumentReceiving() {
		return documentReceiving;
	}

	public void setDocumentReceiving(String documentReceiving) {
		this.documentReceiving = documentReceiving;
	}

	@Column(name = "DEPARTMENT")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "STOREKEEPER")
	public String getStorekeeper() {
		return storekeeper;
	}

	public void setStorekeeper(String storekeeper) {
		this.storekeeper = storekeeper;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "SUPPLIER_ID")
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Verifies if current supply matches specified criteria
	 * 
	 * @param criteria
	 * @return
	 */
	public boolean match(final SupplyCriteria criteria) {
		Objects.requireNonNull(criteria, "Supply criteria is not initialized");

		if (!StringUtils.isEmpty(criteria.getSupplierName())) {
			if (!supplier.getName().equals(criteria.getSupplierName())) {
				return false;
			}
		}
		return true;
	}

}
