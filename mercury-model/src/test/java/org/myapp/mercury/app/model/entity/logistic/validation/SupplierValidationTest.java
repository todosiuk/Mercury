package org.myapp.mercury.app.model.entity.logistic.validation;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;
import org.myapp.mercury.app.model.entity.logistic.Supplier;

public class SupplierValidationTest {

	private Validator validator;

	@Before
	public void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void nameNotNullValidationSuccess() {
		Supplier supplier = new Supplier();
		supplier.setName("Vasya");

		Set<ConstraintViolation<Supplier>> constraintViolations = validator.validate(supplier);

		assertEquals(1, constraintViolations.size());
		assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
	}
}
