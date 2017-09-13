package org.myapp.mercury.application.model.entity.logistics;

import java.awt.List;
import java.util.HashSet;
import java.util.Set;

import org.myapp.mercury.application.model.entity.base.AbstractEntity;

/**
 * Supplier of goods
 * 
 * @author todosuk
 *
 */
public class Supplier extends AbstractEntity {

	private String name;

	private Set<Supply> supplyList;

	public Supplier(String string) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
}
