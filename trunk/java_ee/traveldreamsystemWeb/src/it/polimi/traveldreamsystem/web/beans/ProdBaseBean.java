package it.polimi.traveldreamsystem.web.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="prodBaseBean")
@RequestScoped
public class ProdBaseBean {
	private String tipo;
	private Date dataPartenza;
	private Date dataRitorno;
	private String descrizione;
	private String luogo;
	private String citta;
	private String stelle;
	private String tipoCamera;
	private String cittaPartenza;
	private String cittaRitorno;
	private String costo;
	
	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getStelle() {
		return stelle;
	}

	public void setStelle(String stelle) {
		this.stelle = stelle;
	}

	public String getTipoCamera() {
		return tipoCamera;
	}

	public void setTipoCamera(String tipoCamera) {
		this.tipoCamera = tipoCamera;
	}

	public String getCittaPartenza() {
		return cittaPartenza;
	}

	public void setCittaPartenza(String cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}

	public String getCittaRitorno() {
		return cittaRitorno;
	}

	public void setCittaRitorno(String cittaRitorno) {
		this.cittaRitorno = cittaRitorno;
	}


	
	
	public Date getDataRitorno() {
		return dataRitorno;
	}

	public void setDataRitorno(Date dataRitorno) {
		this.dataRitorno = dataRitorno;
	}

	public Date getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public void changePanel(){
		
	}
}
