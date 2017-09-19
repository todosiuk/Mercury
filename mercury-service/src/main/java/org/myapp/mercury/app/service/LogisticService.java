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

	Supplier findById(long id);

	Supplier findByName(String name);

	void updateSupplier(Supplier supplier);

	void deleteSupplierById(long id);

	void deleteAllSuppliers();

	public boolean isSupplierExist(Supplier supplier);

	List<Supplier> findSuppliers();

	void saveSupplier(Supplier supplier);

}
