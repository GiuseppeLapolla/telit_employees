package com.telit.employees.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operatore")
public class Ingegnere extends Utente {
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "ruolo")
	private String ruolo;
	
	@Column(name = "seniority")
	private String seniority;
	
	public Ingegnere() {
		super();
	}
	
	public Ingegnere(String nome, String cognome, String tipo, String password) {
		super(nome, cognome, tipo, password);
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getSeniority() {
		return seniority;
	}
	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}
	
	

}
