package it.polimi.traveldreamsystem.Entities;

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
	private int idpacchpred;

	@Lob
	@Column(name="DESCRIZIONE")
	private String descrizione;

	//bi-directional many-to-one association to PacchPer
	@OneToMany(mappedBy="pacchPred")
	private List<PacchPer> pacchPers;

	//bi-directional many-to-many association to ProdBase
	@ManyToMany
	@JoinTable(
		name="composizione"
		, joinColumns={
			@JoinColumn(name="IDPACCHPRED", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDPRODBASE", nullable=false)
			}
		)
	private List<ProdBase> prodBases1;

	//bi-directional many-to-many association to ProdBase
	@ManyToMany(mappedBy="pacchPreds2")
	private List<ProdBase> prodBases2;

	public PacchPred() {
	}

	public int getIdpacchpred() {
		return this.idpacchpred;
	}

	public void setIdpacchpred(int idpacchpred) {
		this.idpacchpred = idpacchpred;
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

	public List<ProdBase> getProdBases1() {
		return this.prodBases1;
	}

	public void setProdBases1(List<ProdBase> prodBases1) {
		this.prodBases1 = prodBases1;
	}

	public List<ProdBase> getProdBases2() {
		return this.prodBases2;
	}

	public void setProdBases2(List<ProdBase> prodBases2) {
		this.prodBases2 = prodBases2;
	}

}