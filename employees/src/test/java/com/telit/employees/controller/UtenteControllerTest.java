package com.telit.employees.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telit.employees.model.Utente;
import com.telit.employees.repository.UtenteRepository;

@WebMvcTest(UtenteController.class)
public class UtenteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UtenteRepository utenteRepo;

	@Test
	public void getAllUtenteTest() throws Exception {
		List<Utente> utentiList = new ArrayList<Utente>();
		utentiList.add(new Utente("nome", "cognome", "tipo1", "pw"));
		when(utenteRepo.findAll()).thenReturn(utentiList);

		MvcResult result = mockMvc.perform(get("/utente/")).andDo(print()).andExpect(status().isOk()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("nome"));
	}

	@Test
	public void createUtenteTest() throws Exception {
		Utente utente = new Utente("nome", "cognome", "tipo1", "pw");
		when(utenteRepo.save(Mockito.any(Utente.class))).thenReturn(utente);

		MvcResult result = mockMvc
				.perform(post("/utente/").content(asJsonString(utente)).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isCreated()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("nome"));
	}

	@Test
	public void updateUtenteTest() throws Exception {
		Utente utente = new Utente("nome", "cognome", "tipo1", "pw");
		when(utenteRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(utente));
		when(utenteRepo.save(Mockito.any(Utente.class))).thenReturn(utente);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/utente/{id}", 1).content(asJsonString(utente))
				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("nome"));
	}

	@Test
	public void deleteUtenteTest() throws Exception {
		Mockito.doNothing().when(utenteRepo).deleteById(Mockito.anyLong());
		Mockito.doNothing().when(utenteRepo).deleteByNomeAndCognome(Mockito.nullable(String.class),
				Mockito.nullable(String.class));

		mockMvc.perform(MockMvcRequestBuilders.delete("/utente/{id}", 1)).andDo(print()).andExpect(status().isOk());

		mockMvc.perform(MockMvcRequestBuilders.delete("/utente/deleteByNomeAndCognome").param("nome", "nome")
				.param("cognome", "cognome")).andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void findUtentiTest() throws Exception {
		Utente utente = new Utente("nome", "cognome", "tipo1", "pw");
		List<Utente> utentiList = new ArrayList<Utente>();
		utentiList.add(utente);

		when(utenteRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(utente));
		when(utenteRepo.findUtentiByTipo(Mockito.anyString())).thenReturn(utentiList);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/utente/{id}", 1)).andDo(print())
				.andExpect(status().isOk()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("nome"));

		result = mockMvc.perform(MockMvcRequestBuilders.get("/utente/ricercaPerTipo").param("tipo", "tipo1"))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("nome"));

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
