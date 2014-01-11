package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Trasporto database table.
 * 
 */
@Entity
@Table(name="trasporto")
@NamedQuery(name="Trasporto.findAll", query="SELECT t FROM Trasporto t")
public class Trasporto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDPRODBASE", unique=true, nullable=false)
	private int idprodbase;

	@Column(name="CITTAPARTENZA", nullable=false, length=45)
	private String cittapartenza;

	@Column(name="CITTARITORNO", nullable=false, length=45)
	private String cittaritorno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAPARTENZA", nullable=false)
	private Date datapartenza;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATARITORNO", nullable=false)
	private Date dataritorno;

	//bi-directional one-to-one association to ProdBase
	@OneToOne
	@JoinColumn(name="IDPRODBASE", nullable=false, insertable=false, updatable=false)
	private ProdBase prodBase;

	public Trasporto() {
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

	public ProdBase getProdBase() {
		return this.prodBase;
	}

	public void setProdBase(ProdBase prodBase) {
		this.prodBase = prodBase;
	}

}