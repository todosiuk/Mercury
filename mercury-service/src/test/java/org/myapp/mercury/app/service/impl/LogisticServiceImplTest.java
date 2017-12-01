package org.myapp.mercury.app.service.impl;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;
import org.myapp.mercury.app.model.search.criteria.range.RangeCriteria;
import org.myapp.mercury.app.rest.config.MercuryConfig;
import org.myapp.mercury.app.rest.config.MercuryInitializer;
import org.myapp.mercury.app.rest.config.TestConfig;
import org.myapp.mercury.app.rest.config.WebMvcConfig;
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
@ContextConfiguration(classes=TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
public class LogisticServiceImplTest {

	@Autowired
	private LogisticService service;

	private static ExecutorService executorService;

	@BeforeClass
	public static void setup() {
		executorService = Executors.newCachedThreadPool();
	}

	@AfterClass
	public static void tearDown() {
		executorService.shutdownNow();
	}

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

		Supplier foundSuppliers = service.findSupplierById(supplier.getId());
		// assertTrue(foundSuppliers.);
		assertEquals(foundSuppliers.getId(), supplier.getId());
	}

	@Test
	public void testFindSupplierByIdNotFound() {
		Supplier suppliers = service.findSupplierById(156);
		assertNull(suppliers);
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

	@Test
	public void testFindSupplyByCarNumbetrSuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);

		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byCarNumber("AA2630CO"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertEquals(supplies.size(), 1);
	}

	@Test
	public void testFindSupplyByCarNumberNotFound() {
		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byCarNumber("CO5864IJ"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertTrue(supplies.isEmpty());
	}

	@Test
	public void testFindSupplyByDriverNameSuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);

		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byDriverName("Вася Пупкин"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertEquals(supplies.size(), 1);
		assertEquals(supplies.get(0).getDriverName(), "Вася Пупкин");
	}

	@Test
	public void testFindSupplyByDriverNameNotFound() {
		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byDriverName("Вася Перышкин"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertTrue(supplies.isEmpty());
	}

	@Test
	public void testFindSupplyByPhoneSuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);

		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byPhone("097-569-8547-85"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertEquals(supplies.size(), 1);
		assertEquals(supplies.get(0).getPhone(), "097-569-8547-85");
	}

	@Test
	public void testFindSupplyByPhoneNotFound() {
		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byPhone("+358-854-85-74"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertTrue(supplies.isEmpty());
	}

	@Test
	public void testFindSupplyByProductSuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);

		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byProduct("Ламинат"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertEquals(supplies.size(), 1);
		assertEquals(supplies.get(0).getProduct(), "Ламинат");
	}

	@Test
	public void testFindSupplyByProductNotFound() {
		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byProduct("плитка"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertTrue(supplies.isEmpty());
	}

	@Test
	public void testFindSupplyByDocumentReceivingSuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);

		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byDocumentReceiving("ORD-25648"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertEquals(supplies.size(), 1);
		assertEquals(supplies.get(0).getDocumentReceiving(), "ORD-25648");
	}

	@Test
	public void testFindSupplyByDocumentReceivingNotFound() {
		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byDocumentReceiving("РНК-4587"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertTrue(supplies.isEmpty());
	}

	@Test
	public void testFindSupplyByDepartmentSuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);

		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byDepartment("130"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertEquals(supplies.size(), 1);
		assertEquals(supplies.get(0).getDepartment(), "130");
	}

	@Test
	public void testFindSupplyByDepartmentNotFound() {
		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byDepartment("60"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertTrue(supplies.isEmpty());
	}

	@Test
	public void testFindSupplyByStorekeeperSuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);

		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byStorekeeper("Петя Пяточкин"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertEquals(supplies.size(), 1);
		assertEquals(supplies.get(0).getStorekeeper(), "Петя Пяточкин");
	}

	@Test
	public void testFindSupplyByStorekeeperNotFound() {
		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.byStorekeeper("Вася Перышкин"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertTrue(supplies.isEmpty());
	}

	@Test
	public void testFindSupplyBySupplierNameSuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = createSupply();
		supply.setSupplier(supplier);
		service.saveSupply(supplier.getId(), supply);

		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.bySupplierName("test"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertEquals(supplies.size(), 1);
		assertEquals(supplies.get(0).getSupplier().getName(), "test");
	}

	@Test
	public void testFindSupplyBySupplierNameNotFound() {
		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria.bySupplierName("nameNotFound"),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertTrue(supplies.isEmpty());
	}

	@Test
	public void testFindBetweenDateSuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		Supply supply = new Supply();
		supply.setSupplier(supplier);
		supply.setCarNumber("AA2630CO");
		supply.setDepartment("130");
		supply.setDocumentReceiving("ORD-25648");
		supply.setDriverName("Вася Пупкин");
		supply.setFirstCreated(LocalDateTime.of(2017, 10, 05, 15, 01));
		supply.setPhone("097-569-8547-85");
		supply.setProduct("Ламинат");
		supply.setStorekeeper("Петя Пяточкин");
		service.saveSupply(supplier.getId(), supply);
		Supply supply1 = new Supply();
		supply1.setSupplier(supplier);
		supply1.setCarNumber("AA2635CO");
		supply1.setDepartment("135");
		supply1.setDocumentReceiving("ORD-24548");
		supply1.setDriverName("Вася");
		supply1.setFirstCreated(LocalDateTime.of(2017, 10, 06, 15, 54));
		supply1.setPhone("097-569-8-85");
		supply1.setProduct("плитка");
		supply1.setStorekeeper("Петя");
		service.saveSupply(supplier.getId(), supply1);

		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria
				.betweenDate(LocalDateTime.of(2017, 10, 05, 15, 00), LocalDateTime.of(2017, 10, 06, 15, 55)),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertEquals(supplies.size(), 2);
	}

	@Test
	public void testFindSupplyBetweenDateNotFound() {
		List<Supply> supplies = service.findSuppliesByCriteria(SupplyCriteria
				.betweenDate(LocalDateTime.of(2017, 10, 03, 15, 00), LocalDateTime.of(2017, 10, 04, 15, 26)),
				new RangeCriteria(1, 5));
		assertNotNull(supplies);
		assertTrue(supplies.isEmpty());
	}

	@Test
	public void testFindSupplierByNameSuccess() {
		Supplier supplier = createSupplier();
		service.saveSupplier(supplier);
		List<Supplier> findedSupplier = service.findSupplierByName("test");

		assertNotNull(findedSupplier);
	}

	@Test
	public void testFindSupplierByNameNotFound() {
		List<Supplier> findedSupplier = service.findSupplierByName("test1");

		assertEquals(findedSupplier.size(), 0);
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
		supply.setDriverName("Вася Пупкин");
		supply.setFirstCreated(LocalDateTime.now());
		// supply.setId(1);
		supply.setPhone("097-569-8547-85");
		supply.setProduct("Ламинат");
		supply.setStorekeeper("Петя Пяточкин");
		return supply;
	}
}
