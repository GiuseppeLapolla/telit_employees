package com.telit.employees.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "consulente")
public class Consulente extends Utente {
	
	@Column(name = "tariffa")
	private Double tariffa;
	
	@Column(name = "ore_lavorate")
	private Integer oreLavorate;
	
	@Column(name = "data_scadenza_contratto")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataScadenzaContratto;
	
	@Column(name = "info_sul_service_level_agreement")
	private String infoSulServiceLevelAgreement;
	
	public Consulente() {
		super();
	}
	
	public Consulente(String nome, String cognome, String tipo, String password, Double tariffa, Integer oreLavorate) {
		super(nome, cognome, tipo, password);
		this.tariffa = tariffa;
		this.oreLavorate = oreLavorate;
	}
	
	public Double getTariffa() {
		return tariffa;
	}
	public void setTariffa(Double tariffa) {
		this.tariffa = tariffa;
	}
	public Integer getOreLavorate() {
		return oreLavorate;
	}
	public void setOreLavorate(Integer oreLavorate) {
		this.oreLavorate = oreLavorate;
	}
	public Date getDataScadenzaContratto() {
		return dataScadenzaContratto;
	}
	public void setDataScadenzaContratto(Date dataScadenzaContratto) {
		this.dataScadenzaContratto = dataScadenzaContratto;
	}
	public String getInfoSulServiceLevelAgreement() {
		return infoSulServiceLevelAgreement;
	}
	public void setInfoSulServiceLevelAgreement(String infoSulServiceLevelAgreement) {
		this.infoSulServiceLevelAgreement = infoSulServiceLevelAgreement;
	}
	


}
