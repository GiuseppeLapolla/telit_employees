package com.telit.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telit.employees.model.Impiegato;

public interface ImpiegatoRepository  extends JpaRepository<Impiegato, Long> {

}
