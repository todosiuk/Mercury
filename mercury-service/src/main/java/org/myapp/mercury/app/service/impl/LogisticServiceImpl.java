package org.myapp.mercury.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.myapp.mercury.app.infrastructure.util.CommonUtil;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.service.LogisticService;
import org.springframework.stereotype.Component;

@Component
public class LogisticServiceImpl implements LogisticService {

	private final List<Supplier> suppliers;

	public LogisticServiceImpl() {
		suppliers = new ArrayList<Supplier>();
	}

	@Override
	public Supplier findSuppliers() {
		Supplier sup = new Supplier();
		sup.setId(5);
		sup.setName("ADR");
		return sup;
		// return CommonUtil.getSafeList(suppliers);
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		if (!suppliers.contains(supplier)) {
			suppliers.add(supplier);
		}

	}

	@Override
	public Supplier findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSupplierById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllSuppliers() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSupplierExist(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

}
