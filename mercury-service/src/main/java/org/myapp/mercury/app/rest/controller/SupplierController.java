package org.myapp.mercury.app.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.rest.dto.SupplierDTO;
import org.myapp.mercury.app.service.LogisticService;
import org.myapp.mercury.app.transform.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<SupplierDTO> findSuppliers() {
		return logisticService.findSuppliers().stream()
				.map((supplier) -> transformer.transform(supplier, SupplierDTO.class)).collect(Collectors.toList());
	}

	@PostMapping("/saveSupplier")
	public void saveSupplier(SupplierDTO supplierDTO) {
		logisticService.saveSupplier(transformer.untransform(supplierDTO, Supplier.class));
	}

	public ResponseEntity deleteSupplier(@PathVariable int id) {
		return null;
		
	}

}