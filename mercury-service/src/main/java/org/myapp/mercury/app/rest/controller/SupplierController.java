package org.myapp.mercury.app.rest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.rest.dto.SupplierDTO;
import org.myapp.mercury.app.service.LogisticService;
import org.myapp.mercury.app.transform.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {

	public static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	LogisticService logisticService;

	private final Transformer transformer;

	public SupplierController(LogisticService logisticService, Transformer transformer) {
		this.transformer = transformer;
		this.logisticService = logisticService;
	}

	@GetMapping("/suppliers")
	public ResponseEntity<List<Supplier>> findSuppliers() {
		List<Supplier> suppliers = logisticService.findSuppliers();
		if (suppliers.isEmpty()) {
			return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
	}

	@PostMapping("/saveSupplier")
	public ResponseEntity<?> saveSupplier(@RequestBody Supplier supplier) {
		logger.info("Creating Supplier : {}", supplier);
		if (logisticService.findSupplierByName(supplier.getName()) != null) {
			logger.error("Unable to create. A Supplier with name {} already exist", supplier.getName());
			return new ResponseEntity<Supplier>(HttpStatus.CONFLICT);
		}
		logisticService.saveSupplier(supplier);
		return new ResponseEntity<>(supplier, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteSupplier/{id}")
	public ResponseEntity<Supplier> deleteSupplier(@PathVariable int id) {
		
		Optional<Supplier> supplier = logisticService.findSupplierById(id);
		if (supplier == null) {
			return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
		}
		logisticService.deleteSupplier(id);
		return new ResponseEntity<Supplier>(HttpStatus.NO_CONTENT);
	}

}