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
	public void nameIsValid() {
		Supplier supplier = new Supplier();
		supplier.setName("Vasya");

		Set<ConstraintViolation<Supplier>> constraintViolations = validator.validate(supplier);

		assertEquals(0, constraintViolations.size());
	}

	@Test
	public void nameTooShort() {
		Supplier supplier = new Supplier();
		supplier.setName("Va");

		Set<ConstraintViolation<Supplier>> constraintViolations = validator.validate(supplier);

		assertEquals(1, constraintViolations.size());
		assertEquals("size must be between 3 and 32", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void nameTooLong() {
		Supplier supplier = new Supplier();
		supplier.setName("Vakjhuyjgnhjhfnrythgujnfhyrewqhgtdb");// 35 symbols

		Set<ConstraintViolation<Supplier>> constraintViolations = validator.validate(supplier);

		assertEquals(1, constraintViolations.size());
		assertEquals("size must be between 3 and 32", constraintViolations.iterator().next().getMessage());

	}
}
