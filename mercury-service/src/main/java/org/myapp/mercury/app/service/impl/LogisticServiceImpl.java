package org.myapp.mercury.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.myapp.mercury.app.infrastructure.util.CommonUtil;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.service.LogisticService;

public class LogisticServiceImpl implements LogisticService {

	private final List<Supplier> suppliers;

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
			suppliers.add(supplier);
		}

	}

}
