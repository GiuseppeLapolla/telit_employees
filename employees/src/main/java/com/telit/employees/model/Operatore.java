package com.telit.employees.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operatore")
public class Operatore extends Utente {
	@Column(name = "ore_lavorate")
	private int oreLavorate;
	
	@Column(name = "data_scadenza_contratto")
	private Date dataScadenzaContratto;
	
	public Operatore() {
		super();
	}
	
	public Operatore(String nome, String cognome, String tipo, String password) {
		super(nome, cognome, tipo, password);
	}
	
	public int getOreLavorate() {
		return oreLavorate;
	}
	public void setOreLavorate(int oreLavorate) {
		this.oreLavorate = oreLavorate;
	}
	public Date getDataScadenzaContratto() {
		return dataScadenzaContratto;
	}
	public void setDataScadenzaContratto(Date dataScadenzaContratto) {
		this.dataScadenzaContratto = dataScadenzaContratto;
	}
	
}
