package org.myapp.mercury.app.service;

import java.util.List;

import org.myapp.mercury.app.model.entity.logistic.Supplier;

/**
 * Entry point to perform operation over supplier entities
 * 
 * @author todosuk
 *
 */
public interface LogisticService {

	/**
	 * Returns list of existing suppliers
	 * 
	 * @return
	 */
	List<Supplier> findSuppliers();

	/**
	 * Saves specified supplier instance
	 * 
	 * @param supplier
	 */
	void saveSupplier(Supplier supplier);

}
