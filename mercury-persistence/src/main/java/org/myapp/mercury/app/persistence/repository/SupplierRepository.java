package org.myapp.mercury.app.persistence.repository;

import java.util.List;
import org.myapp.mercury.app.model.entity.logistic.Supplier;

/**
 * Defines methods to access Supplier objects in the persistent storage
 * 
 * @author todosuk
 *
 */
public interface SupplierRepository {
	/**
	 * Saves(creates or modifies) specified supplier instance
	 * 
	 * @param supplier
	 */
	void save(Supplier supplier);

	/**
	 * Returns supplier with specified identifier. If no supplier exists with such
	 * identifier then null is returned
	 * 
	 * @param id
	 * @return
	 */
	Supplier findById(long id);

	/**
	 * Delete supplier with specified identifier
	 * 
	 * @param supplierId
	 */
	void delete(long supplierId);

	/**
	 * Returns all the suppliers
	 * 
	 * @return
	 */
	List<Supplier> findAll();

	/**
	 * Update supplier with specified identifier
	 * 
	 * @param supplier
	 */

	void updateSupplier(Supplier supplier);

	/**
	 * Return supplier with specified name. If no supplier exists with such name
	 * then null is returned
	 * 
	 * @param name
	 * @return
	 */
	List<Supplier> findSupplierByName(String name);
}
