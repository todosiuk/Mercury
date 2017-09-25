package org.myapp.mercury.app.persistence.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.persistence.repository.SupplierRepository;
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

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void save(Supplier supplier) {

	}

	@Override
	public Supplier findById(int supplierId) {
		return null;

	}

	@Override
	public void delete(int supplierId) {

	}

	@Override
	public List<Supplier> findAll() {
		return null;

	}
}
