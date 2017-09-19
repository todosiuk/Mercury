package org.myapp.mercury.app.rest.controller;

import java.util.List;

import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.service.LogisticService;
import org.myapp.mercury.app.service.impl.LogisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class SupplierController {

	@Autowired
	LogisticService logisticService;

	@RequestMapping(value = "suppliers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Supplier>> findSuppliers() {

		List<Supplier> suppliers = logisticService.findSuppliers();
		if (suppliers.isEmpty()) {
			return new ResponseEntity<List<Supplier>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
	}
}
