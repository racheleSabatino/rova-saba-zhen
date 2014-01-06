package it.polimi.traveldreamsystemEJB;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prodbase database table.
 * 
 */
@Entity
@NamedQuery(name="Prodbase.findAll", query="SELECT p FROM Prodbase p")
public class Prodbase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int prodBaseID;

	private short costo;

	@Lob
	private String descrizione;

	//bi-directional many-to-many association to Pacchpred
	@ManyToMany(mappedBy="prodbases")
	private List<Pacchpred> pacchpreds;

	//bi-directional one-to-one association to Escursione
	@OneToOne(mappedBy="prodbase")
	private Escursione escursione;

	//bi-directional one-to-one association to Hotel
	@OneToOne(mappedBy="prodbase")
	private Hotel hotel;

	//bi-directional many-to-one association to Personalizz
	@OneToMany(mappedBy="prodbase")
	private List<Personalizz> personalizzs;

	//bi-directional one-to-one association to Trasporto
	@OneToOne(mappedBy="prodbase")
	private Trasporto trasporto;

	public Prodbase() {
	}

	public int getProdBaseID() {
		return this.prodBaseID;
	}

	public void setProdBaseID(int prodBaseID) {
		this.prodBaseID = prodBaseID;
	}

	public short getCosto() {
		return this.costo;
	}

	public void setCosto(short costo) {
		this.costo = costo;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Pacchpred> getPacchpreds() {
		return this.pacchpreds;
	}

	public void setPacchpreds(List<Pacchpred> pacchpreds) {
		this.pacchpreds = pacchpreds;
	}

	public Escursione getEscursione() {
		return this.escursione;
	}

	public void setEscursione(Escursione escursione) {
		this.escursione = escursione;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Personalizz> getPersonalizzs() {
		return this.personalizzs;
	}

	public void setPersonalizzs(List<Personalizz> personalizzs) {
		this.personalizzs = personalizzs;
	}

	public Personalizz addPersonalizz(Personalizz personalizz) {
		getPersonalizzs().add(personalizz);
		personalizz.setProdbase(this);

		return personalizz;
	}

	public Personalizz removePersonalizz(Personalizz personalizz) {
		getPersonalizzs().remove(personalizz);
		personalizz.setProdbase(null);

		return personalizz;
	}

	public Trasporto getTrasporto() {
		return this.trasporto;
	}

	public void setTrasporto(Trasporto trasporto) {
		this.trasporto = trasporto;
	}

}