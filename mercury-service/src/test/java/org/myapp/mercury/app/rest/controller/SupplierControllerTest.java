package org.myapp.mercury.app.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.rest.config.MercuryConfig;
import org.myapp.mercury.app.rest.config.MercuryInitializer;
import org.myapp.mercury.app.service.LogisticService;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { MercuryConfig.class,
		MercuryInitializer.class }, loader = AnnotationConfigContextLoader.class)
public class SupplierControllerTest {

	private MockMvc mockMvc;

	@Mock
	LogisticService logisticService;

	@InjectMocks
	private SupplierController supplierController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(supplierController).build();
	}

	@Test
	public void testGetAllSuppliers() throws Exception {
		List<Supplier> suppliers = logisticService.findSuppliers();
		when(logisticService.findSuppliers()).thenReturn(suppliers);
		mockMvc.perform(get("/suppliers").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void testSaveSupplier() throws Exception {
		Supplier supplier = new Supplier();
		supplier.setFirstCreated(LocalDateTime.now());
		supplier.setId(1);
		supplier.setName("test");
		logisticService.saveSupplier(supplier);

		Mockito.verify(logisticService).saveSupplier(supplier);

		mockMvc.perform(post("/saveSupplier")).andExpect(status().isCreated());
	}

}
