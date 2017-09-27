package org.myapp.mercury.app.transform.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.myapp.mercury.app.infrastructure.exception.flow.InvalidParameterException;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.rest.dto.SupplierDTO;
import org.myapp.mercury.transform.Transformer;
import org.myapp.mercury.transform.impl.DTOTransformer;

/**
 * Verifies functionality of the {@link DTOTransformer} unit
 * 
 * @author todosuk
 *
 */
public class DTOTransformerTest {
	private Transformer transformer;

	@Before
	public void setup() {
		transformer = new DTOTransformer();
	}

	@Test
	public void testTransformSupplierSuccess() {
		Supplier supplier = new Supplier();
		supplier.setId(1);
		supplier.setName("ANP");

		SupplierDTO dto = transformer.transform(supplier, SupplierDTO.class);
		assertNotNull(dto);
		assertEquals(dto.getId(), supplier.getId());
		assertEquals(dto.getName(), supplier.getName());
	}

	@Test(expected = InvalidParameterException.class)
	public void testTransformNullSupplierFailure() {
		transformer.transform(null, SupplierDTO.class);
	}

	@Test(expected = InvalidParameterException.class)
	public void testTransformNullDTOClassFailure() {
		transformer.transform(new Supplier(), null);
	}

	@Test
	public void testUnTransformSupplierSuccess() {
		SupplierDTO dto = new SupplierDTO();
		dto.setId(1);
		dto.setName("ANP");

		Supplier supplier = transformer.untransform(dto, Supplier.class);
		assertNotNull(supplier);
		assertEquals(dto.getId(), supplier.getId());
		assertEquals(dto.getName(), supplier.getName());
	}

	@Test(expected = InvalidParameterException.class)
	public void testUnTransformNullSupplierFailure() {
		transformer.untransform(null, Supplier.class);
	}

	@Test(expected = InvalidParameterException.class)
	public void testUnTransformNullEntityClassFailure() {
		transformer.untransform(new SupplierDTO(), null);
	}
}
