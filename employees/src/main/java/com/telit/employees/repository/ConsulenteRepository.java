package com.telit.employees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telit.employees.model.Consulente;

public interface ConsulenteRepository  extends JpaRepository<Consulente, Long> {

	@Query("SELECT u FROM Consulente u WHERE u.attivo = true AND u.tariffa < :tariffa AND u.oreLavorate < :oreLavorate")
	List<Consulente> findByTariffaAndOreLavorate(Double tariffa, Integer oreLavorate);

}
