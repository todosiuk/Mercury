package org.myapp.mercury.app.service.impl;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.rest.config.MercuryConfig;
import org.myapp.mercury.app.rest.config.MercuryInitializer;
import org.myapp.mercury.app.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Contain unit- tests for {@link LogisticServiceImpl}
 * 
 * @author todosuk
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { MercuryConfig.class,
		MercuryInitializer.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class LogisticServiceImplTest {

	@Autowired
	private LogisticService service;

	@Test
	public void testNoDataReturnedAtStart() {
		List<Supplier> suppliers = service.findSuppliers();
		assertTrue(suppliers.isEmpty());
	}

	@Test
	public void testSaveNewSupplierSuccess() {
		Supplier supplier = new Supplier();
		supplier.setName("ANP");
		supplier.setFirstCreated(LocalDateTime.now());
		service.saveSupplier(supplier);

		List<Supplier> suppliers = service.findSuppliers();
		assertEquals(suppliers.size(), 1);
		assertEquals(suppliers.get(0).getName(), "ANP");
	}

	@Test
	public void testFindSupplierByIdSuccess() {
		Supplier supplier = new Supplier();
		supplier.setName("ANP");
		supplier.setFirstCreated(LocalDateTime.now());
		service.saveSupplier(supplier);

		Optional<Supplier> foundSuppliers = service.findSupplierById(supplier.getId());
		assertTrue(foundSuppliers.isPresent());
		assertEquals(foundSuppliers.get().getId(), supplier.getId());
	}

	@Test
	public void testFindSupplierByIdNotFound() {
		Optional<Supplier> suppliers = service.findSupplierById(156);
		assertFalse(suppliers.isPresent());
	}

	@Test
	public void testDeleteSupplier() {
		Supplier supplier = new Supplier();
		supplier.setFirstCreated(LocalDateTime.now());
		supplier.setName("ANP");
		service.saveSupplier(supplier);

		service.deleteSupplier(supplier.getId());
		List<Supplier> suppliers = service.findSuppliers();
		assertEquals(suppliers.size(), 0);
	}

	@Test
	public void testUpdateSupplier() {
		Supplier supplier = new Supplier();
		supplier.setFirstCreated(LocalDateTime.now());
		supplier.setName("ANP");
		service.saveSupplier(supplier);

		supplier.setName("OPQ");
		service.updateSupplier(supplier);

		assertEquals(supplier.getName(), "OPQ");
	}

	@Test
	public void testFindAllSuppliers() {
		Supplier supplier = new Supplier();
		supplier.setFirstCreated(LocalDateTime.now());
		supplier.setName("ANP");
		service.saveSupplier(supplier);
		Supplier supplier1 = new Supplier();
		supplier1.setFirstCreated(LocalDateTime.now());
		supplier1.setName("OPQ");
		service.saveSupplier(supplier1);

		List<Supplier> suppliers = service.findSuppliers();
		assertEquals(suppliers.size(), 2);
	}

	@Test
	public void testSaveNewSupplySuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);

		List<Supply> supplies = service.findAllSupplies();
		assertEquals(supplies.size(), 1);
	}

	@Test
	public void testDeleteSupply() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);

		service.deleteSupply(supply.getId());
		List<Supply> supplies = service.findAllSupplies();
		assertEquals(supplies.size(), 0);
	}

	@Test
	public void testUpdateSupply() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);
		supply.setCarNumber("HG8958KI");
		service.updateSupply(supply);

		List<Supply> supplies = service.findAllSupplies();
		assertEquals(supplies.get(0).getCarNumber(), "HG8958KI");
	}

	private Supplier createSupplier() {
		Supplier supplier = new Supplier();
		supplier.setFirstCreated(LocalDateTime.now());
		// supplier.setId(1);
		supplier.setName("test");
		return supplier;
	}

	private Supply createSupply() {
		Supply supply = new Supply();
		supply.setCarNumber("AA2630CO");
		supply.setDepartment("130");
		supply.setDocumentReceiving("ORD-25648");
		supply.setDriverName(" Вася Пупкин");
		supply.setFirstCreated(LocalDateTime.now());
		// supply.setId(1);
		supply.setPhone("097-569-8547-85");
		supply.setProduct("Ламинат");
		supply.setStorekeeper("Петя Пяточкин");
		return supply;
	}
}
