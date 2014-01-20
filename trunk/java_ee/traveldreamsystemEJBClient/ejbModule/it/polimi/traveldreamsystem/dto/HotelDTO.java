package it.polimi.traveldreamsystem.dto;


import javax.persistence.Column;
import javax.persistence.Lob;

import org.hibernate.validator.constraints.NotEmpty;

public class HotelDTO {

	private int idprodbase;
	
	@NotEmpty
	private int costo;

	@NotEmpty
	private String descrizione;

	@NotEmpty
	private String citta;

	@NotEmpty
	private int stelle;

	@NotEmpty
	private String tipocamera;

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

	public String getTipocamera() {
		return this.tipocamera;
	}

	public void setTipocamera(String tipocamera) {
		this.tipocamera = tipocamera;
	}

	public ProdBaseDTO getProdBase() {
		return this.prodBase;
	}

	public void setProdBase(ProdBaseDTO prodBase) {
		this.prodBase = prodBase;
	}

}
