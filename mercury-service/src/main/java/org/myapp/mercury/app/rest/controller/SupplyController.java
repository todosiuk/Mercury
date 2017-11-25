package org.myapp.mercury.app.rest.controller;

import org.myapp.mercury.app.model.entity.logistic.Supply;
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
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ResponseEntity<?> createSupply(@PathVariable long idSupplier, Supply supply) {
		logger.info("Creating Supply : {}", supply);
		logisticService.saveSupply(idSupplier, supply);
		return new ResponseEntity<>(supply, HttpStatus.CREATED);
	}
}
