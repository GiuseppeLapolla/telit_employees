package com.telit.employees.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telit.employees.model.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

	//@Query("SELECT u FROM Utente u WHERE u.tipo = :tipo")
	//List<Utente> findUtentiByTipo(@Param(value = "tipo") String tipo);
	
	List<Utente> findUtentiByTipo(String tipo);

	//@Query("DELETE FROM Utente u WHERE u.nome= :nome AND u.cognome= :cognome")
	@Transactional
	void deleteByNomeAndCognome(@Param(value = "nome") String nome, @Param(value = "cognome") String cognome);
	

}
