package it.polimi.traveldreamsystem.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

public class TrasportoDTO {

	@NotEmpty
	private int idprodbase;

	@NotEmpty
	private String cittapartenza;

	@NotEmpty
	private String cittaritorno;

	@Temporal(TemporalType.TIMESTAMP)
	@NotEmpty
	private Date datapartenza;

	@Temporal(TemporalType.TIMESTAMP)
	@NotEmpty
	private Date dataritorno;

	@NotEmpty
	private ProdBaseDTO prodBase;

	public TrasportoDTO() {
	}

	public int getIdprodbase() {
		return this.idprodbase;
	}

	public void setIdprodbase(int idprodbase) {
		this.idprodbase = idprodbase;
	}

	public String getCittapartenza() {
		return this.cittapartenza;
	}

	public void setCittapartenza(String cittapartenza) {
		this.cittapartenza = cittapartenza;
	}

	public String getCittaritorno() {
		return this.cittaritorno;
	}

	public void setCittaritorno(String cittaritorno) {
		this.cittaritorno = cittaritorno;
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

	public ProdBaseDTO getProdBase() {
		return this.prodBase;
	}

	public void setProdBase(ProdBaseDTO prodBase) {
		this.prodBase = prodBase;
	}

}
