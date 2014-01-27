package it.polimi.traveldreamsystem.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

public class TrasportoDTO {

	@NotEmpty
	private int idProdBase;
	
	private int costo;
	
	private String descrizione;
	
	private Boolean selected = false;


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

	@NotEmpty
	private String cittaPartenza;

	@NotEmpty
	private String cittaRitorno;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPartenza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRitorno;

	public TrasportoDTO() {
	}

	public int getIdProdBase() {
		return this.idProdBase;
	}

	public void setIdProdBase(int idProdBase) {
		this.idProdBase = idProdBase;
	}

	public String getCittaPartenza() {
		return this.cittaPartenza;
	}

	public void setCittaPartenza(String cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}

	public String getCittaRitorno() {
		return this.cittaRitorno;
	}

	public void setCittaRitorno(String cittaRitorno) {
		this.cittaRitorno = cittaRitorno;
	}

	public Date getDataPartenza() {
		return this.dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public Date getDataRitorno() {
		return this.dataRitorno;
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
	
	public String toString() {
		String rep = "Dettagli mezzo di trasporto: " + this.descrizione +
				"\ncittà partenza: " + this.cittaPartenza +
				"\ngiorno/ora partenza " + this.dataPartenza +
				"\ncittà arrivo: " + cittaRitorno + 
				"\ngiorno/ora arrivo: " + dataRitorno +
				"costo viaggio: " + this.costo;
		return rep;
	}

}
