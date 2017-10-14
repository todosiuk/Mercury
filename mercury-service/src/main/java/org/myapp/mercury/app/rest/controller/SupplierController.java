package org.myapp.mercury.app.rest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.rest.dto.SupplierDTO;
import org.myapp.mercury.app.service.LogisticService;
import org.myapp.mercury.app.transform.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {

	@Autowired
	LogisticService logisticService;

	private final Transformer transformer;

	public SupplierController(LogisticService logisticService, Transformer transformer) {
		this.transformer = transformer;
		this.logisticService = logisticService;
	}

	@GetMapping("/suppliers")
	public ResponseEntity<List<SupplierDTO>> findSuppliers() {
		List<SupplierDTO> suppliers = logisticService.findSuppliers().stream()
				.map((supplier) -> transformer.transform(supplier, SupplierDTO.class)).collect(Collectors.toList());
		if (suppliers.isEmpty()) {
			return new ResponseEntity<List<SupplierDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<SupplierDTO>>(suppliers, HttpStatus.OK);
	}

	@PostMapping("/saveSupplier")
	public ResponseEntity<Void> saveSupplier(SupplierDTO supplierDTO) {
		Optional<List<Supplier>> supplier = logisticService.findSupplierByName(supplierDTO.getName());
		if (supplier.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		logisticService.saveSupplier(transformer.untransform(supplierDTO, Supplier.class));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
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