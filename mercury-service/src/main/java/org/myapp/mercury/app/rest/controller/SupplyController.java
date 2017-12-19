package org.myapp.mercury.app.rest.controller;

import java.util.List;
import java.util.Optional;

import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;
import org.myapp.mercury.app.model.search.criteria.range.RangeCriteria;
import org.myapp.mercury.app.service.LogisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplyController {

	public static final Logger logger = LoggerFactory.getLogger(SupplyController.class);

	@Autowired
	LogisticService logisticService;

	public SupplyController(LogisticService logisticService) {
		this.logisticService = logisticService;
	}

	// -------------------Create a Supply-----------------------------

	@RequestMapping(value = "/saveSupply/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> createSupply(@PathVariable long id, Supply supply) {
		logger.info("Creating Supply : {}", supply);
		Supplier supplier = logisticService.findSupplierById(id);
		if (supplier == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		supply.setSupplier(supplier);
		logisticService.saveSupplier(supplier);
		return new ResponseEntity<>(supply, HttpStatus.CREATED);
	}

	// ----------------------Find supply by criteria-------------------

	@RequestMapping(value = "/searchSupply", method = RequestMethod.POST)
	public ResponseEntity<?> findSupply(SupplyCriteria criteria, RangeCriteria rangeCriteria) {
		logger.info("Finding supply by criteria : {}", criteria);

		/*
		 * if criteria == null search all supplies
		 */
		if (criteria == null) {
			List<Supply> supply = logisticService.findAllSupplies();
			return new ResponseEntity<>(supply, HttpStatus.OK);
		}
		List<Supply> searchedSupply = logisticService.findSuppliesByCriteria(criteria, rangeCriteria);
		return new ResponseEntity<>(searchedSupply, HttpStatus.FOUND);
	}

	// ---------------------Update supply----------------------------------

	@RequestMapping(value = "/updateSupply/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateSupply(@PathVariable long id, Supply supply) {
		logger.info("Updating supply with id : {}", id);

		Supply currentSupply = logisticService.findSupplyById(id);
		if (currentSupply == null) {
			logger.error("Supply with id {} not found", id);
			return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
		}
		currentSupply.setCarNumber(supply.getCarNumber());
		currentSupply.setCreatedBy(supply.getCreatedBy());
		currentSupply.setDepartment(supply.getDepartment());
		currentSupply.setDocumentReceiving(supply.getDocumentReceiving());
		currentSupply.setDriverName(supply.getDriverName());
		currentSupply.setFirstCreated(supply.getFirstCreated());
		currentSupply.setLastModified(supply.getLastModified());
		currentSupply.setModifiedBy(supply.getModifiedBy());
		currentSupply.setPhone(supply.getPhone());
		currentSupply.setProduct(supply.getProduct());
		currentSupply.setStorekeeper(supply.getStorekeeper());
		currentSupply.setSupplier(supply.getSupplier());

		logisticService.updateSupply(currentSupply);

		return new ResponseEntity<Supply>(currentSupply, HttpStatus.OK);
	}
}
