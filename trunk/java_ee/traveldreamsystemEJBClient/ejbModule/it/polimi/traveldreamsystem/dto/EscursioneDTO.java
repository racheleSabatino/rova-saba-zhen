package it.polimi.traveldreamsystem.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

public class EscursioneDTO {
	
	@NotEmpty
	private int idprodbase;

	@NotEmpty
	private Date datapartenza;

	@Temporal(TemporalType.TIMESTAMP)
	@NotEmpty
	private Date dataritorno;

	private String luogo;

	@NotEmpty
	private ProdBaseDTO prodBase;

	public EscursioneDTO() {
	}

	public int getIdprodbase() {
		return this.idprodbase;
	}

	public void setIdprodbase(int idprodbase) {
		this.idprodbase = idprodbase;
	}

	public Date getDatapartenza() {
		return this.datapartenza;
	}

	public void setDatapartenza(Date datapartenza) {
		this.datapartenza = datapartenza;
	}

	public Date getDataritorno() {
		return this.dataritorno;
	}

	public void setDataritorno(Date dataritorno) {
		this.dataritorno = dataritorno;
	}

	public String getLuogo() {
		return this.luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public ProdBaseDTO getProdBase() {
		return this.prodBase;
	}

	public void setProdBase(ProdBaseDTO prodBase) {
		this.prodBase = prodBase;
	}

}
