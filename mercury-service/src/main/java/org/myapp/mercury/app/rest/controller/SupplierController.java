package org.myapp.mercury.app.rest.controller;

import java.util.List;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.service.LogisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {

	public static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	LogisticService logisticService;

	public SupplierController(LogisticService logisticService) {
		this.logisticService = logisticService;
	}

	// -------------------Retrieve All Suppliers------------------------

	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public ResponseEntity<List<Supplier>> findSuppliers() {
		List<Supplier> suppliers = logisticService.findSuppliers();
		if (suppliers.isEmpty()) {
			return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
	}

	// -------------------Create a Supplier-----------------------------

	@RequestMapping(value = "/saveSupplier", method = RequestMethod.POST)
	public ResponseEntity<?> saveSupplier(Supplier supplier) {

		logger.info("Creating Supplier : {}", supplier);
		if (logisticService.findSupplierByName(supplier.getName()) != null) {
			logger.error("Unable to create. A Supplier with name {} already exist", supplier.getName());
			return new ResponseEntity<Supplier>(HttpStatus.CONFLICT);
		}
		logisticService.saveSupplier(supplier);
		return new ResponseEntity<>(supplier, HttpStatus.CREATED);
	}

	// -------------------Delete a Supplier--------------------------

	@RequestMapping(value = "/deleteSupplier/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Supplier> deleteSupplier(@PathVariable long id) {

		logger.info("Fetching & Deleting Supplier with id {}", id);
		Supplier supplier = logisticService.findSupplierById(id);
		if (supplier == null) {
			logger.error("Unable to delete. Supplier with id {} not found.", id);
			return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
		}
		logisticService.deleteSupplier(id);
		return new ResponseEntity<Supplier>(HttpStatus.NO_CONTENT);
	}

	// -------------------Retrieve Single Supplier-----------------------

	@RequestMapping(value = "/findSupplierById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findSupplierById(@PathVariable long id) {

		logger.info("Finding Supplier with id {}", id);
		Supplier supplier = logisticService.findSupplierById(id);
		if (supplier == null) {
			logger.error("Supplier with id {} not found", id);
			return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Supplier>(HttpStatus.OK);
	}

	// -------------------Update a Supplier-----------------------

	@RequestMapping(value = "/updateSupplier/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Supplier> updateSupplier(@PathVariable long id, Supplier supplier) {

		logger.info("Updating Supplier with id{}", id);
		Supplier currentSupplier = logisticService.findSupplierById(id);
		if (currentSupplier == null) {
			logger.error("Supplier with id {} not found", id);
			return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
		}
		currentSupplier.setName(supplier.getName());
		logisticService.updateSupplier(currentSupplier);
		return new ResponseEntity<Supplier>(currentSupplier, HttpStatus.OK);
	}

}