package com.telit.employees.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telit.employees.model.Utente;
import com.telit.employees.repository.UtenteRepository;

@RestController
@RequestMapping("/utente")
public class UtenteController {
	
	@Autowired
	UtenteRepository utenteRepo;
	
	@PostMapping("/")
	public ResponseEntity<Utente> createUtente(@RequestBody Utente utente) {
		try {
			Utente _utente = utenteRepo.save(utente);
			return new ResponseEntity<>(_utente, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Utente> updateUtente(
			@PathVariable("id") Long id, 
			@RequestBody Utente utente) {
		Optional<Utente> utenteData = utenteRepo.findById(id);
		
		if (utenteData.isPresent()) {
			
			Utente _utente = utenteData.get();
			_utente.setAttivo(utente.getAttivo());
			_utente.setCognome(utente.getCognome());
			_utente.setNome(utente.getNome());
			_utente.setIndirizzo(utente.getIndirizzo());

			return new ResponseEntity<>(utenteRepo.save(_utente), HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Utente> deleteUtenteById(@PathVariable("id") Long id) {
		try {
			utenteRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteByNomeAndCognome")
	public ResponseEntity<Utente> deleteUtenteByNomeAndCognome(
			@RequestParam("nome") String nome,
			@RequestParam("cognome") String cognome) {
		try {
			utenteRepo.deleteByNomeAndCognome(nome, cognome);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Utente>> getAllUtente() {
		List<Utente> utenteData = utenteRepo.findAll();
		
		if (utenteData.size() > 0) {
			return new ResponseEntity<>(utenteData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Utente> findUtenteById(@PathVariable("id") Long id) {
		Optional<? extends Utente> employeeData = utenteRepo.findById(id);
		
		if (employeeData.isPresent()) {
			return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/ricercaPerTipo")
	public ResponseEntity<List<Utente>> findUtentiByTipo(@RequestParam String tipo) {
		try {
			List<Utente> utentiList = utenteRepo.findUtentiByTipo(tipo);
			
			if (utentiList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(utentiList, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
