package it.polimi.traveldreamsystem.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

public class EscursioneDTO {
	
	private int idProdBase;

	private int costo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPartenza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRitorno;

	@NotEmpty
	private String luogo;

	private String descrizione;
	
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

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String toString() {
		String rep = "Descrizione escursione: " + this.descrizione +
				"\npresso: " + this.getLuogo() + 
				"\ngiorno/ora inizio: " + this.getDataPartenza() + 
				"\ngiorno/ora fine: " + this.getDataRitorno() + 
				"\ncosto totale: " + this.getCosto();
		return rep;
				
		
	}
	
}
