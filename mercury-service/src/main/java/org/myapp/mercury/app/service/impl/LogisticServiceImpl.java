package org.myapp.mercury.app.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
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
	public Optional<Supplier> findSupplierById(final int id) {
		return Optional.ofNullable(supplierRepository.findById(id));
	}

	public void deleteSupplier(int supplierId) {
		supplierRepository.delete(supplierId);
	}

	public void updateSupplier(Supplier supplier) {
		supplierRepository.updateSupplier(supplier);

	}

	@Override
	public void saveSupply(int supplierId, Supply supply) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSupply(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSupply(Supply supply) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Supply> searchSupplies(SupplyCriteria criteria, RangeCriteria rangeCriteria) {
		Set<Supply> supplies = new HashSet<>();
		supplierRepository.findAll().forEach(supplier -> supplies.addAll(((Supplier) supplier).getSupplyList()));
		return supplies.stream().filter(supply -> supply.match(criteria)).collect(Collectors.toList());
	}
}
