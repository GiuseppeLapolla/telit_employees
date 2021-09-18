package com.telit.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telit.employees.model.Consulente;
import com.telit.employees.model.Utente;
import com.telit.employees.repository.ConsulenteRepository;

@RestController
@RequestMapping("/consulente")
public class ConsulenteController {

	@Autowired
	ConsulenteRepository consulenteRepo;
	
	@GetMapping("/")
	public ResponseEntity<List<Consulente>> getAllConsulente() {
		List<Consulente> consulenteData = consulenteRepo.findAll();
		
		if (consulenteData.size() > 0) {
			return new ResponseEntity<>(consulenteData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/findByTariffaAndOreLavorate")
	public ResponseEntity<List<Consulente>> findByTariffaAndOreLavorate(
			@RequestParam Double tariffa, 
			@RequestParam Integer oreLavorate) {
		List<Consulente> consulentiList = consulenteRepo.findByTariffaAndOreLavorate(tariffa, oreLavorate);
		
		return new ResponseEntity<>(consulentiList, HttpStatus.OK);
	}
	
}
