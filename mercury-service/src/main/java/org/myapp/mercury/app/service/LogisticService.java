package org.myapp.mercury.app.service;

import java.util.List;
import java.util.Optional;

import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;
import org.myapp.mercury.app.model.search.criteria.range.RangeCriteria;

/**
 * Entry point to perform operation over supplier entities
 * 
 * @author todosuk
 *
 */
public interface LogisticService {

	List<Supplier> findSuppliers();

	Optional<Supplier> findSupplierById(int id);

	void saveSupplier(Supplier supplier);

	List<Supply> searchSupplies(SupplyCriteria criteria, RangeCriteria rangeCriteria);

}
