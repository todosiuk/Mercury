package org.myapp.mercury.app.persistence.repository.impl;

import java.util.List;

import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;
import org.myapp.mercury.app.persistence.repository.SupplyRepository;

public class SupplyRepositoryImpl implements SupplyRepository {

	@Override
	public void save(int supplierId, Supply supply) {
		// TODO Auto-generated method stub

	}

	@Override
	public Supply findById(int supplyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int supplyId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSupply(Supply supply) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Supply> findAllByCriteria(SupplyCriteria supplyCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
