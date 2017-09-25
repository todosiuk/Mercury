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
import org.myapp.mercury.app.service.LogisticService;
import org.springframework.stereotype.Component;

@Component
public class LogisticServiceImpl implements LogisticService {

	private final SupplierRepository supplierRepository;

	public LogisticServiceImpl(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
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

	@Override
	public List<Supply> searchSupplies(SupplyCriteria criteria, RangeCriteria rangeCriteria) {
		Set<Supply> supplies = new HashSet<>();
		supplierRepository.findAll().forEach(supplier -> supplies.addAll(supplier.getSupplyList()));
		return supplies.stream().filter(supply -> supply.match(criteria)).collect(Collectors.toList());
	}
}
