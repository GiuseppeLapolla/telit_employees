package com.telit.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telit.employees.model.Ingegnere;

public interface IngegnereRepository  extends JpaRepository<Ingegnere, Long> {

}
