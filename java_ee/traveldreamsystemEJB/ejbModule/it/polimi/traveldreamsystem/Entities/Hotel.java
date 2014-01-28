package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.HotelDTO;

import java.io.Serializable;
import java.util.Date;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDPRODBASE", unique = true, nullable = false)
	private int idProdBase;

	@Column(name = "COSTO")
	private int costo;

	@Lob
	@Column(name = "DESCRIZIONE", nullable = false)
	private String descrizione;

	@Column(name = "CITTA", nullable = false, length = 45)
	private String citta;

	@Column(name = "STELLE", nullable = false)
	private int stelle;

	@Column(name = "TIPOCAMERA", nullable = false, length = 45)
	private String tipoCamera;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATAPARTENZA", nullable = false)
	private Date dataPartenza;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATARITORNO", nullable = false)
	private Date dataRitorno;


	public Date getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public Date getDataRitorno() {
		return dataRitorno;
	}

	public void setDataRitorno(Date dataRitorno) {
		this.dataRitorno = dataRitorno;
	}

	public Hotel() {}

	public Hotel(HotelDTO hotelDTO) {
		idProdBase = hotelDTO.getIdProdBase();
		costo = hotelDTO.getCosto();
		descrizione = hotelDTO.getDescrizione();
		citta = hotelDTO.getCitta();
		stelle = hotelDTO.getStelle();
		tipoCamera = hotelDTO.getTipoCamera();
		dataPartenza = hotelDTO.getDataPartenza();
		dataRitorno = hotelDTO.getDataRitorno();
	}

	public int getIdProdBase() {
		return this.idProdBase;
	}

	public void setIdProdBase(int idProdBase) {
		this.idProdBase = idProdBase;
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