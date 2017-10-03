package org.myapp.mercury.app.persistence.repository;

import java.util.List;
import java.util.Set;

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
	 * @param supplierId
	 * @return
	 */
	Supplier findById(int supplierId);

	/**
	 * Delete supplier with specified identifier
	 * 
	 * @param supplierId
	 */
	void delete(int supplierId);

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

}
