package it.polimi.traveldreamsystem.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class HotelDTO {

	private int idprodbase;
	
	private int costo;

	@NotEmpty
	private String descrizione;

	@NotEmpty
	private String citta;

	private int stelle;

	@NotEmpty
	private String tipoCamera;

	@NotEmpty
	private ProdBaseDTO prodBase;

	public HotelDTO() {
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
	
	
	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
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

	public ProdBaseDTO getProdBase() {
		return this.prodBase;
	}

	public void setProdBase(ProdBaseDTO prodBase) {
		this.prodBase = prodBase;
	}

}
