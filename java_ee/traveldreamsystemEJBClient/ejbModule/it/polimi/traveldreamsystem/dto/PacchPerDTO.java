package it.polimi.traveldreamsystem.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

public class PacchPerDTO {

	private int idpacchper;

	@Temporal(TemporalType.TIMESTAMP)
	@NotEmpty
	private Date dataAcquisto;

	@NotEmpty
	private int idprodbase;

	@NotEmpty
	private String listaRegali;

	@NotEmpty
	private PacchPredDTO pacchPred;

	@NotEmpty
	private ProdBaseDTO prodBase;

	@NotEmpty
	private UtenteDTO utente;

	public PacchPerDTO() {
	}

	public int getIdpacchper() {
		return this.idpacchper;
	}

	public void setIdpacchper(int idpacchper) {
		this.idpacchper = idpacchper;
	}

	public Date getDataAcquisto() {
		return this.dataAcquisto;
	}

	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public int getIdprodbase() {
		return this.idprodbase;
	}

	public void setIdprodbase(int idprodbase) {
		this.idprodbase = idprodbase;
	}

	public String getListaRegali() {
		return this.listaRegali;
	}

	public void setListaRegali(String listaRegali) {
		this.listaRegali = listaRegali;
	}

	public PacchPredDTO getPacchPred() {
		return this.pacchPred;
	}

	public void setPacchPred(PacchPredDTO pacchPred) {
		this.pacchPred = pacchPred;
	}

	public ProdBaseDTO getProdBase() {
		return this.prodBase;
	}

	public void setProdBase(ProdBaseDTO prodBase) {
		this.prodBase = prodBase;
	}

	public UtenteDTO getUtente() {
		return this.utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

}
