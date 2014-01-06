package it.polimi.traveldreamsystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pacchpred database table.
 * 
 */
@Entity
@NamedQuery(name="Pacchpred.findAll", query="SELECT p FROM Pacchpred p")
public class Pacchpred implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int pacchPredID;

	@Lob
	private String descrizione;

	//bi-directional many-to-many association to Prodbase
	@ManyToMany
	@JoinTable(
		name="composiz"
		, joinColumns={
			@JoinColumn(name="pacchPredID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="prodBaseID")
			}
		)
	private List<Prodbase> prodbases;

	//bi-directional many-to-one association to Personalizz
	@OneToMany(mappedBy="pacchpred")
	private List<Personalizz> personalizzs;

	public Pacchpred() {
	}

	public int getPacchPredID() {
		return this.pacchPredID;
	}

	public void setPacchPredID(int pacchPredID) {
		this.pacchPredID = pacchPredID;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Prodbase> getProdbases() {
		return this.prodbases;
	}

	public void setProdbases(List<Prodbase> prodbases) {
		this.prodbases = prodbases;
	}

	public List<Personalizz> getPersonalizzs() {
		return this.personalizzs;
	}

	public void setPersonalizzs(List<Personalizz> personalizzs) {
		this.personalizzs = personalizzs;
	}

	public Personalizz addPersonalizz(Personalizz personalizz) {
		getPersonalizzs().add(personalizz);
		personalizz.setPacchpred(this);

		return personalizz;
	}

	public Personalizz removePersonalizz(Personalizz personalizz) {
		getPersonalizzs().remove(personalizz);
		personalizz.setPacchpred(null);

		return personalizz;
	}

}