package org.myapp.mercury.app.persistence.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.myapp.mercury.app.infrastructure.util.CommonUtil;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.persistence.repository.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author todosuk
 *
 */
@Repository
@Transactional
public class SupplierRepositoryImpl implements SupplierRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(SupplierRepositoryImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void save(Supplier supplier) {
		manager.persist(supplier);
	}

	@Override
	public Supplier findById(int supplierId) {
		Supplier supplier = manager.find(Supplier.class, supplierId);
		return supplier;

	}

	@Override
	public void delete(int supplierId) {
		Supplier supplier = manager.find(Supplier.class, supplierId);
		manager.remove(supplier);
	}

	@Override
	public List<Supplier> findAll() {
		@SuppressWarnings("unchecked")
		List<Supplier> suppliers = manager.createQuery("select s from Supplier s ORDER BY s.name").getResultList();
		return suppliers;
	}

	public Supplier updateSupplier(Supplier supplier) {
		manager.merge(supplier);
		return supplier;
	}
}
