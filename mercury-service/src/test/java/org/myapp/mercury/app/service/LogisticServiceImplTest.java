package org.myapp.mercury.app.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.rest.config.MercuryConfig;
import org.myapp.mercury.app.rest.config.MercuryInitializer;
import org.myapp.mercury.app.service.impl.LogisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

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
public class LogisticServiceImplTest {

	@Autowired
	private LogisticServiceImpl service;

	@Test
	public void testNoDataReturnedAtStart() {
		List<Supplier> cities = service.findSuppliers();
		assertTrue(cities.isEmpty());
	}
}
