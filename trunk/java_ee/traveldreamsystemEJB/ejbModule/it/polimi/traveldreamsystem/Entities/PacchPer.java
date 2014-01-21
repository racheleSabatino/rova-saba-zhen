package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the PacchPer database table.
 * 
 */
@Entity
@Table(name="pacchper")
@NamedQuery(name="PacchPer.findAll", query="SELECT p FROM PacchPer p")
public class PacchPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDPACCHPER", unique=true, nullable=false)
	private int idpacchper;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DataAcquisto", nullable=false)
	private Date dataAcquisto;

	@Column(name="IDPRODBASE", nullable=false)
	private int idprodbase;

	@Column(name="ListaRegali", nullable=false, length=45)
	private boolean listaRegali;

	//bi-directional many-to-one association to PacchPred
	@ManyToOne
	@JoinColumn(name="idPacchPred", nullable=false)
	private PacchPred pacchPred;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="Clienti", nullable=false)
	private Utente utente;

	public PacchPer() {
	}
	
	public PacchPer(PacchPerDTO pacchettoDTO) {
		this.dataAcquisto = pacchettoDTO.getDataAcquisto();
		this.idpacchper = pacchettoDTO.getIdpacchper();
		this.idprodbase = pacchettoDTO.getIdprodbase();
		this.listaRegali = pacchettoDTO.getListaRegali();
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

	public boolean getListaRegali() {
		return this.listaRegali;
	}

	public void setListaRegali(boolean listaRegali) {
		this.listaRegali = listaRegali;
	}

	public PacchPred getPacchPred() {
		return this.pacchPred;
	}

	public void setPacchPred(PacchPred pacchPred) {
		this.pacchPred = pacchPred;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}