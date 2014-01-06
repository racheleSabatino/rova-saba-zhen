package it.polimi.traveldreamsystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the personalizz database table.
 * 
 */
@Entity
@NamedQuery(name="Personalizz.findAll", query="SELECT p FROM Personalizz p")
public class Personalizz implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonalizzPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAcquisto;

	private byte listaRegali;

	//bi-directional many-to-one association to Prodbase
	@ManyToOne
	@JoinColumn(name="prodBaseID")
	private Prodbase prodbase;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="cliente")
	private Utente utente;

	//bi-directional many-to-one association to Pacchpred
	@ManyToOne
	@JoinColumn(name="pacchPredID")
	private Pacchpred pacchpred;

	public Personalizz() {
	}

	public PersonalizzPK getId() {
		return this.id;
	}

	public void setId(PersonalizzPK id) {
		this.id = id;
	}

	public Date getDataAcquisto() {
		return this.dataAcquisto;
	}

	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public byte getListaRegali() {
		return this.listaRegali;
	}

	public void setListaRegali(byte listaRegali) {
		this.listaRegali = listaRegali;
	}

	public Prodbase getProdbase() {
		return this.prodbase;
	}

	public void setProdbase(Prodbase prodbase) {
		this.prodbase = prodbase;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Pacchpred getPacchpred() {
		return this.pacchpred;
	}

	public void setPacchpred(Pacchpred pacchpred) {
		this.pacchpred = pacchpred;
	}

}