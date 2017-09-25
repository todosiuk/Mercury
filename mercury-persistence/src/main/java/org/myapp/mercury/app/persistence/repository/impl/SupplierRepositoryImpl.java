package org.myapp.mercury.app.persistence.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.persistence.hibernate.SessionFactoryBuilder;
import org.myapp.mercury.app.persistence.repository.SupplierRepository;

/**
 * 
 * @author todosuk
 *
 */
public class SupplierRepositoryImpl implements SupplierRepository {

	private final SessionFactory sessionFactory;

	public SupplierRepositoryImpl(SessionFactoryBuilder builder) {
		sessionFactory = builder.getSessionFactory();
	}

	@Override
	public void save(Supplier supplier) {
		try (Session session = sessionFactory.openSession()) {
			session.saveOrUpdate(supplier);
		}

	}

	@Override
	public Supplier findById(int supplierId) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Supplier.class, supplierId);
		}
	}

	@Override
	public void delete(int supplierId) {
		try (Session session = sessionFactory.openSession()) {
			Supplier supplier = session.get(Supplier.class, supplierId);
			if (supplier != null) {
				session.delete(supplier);
			}
		}

	}

	@Override
	public List<Supplier> findAll() {
		try (Session session = sessionFactory.openSession()) {
			return session.createCriteria(Supplier.class).list();
		}
	}

}
