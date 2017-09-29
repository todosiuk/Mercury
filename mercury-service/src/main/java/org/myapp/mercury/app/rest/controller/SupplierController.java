/**package org.myapp.mercury.app.rest.controller;

import java.util.List;

import org.myapp.mercury.app.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class SupplierController {

	@Autowired
	LogisticService logisticService;

	@RequestMapping(value = "/suppliers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> findSuppliers() {
		return null;
	}
}*/