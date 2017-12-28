package org.myapp.mercury.app.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static java.util.Arrays.asList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.search.criteria.SupplyCriteria;
import org.myapp.mercury.app.model.search.criteria.range.RangeCriteria;
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
public class SupplyControllerTest {

	SupplyCriteria criteria = new SupplyCriteria(null);
	RangeCriteria rangeCriteria = new RangeCriteria(1, 3);

	private MockMvc mockMvc;

	@Mock
	LogisticService logisticService;

	@InjectMocks
	private SupplyController supplyController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(supplyController).build();
	}

	@Test
	public void testSaveSupplyNotFound() throws Exception {
		when(logisticService.findSupplierById(1)).thenReturn(null);
		mockMvc.perform(post("/saveSupply/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
	}

	@Test
	public void testSaveSupplySuccess() throws Exception {
		when(logisticService.findSupplierById(1)).thenReturn(new Supplier());
		mockMvc.perform(post("/saveSupply/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	public void testFindSupplySuccess() throws Exception {
		List<Supply> list = asList(new Supply());
		when(logisticService.findSuppliesByCriteria(criteria, rangeCriteria)).thenReturn(list);
		mockMvc.perform(post("/searchSupply").accept(MediaType.APPLICATION_JSON)).andExpect(status().isFound());
	}

	@Test
	public void testUpdateSupplyNotExist() throws Exception {
		when(logisticService.findSupplyById(1)).thenReturn(null);
		mockMvc.perform(put("/updateSupply/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
	}
	
	@Test
	public void testUpdateSupplySuccess() {
		when(logisticService.findSupplyById(1)).thenReturn(new Supply());
		
	}
}
