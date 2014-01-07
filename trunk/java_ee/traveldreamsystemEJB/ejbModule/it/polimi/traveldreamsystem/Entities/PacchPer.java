package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PacchPer database table.
 * 
 */
@Entity
@Table(name="PacchPer")
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
	private String listaRegali;

	//bi-directional many-to-one association to PacchPred
	@ManyToOne
	@JoinColumn(name="idPacchPred", nullable=false)
	private PacchPred pacchPred;

	//bi-directional one-to-one association to ProdBase
	@OneToOne
	@JoinColumn(name="IDPACCHPER", nullable=false, insertable=false, updatable=false)
	private ProdBase prodBase;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="Clienti", nullable=false)
	private Utente utente;

	public PacchPer() {
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

	public PacchPred getPacchPred() {
		return this.pacchPred;
	}

	public void setPacchPred(PacchPred pacchPred) {
		this.pacchPred = pacchPred;
	}

	public ProdBase getProdBase() {
		return this.prodBase;
	}

	public void setProdBase(ProdBase prodBase) {
		this.prodBase = prodBase;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}