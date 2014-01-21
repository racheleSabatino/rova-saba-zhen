package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

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
	
	@Column(name="COSTO")
	private int costo;

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

	@Lob
	@Column(name="DESCRIZIONE")
	private String descrizione;


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

	public Trasporto() {
	}
	
	public Trasporto(TrasportoDTO trasporto) {
		idprodbase = trasporto.getIdprodbase();
		
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

}