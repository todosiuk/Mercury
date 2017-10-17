package org.myapp.mercury.app.persistence.repository;

import java.util.List;

import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;

/**
 * Defines methods to access Supply objects in the persistent storage
 * 
 * @author todosuk
 *
 */
public interface SupplyRepository {

	/**
	 * Saves(creates or modifies) specified supply instance
	 * 
	 * @param supplierId
	 * @param supply
	 */
	void save(long supplierId, Supply supply);

	/**
	 * Returns supply with specified identifier. If no supplies exists with such
	 * identifier then null is returned
	 * 
	 * @param supplyId
	 * @return
	 */
	Supply findById(long supplyId);

	/**
	 * Delete supply with specified identifier
	 * 
	 * @param id
	 */
	void delete(long id);

	/**
	 * Returns all the supplies
	 * 
	 * @return
	 */
	List<Supply> findAll();

	/**
	 * Update supply with specified identifier
	 * 
	 * @param supply
	 */

	void updateSupply(Supply supply);

	/**
	 * Return list of supplies that meet the criteria
	 * 
	 * @return
	 */
	List<Supply> findAllByCriteria(SupplyCriteria supplyCriteria);
}
