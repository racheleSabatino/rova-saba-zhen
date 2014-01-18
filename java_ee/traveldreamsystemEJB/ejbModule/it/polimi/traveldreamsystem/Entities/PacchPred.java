package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.PacchPredDTO;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the PacchPred database table.
 * 
 */
@Entity
@Table(name="pacchpred")
@NamedQuery(name="PacchPred.findAll", query="SELECT p FROM PacchPred p")
public class PacchPred implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDPACCHPRED", unique=true, nullable=false)
	private int idPacchPred;

	@Lob
	@Column(name="DESCRIZIONE")
	private String descrizione;

	//bi-directional many-to-one association to PacchPer
	@OneToMany(mappedBy="pacchPred")
	private List<PacchPer> pacchPers;

	//bi-directional many-to-many association to ProdBase
	@ManyToMany(mappedBy="pacchPred")
	private List<ProdBase> prodBases;

	public PacchPred(PacchPredDTO pacchetto) {
		this.descrizione = pacchetto.getDescrizione();
		this.idPacchPred = pacchetto.getIdPacchPred();
		
	}

	public int getIdPacchPred() {
		return this.idPacchPred;
	}

	public void setIdpacchpred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<PacchPer> getPacchPers() {
		return this.pacchPers;
	}

	public void setPacchPers(List<PacchPer> pacchPers) {
		this.pacchPers = pacchPers;
	}

	public PacchPer addPacchPer(PacchPer pacchPer) {
		getPacchPers().add(pacchPer);
		pacchPer.setPacchPred(this);

		return pacchPer;
	}

	public PacchPer removePacchPer(PacchPer pacchPer) {
		getPacchPers().remove(pacchPer);
		pacchPer.setPacchPred(null);

		return pacchPer;
	}

	public List<ProdBase> getProdBases() {
		return this.prodBases;
	}

	public void setProdBases(List<ProdBase> prodBases) {
		this.prodBases = prodBases;
	}

}