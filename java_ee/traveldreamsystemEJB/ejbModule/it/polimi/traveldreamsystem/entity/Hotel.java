package it.polimi.traveldreamsystem.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int prodBaseID;

	private String citt;

	private byte stelle;

	private byte tipoCamera;

	//bi-directional one-to-one association to Prodbase
	@OneToOne
	@JoinColumn(name="prodBaseID")
	private Prodbase prodbase;

	public Hotel() {
	}

	public int getProdBaseID() {
		return this.prodBaseID;
	}

	public void setProdBaseID(int prodBaseID) {
		this.prodBaseID = prodBaseID;
	}

	public String getCitt() {
		return this.citt;
	}

	public void setCitt(String citt) {
		this.citt = citt;
	}

	public byte getStelle() {
		return this.stelle;
	}

	public void setStelle(byte stelle) {
		this.stelle = stelle;
	}

	public byte getTipoCamera() {
		return this.tipoCamera;
	}

	public void setTipoCamera(byte tipoCamera) {
		this.tipoCamera = tipoCamera;
	}

	public Prodbase getProdbase() {
		return this.prodbase;
	}

	public void setProdbase(Prodbase prodbase) {
		this.prodbase = prodbase;
	}

}