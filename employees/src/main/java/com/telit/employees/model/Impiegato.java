package com.telit.employees.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "impiegato")
public class Impiegato extends Utente {
	@JsonIgnore
	@Column(name = "codice_fiscale")
	private String codiceFiscale;
	
	@Column(name = "info_contributi_versati")
	private String infoContributiVersati;
	
	public Impiegato() {
		super();
	}
	
	public Impiegato(String nome, String cognome, String tipo, String password) {
		super(nome, cognome, tipo, password);
	}
	
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getInfoContributiVersati() {
		return infoContributiVersati;
	}
	public void setInfoContributiVersati(String infoContributiVersati) {
		this.infoContributiVersati = infoContributiVersati;
	}
	
	
}
