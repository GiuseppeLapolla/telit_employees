package com.telit.employees.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.telit.employees.model.Consulente;
import com.telit.employees.model.Utente;
import com.telit.employees.repository.ConsulenteRepository;
import com.telit.employees.repository.ImpiegatoRepository;
import com.telit.employees.repository.IngegnereRepository;
import com.telit.employees.repository.OperatoreRepository;
import com.telit.employees.repository.UtenteRepository;

@Component
public class EmployeesDbInitRunner implements CommandLineRunner {

	@Autowired
	UtenteRepository utenteRepo;

	@Autowired
	ConsulenteRepository consulenteRepo;

	@Override
	public void run(String... args) throws Exception {
		
		// Clear DB
		utenteRepo.deleteAll();
		consulenteRepo.deleteAll();
		
		// save a couple of Employees
		utenteRepo.save(new Utente("nomeUtente", "cognomeUtente", "tipo1", "pw"));
		utenteRepo.save(new Utente("nomeUtente", "cognomeUtente", "tipo2", "pw"));
		
		Consulente notActiveconsulente = new Consulente("nomeConsulente", "cognomeConsulente", "tipo1", "pw", 4999d, 299);
		notActiveconsulente.setAttivo(false);
		consulenteRepo.save(notActiveconsulente);
		
		consulenteRepo.save(new Consulente("nomeConsulente", "cognomeConsulente", "tipo1", "pw", 4999d, 299));
		consulenteRepo.save(new Consulente("nomeConsulente", "cognomeConsulente", "tipo1", "pw", 5000d, 300));
		consulenteRepo.save(new Consulente("nomeConsulente", "cognomeConsulente", "tipo1", "pw", 5000d, 299));
		consulenteRepo.save(new Consulente("nomeConsulente", "cognomeConsulente", "tipo1", "pw", 4999d, 300));
	}

}
