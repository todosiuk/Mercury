package org.myapp.mercury.app.rest.dto;

import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.rest.dto.base.BaseDTO;

public class SupplierDTO extends BaseDTO<Supplier> {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
