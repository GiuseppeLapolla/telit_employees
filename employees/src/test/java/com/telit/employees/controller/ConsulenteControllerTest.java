package com.telit.employees.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.telit.employees.model.Consulente;
import com.telit.employees.repository.ConsulenteRepository;

@WebMvcTest(ConsulenteController.class)
public class ConsulenteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ConsulenteRepository consulenteRepo;

	@Test
	public void getAllConsulenteTest() throws Exception {
		List<Consulente> consulenteList = new ArrayList<Consulente>();
		consulenteList.add(new Consulente("nome", "cognome", "tipo1", "pw", 4000d, 300));
		when(consulenteRepo.findAll())
				.thenReturn(consulenteList);

		MvcResult result = mockMvc
				.perform(get("/consulente/"))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("nome"));
	}

	
	@Test
	public void findByTariffaAndOreLavorateTest() throws Exception {
		List<Consulente> consulenteList = new ArrayList<Consulente>();
		consulenteList.add(new Consulente("nome", "cognome", "tipo1", "pw", 4000d, 300));
		when(consulenteRepo.findByTariffaAndOreLavorate(Mockito.anyDouble(), Mockito.anyInt()))
				.thenReturn(consulenteList);

		MvcResult result = mockMvc
				.perform(get("/consulente/findByTariffaAndOreLavorate").param("tariffa", "1").param("oreLavorate", "1"))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("nome"));
	}

}
