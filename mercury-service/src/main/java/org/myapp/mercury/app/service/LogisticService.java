package org.myapp.mercury.app.service;

import java.util.List;
import java.util.Optional;

import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;
import org.myapp.mercury.app.model.search.criteria.range.RangeCriteria;

/**
 * Entry point to perform operation over supplier and supply entities
 * 
 * @author todosuk
 *
 */
public interface LogisticService {

	List<Supplier> findSuppliers();

	Optional<Supplier> findSupplierById(int id);

	Optional<Supplier> findSupplierByName(String name);

	void saveSupplier(Supplier supplier);

	List<Supply> findSuppliesByCriteria(SupplyCriteria criteria, RangeCriteria rangeCriteria);

	void deleteSupplier(int id);

	void updateSupplier(Supplier supplier);

	void saveSupply(int supplierId, Supply supply);

	void deleteSupply(int id);

	void updateSupply(Supply supply);

	List<Supply> findAllSupplies();

}
