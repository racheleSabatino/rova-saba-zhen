package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ProdBase database table.
 * 
 */
@Entity
@Table(name="ProdBase")
@NamedQuery(name="ProdBase.findAll", query="SELECT p FROM ProdBase p")
public class ProdBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDPRODBASE", unique=true, nullable=false)
	private int idprodbase;

	@Column(name="COSTO")
	private int costo;

	@Lob
	@Column(name="DESCRIZIONE")
	private String descrizione;

	//bi-directional one-to-one association to Escursione
	@OneToOne(mappedBy="prodBase")
	private Escursione escursione;

	//bi-directional one-to-one association to Hotel
	@OneToOne(mappedBy="prodBase")
	private Hotel hotel;

	//bi-directional one-to-one association to PacchPer
	@OneToOne(mappedBy="prodBase")
	private PacchPer pacchPer;

	//bi-directional many-to-many association to PacchPred
	@ManyToMany(mappedBy="prodBases1")
	private List<PacchPred> pacchPreds1;

	//bi-directional many-to-many association to PacchPred
	@ManyToMany
	@JoinTable(
		name="Composizione"
		, joinColumns={
			@JoinColumn(name="idProdBase", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idPacchPred", nullable=false)
			}
		)
	private List<PacchPred> pacchPreds2;

	//bi-directional one-to-one association to Trasporto
	@OneToOne(mappedBy="prodBase")
	private Trasporto trasporto;

	public ProdBase() {
	}

	public int getIdprodbase() {
		return this.idprodbase;
	}

	public void setIdprodbase(int idprodbase) {
		this.idprodbase = idprodbase;
	}

	public int getCosto() {
		return this.costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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

	public PacchPer getPacchPer() {
		return this.pacchPer;
	}

	public void setPacchPer(PacchPer pacchPer) {
		this.pacchPer = pacchPer;
	}

	public List<PacchPred> getPacchPreds1() {
		return this.pacchPreds1;
	}

	public void setPacchPreds1(List<PacchPred> pacchPreds1) {
		this.pacchPreds1 = pacchPreds1;
	}

	public List<PacchPred> getPacchPreds2() {
		return this.pacchPreds2;
	}

	public void setPacchPreds2(List<PacchPred> pacchPreds2) {
		this.pacchPreds2 = pacchPreds2;
	}

	public Trasporto getTrasporto() {
		return this.trasporto;
	}

	public void setTrasporto(Trasporto trasporto) {
		this.trasporto = trasporto;
	}

}