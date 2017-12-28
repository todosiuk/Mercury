package org.myapp.mercury.app.model.entity.logistic;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.myapp.mercury.app.model.entity.base.AbstractEntity;

/**
 * Supplier of goods
 * 
 * @author todosuk
 *
 */
@Entity
@Table(name = "SUPPLIER")
public class Supplier extends AbstractEntity {

	@NotNull
	@Size(min = 3, max = 32)
	private String name;

	private Set<Supply> supplyList;

	public Supplier() {
	}

	public Supplier(String string) {
		
	}

	public Supplier(String string, long i, LocalDateTime now) {
	}

	@Column(name = "NAME", nullable = false, length = 32)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "supplier", orphanRemoval = true)
	public Set<Supply> getSupplyList() {
		return supplyList;
	}

	public void setSupplyList(Set<Supply> supplyList) {
		this.supplyList = supplyList;
	}

	/**
	 * Adds supply to the supply list
	 * 
	 * @param supply
	 * @return
	 */
	public Supply addSupply(final String carsNumber) {
		if (supplyList == null) {
			supplyList = new HashSet<Supply>();
		}
		Supply supply = new Supply(this, carsNumber);
		supplyList.add(supply);
		return supply;
	}

	/**
	 * Remove supply
	 */
	public void removeSupply(Supply supply) {
		Objects.requireNonNull(supply, "Supply parameter is not initialized");
		supplyList.remove(supply);
	}
}
