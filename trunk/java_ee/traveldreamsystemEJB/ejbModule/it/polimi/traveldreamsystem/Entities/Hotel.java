package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.HotelDTO;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the Hotel database table.
 * 
 */
@Entity
@Table(name = "hotel")
@NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "IDPRODBASE", unique = true, nullable = false)
	private int idprodbase;

	@Column(name = "COSTO")
	private int costo;

	@Lob
	@Column(name = "DESCRIZIONE")
	private String descrizione;

	@Column(name = "CITTA", nullable = false, length = 45)
	private String citta;

	@Column(name = "STELLE", nullable = false)
	private int stelle;

	@Column(name = "TIpoCamERA", nullable = false, length = 45)
	private String tipoCamera;

	public Hotel() {}

	public Hotel(HotelDTO hotelDTO) {
		costo = hotelDTO.getCosto();
		descrizione = hotelDTO.getDescrizione();
		citta = hotelDTO.getCitta();
		stelle = hotelDTO.getStelle();
		tipoCamera = hotelDTO.getTipoCamera();
	}

	public int getIdprodbase() {
		return this.idprodbase;
	}

	public void setIdprodbase(int idprodbase) {
		this.idprodbase = idprodbase;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
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

	public int getStelle() {
		return this.stelle;
	}

	public void setStelle(int stelle) {
		this.stelle = stelle;
	}

	public String getTipoCamera() {
		return this.tipoCamera;
	}

	public void setTipoCamera(String tipoCamera) {
		this.tipoCamera = tipoCamera;
	}

}