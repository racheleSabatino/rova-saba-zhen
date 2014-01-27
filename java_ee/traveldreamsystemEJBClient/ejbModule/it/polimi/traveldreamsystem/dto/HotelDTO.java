package it.polimi.traveldreamsystem.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

public class HotelDTO {

	private int idProdBase;
	
	private int costo;

	private String descrizione;

	@NotEmpty
	private String citta;

	private int stelle;

	@NotEmpty
	private String tipoCamera;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPartenza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRitorno;
	
	private Boolean selected = false;

	public int getIdProdBase() {
		return idProdBase;
	}

	public void setIdProdBase(int idProdBase) {
		this.idProdBase = idProdBase;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public int getStelle() {
		return stelle;
	}

	public void setStelle(int stelle) {
		this.stelle = stelle;
	}

	public String getTipoCamera() {
		return tipoCamera;
	}

	public void setTipoCamera(String tipoCamera) {
		this.tipoCamera = tipoCamera;
	}

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

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}


	public String toString(){
		String rep = "Descrizione hotel : " + descrizione + 
		" \n Hotel a  " + stelle + "\nsituato a " + citta +
		"\ninizio prenotazione: " + dataPartenza +
		"\nfine prenotazione: " + dataRitorno + 
		"tipo camera: " + tipoCamera +
		"\ncosto totale soggiorno in hotel: " + costo;
		return rep;
	}
}
