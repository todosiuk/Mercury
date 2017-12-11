package org.myapp.mercury.app.service.impl;

import java.util.List;
import java.util.Optional;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;
import org.myapp.mercury.app.model.search.criteria.range.RangeCriteria;
import org.myapp.mercury.app.persistence.repository.SupplierRepository;
import org.myapp.mercury.app.persistence.repository.SupplyRepository;
import org.myapp.mercury.app.persistence.repository.impl.SupplierRepositoryImpl;
import org.myapp.mercury.app.service.LogisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogisticServiceImpl implements LogisticService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SupplierRepositoryImpl.class);

	@Autowired
	private final SupplierRepository supplierRepository;
	@Autowired
	private final SupplyRepository supplyRepository;

	public LogisticServiceImpl(SupplierRepository supplierRepository, SupplyRepository supplyRepository) {
		this.supplierRepository = supplierRepository;
		this.supplyRepository = supplyRepository;
	}

	@Override
	public List<Supplier> findSuppliers() {
		return supplierRepository.findAll();
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	@Override
	public Supplier findSupplierById(final long id) {
		return supplierRepository.findById(id);
	}

	public List<Supplier> findSupplierByName(String name) {
		return supplierRepository.findSupplierByName(name);
	}

	public void deleteSupplier(long supplierId) {
		supplierRepository.delete(supplierId);
	}

	public void updateSupplier(Supplier supplier) {
		supplierRepository.updateSupplier(supplier);
	}

	@Override
	public void saveSupply(long supplierId, Supply supply) {
		supplyRepository.save(supplierId, supply);
	}

	@Override
	public void deleteSupply(long id) {
		supplyRepository.delete(id);
	}

	@Override
	public void updateSupply(Supply supply) {
		supplyRepository.updateSupply(supply);
	}

	@Override
	public List<Supply> findSuppliesByCriteria(SupplyCriteria criteria, RangeCriteria rangeCriteria) {
		return supplyRepository.findAllByCriteria(criteria);
	}

	@Override
	public List<Supply> findAllSupplies() {
		return supplyRepository.findAll();
	}

	public Supply findSupplyById(long id) {
		return supplyRepository.findById(id);
	}
}
