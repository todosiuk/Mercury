package org.myapp.mercury.app.rest.controller;

import java.util.List;

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

	@RequestMapping(value = "/searchSupply", method = RequestMethod.POST)
	public ResponseEntity<?> findSupply(SupplyCriteria criteria, RangeCriteria rangeCriteria) {
		logger.info("Finding supply by criteria : {}", criteria);
		if (criteria == null) {
			List<Supply> supplyes = logisticService.findAllSupplies();
			return new ResponseEntity<>(supplyes, HttpStatus.OK);
		}
		List<Supply> searchedSupply = logisticService.findSuppliesByCriteria(criteria, rangeCriteria);
		return new ResponseEntity<>(searchedSupply, HttpStatus.FOUND);
	}
}
