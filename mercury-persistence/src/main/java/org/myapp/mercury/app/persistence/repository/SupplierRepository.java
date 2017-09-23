package org.myapp.mercury.app.persistence.repository;

import java.util.List;

import org.myapp.mercury.app.model.entity.logistic.Supplier;

/**
 * Defines CRUD methods to access City objects in the persistent storage
 * 
 * @author todosuk
 *
 */
public interface SupplierRepository {
	/**
	 * Saves(creates or modifies) specified supplier instance
	 * 
	 * @param city
	 */
	void save(Supplier supplier);

	/**
	 * Returns supplier with specified identifier. If no supplier exists with such
	 * identifier then null is returned
	 * 
	 * @param supplierId
	 * @return
	 */
	Supplier findById(int SupplierId);

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

}
