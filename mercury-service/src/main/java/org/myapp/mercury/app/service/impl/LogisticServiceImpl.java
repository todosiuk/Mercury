package org.myapp.mercury.app.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.myapp.mercury.app.infrastructure.util.CommonUtil;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;
import org.myapp.mercury.app.model.search.criteria.range.RangeCriteria;
import org.myapp.mercury.app.service.LogisticService;
import org.springframework.stereotype.Component;

@Component
public class LogisticServiceImpl implements LogisticService {

	private final List<Supplier> suppliers;

	/**
	 * Auto-increment counter for entity id generation
	 */
	private int counter = 0;

	public LogisticServiceImpl() {
		suppliers = new ArrayList<Supplier>();
	}

	@Override
	public List<Supplier> findSuppliers() {
		return CommonUtil.getSafeList(suppliers);
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		if (!suppliers.contains(supplier)) {
			supplier.setId(++counter);
			suppliers.add(supplier);
		}

	}

	@Override
	public Optional<Supplier> findSupplierById(final int id) {
		return suppliers.stream().filter((supplier) -> supplier.getId() == id).findFirst();
	}

	@Override
	public List<Supply> findSupplies(SupplyCriteria criteria, RangeCriteria rangeCriteria) {
		Stream<Supplier> stream = suppliers.stream()
				.filter((supplier) -> StringUtils.isEmpty(criteria.getSupplierName())
						|| supplier.getName().equals(criteria.getSupplierName()));
	

	Optional<Set<Supply>> supplyes = stream.map((supplier) -> supplier.getSupplyList()).reduce((supply1, supply2)->{
        Set<Supply> newSupply = new HashSet<>(supply2);
        newSupply.addAll(supply1);
        return newSupply;
 });if(!supplyes.isPresent())
	{
		return Collections.emptyList();
	}return supplyes.get().stream().filter((supply)->criteria.getTransportType()==null||station.getTransportType()==criteria.getTransportType()).collect(Collectors.toList());

}}
