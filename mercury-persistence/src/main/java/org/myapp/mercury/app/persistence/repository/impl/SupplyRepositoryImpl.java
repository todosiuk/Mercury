package org.myapp.mercury.app.persistence.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;
import org.myapp.mercury.app.persistence.repository.SupplyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SupplyRepositoryImpl implements SupplyRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(SupplyRepositoryImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void save(int supplierId, Supply supply) {
		Supplier supplier = manager.find(Supplier.class, supplierId);
		supply.setSupplier(supplier);
		manager.persist(supply);
	}

	@Override
	public Supply findById(int supplyId) {
		Supply supply = manager.find(Supply.class, supplyId);
		return supply;
	}

	@Override
	public void delete(int supplyId) {
		Supply supply = manager.find(Supply.class, supplyId);
		manager.remove(supply);
	}

	@Override
	public List<Supply> findAll() {
		String query = "select s from Supply s";
		TypedQuery<Supply> supplies = manager.createQuery(query, Supply.class);
		return supplies.getResultList();
	}

	@Override
	public void updateSupply(Supply supply) {
		manager.merge(supply);
	}

	@Override
	public List<Supply> findAllByCriteria(SupplyCriteria supplyCriteria) {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Supply> query = cb.createQuery(Supply.class);
		Root<Supply> supplyRoot = query.from(manager.getMetamodel().entity(Supply.class));
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (supplyCriteria.getCarNumber() != null && !supplyCriteria.getCarNumber().isEmpty()) {
			predicates.add(cb.like(supplyRoot.get("carNumber"), supplyCriteria.getCarNumber()));
		}
		if (supplyCriteria.getDepartment() != null && !supplyCriteria.getDepartment().isEmpty()) {
			predicates.add(cb.like(supplyRoot.get("department"), supplyCriteria.getDepartment()));
		}
		if (supplyCriteria.getDocumentReceiving() != null && !supplyCriteria.getDocumentReceiving().isEmpty()) {
			predicates.add(cb.like(supplyRoot.get("documentReceiving"), supplyCriteria.getDocumentReceiving()));
		}
		if (supplyCriteria.getDriverName() != null && !supplyCriteria.getDriverName().isEmpty()) {
			predicates.add(cb.like(supplyRoot.get("driverName"), supplyCriteria.getDriverName()));
		}
		if (supplyCriteria.getProduct() != null && !supplyCriteria.getProduct().isEmpty()) {
			predicates.add(cb.like(supplyRoot.get("product"), supplyCriteria.getProduct()));
		}
		if (supplyCriteria.getSupplierName() != null && !supplyCriteria.getSupplierName().isEmpty()) {
			predicates.add(cb.like(supplyRoot.get("supplier"), supplyCriteria.getSupplierName()));
		}
		if (supplyCriteria.getFirstCreated() != null) {
			predicates.add(cb.between(supplyRoot.get("firstCreated"), supplyCriteria.getFirstCreated(),
					supplyCriteria.getFirstCreated()));
		}
		if (!predicates.isEmpty()) {
			query.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
			query.select(supplyRoot);
		}
		return manager.createQuery(query).getResultList();
	}
}
