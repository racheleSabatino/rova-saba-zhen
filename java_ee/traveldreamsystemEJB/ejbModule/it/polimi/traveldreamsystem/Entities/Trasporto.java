package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the Trasporto database table.
 * 
 */
@Entity
@Table(name = "trasporto")
@NamedQuery(name = "Trasporto.findAll", query = "SELECT t FROM Trasporto t")
public class Trasporto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDPRODBASE", unique = true, nullable = false)
	private int idprodbase;

	@Column(name = "COSTO")
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
	@Column(name = "DESCRIZIONE")
	private String descrizione;

	@Column(name = "CITTAPARTENZA", nullable = false, length = 45)
	private String cittaPartenza;

	@Column(name = "CITTARITORNO", nullable = false, length = 45)
	private String cittaRitorno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATAPARTENZA", nullable = false)
	private Date dataPartenza;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATARITORNO", nullable = false)
	private Date dataRitorno;

	public Trasporto() {}

	public Trasporto(TrasportoDTO trasporto) {
		this.idprodbase = trasporto.getIdProdBase();
		this.dataPartenza = trasporto.getDataPartenza();
		this.dataRitorno = trasporto.getDataRitorno();
		this.cittaPartenza = trasporto.getCittaPartenza();
		this.cittaRitorno = trasporto.getCittaRitorno();
		this.costo = trasporto.getCosto();
		this.descrizione = trasporto.getDescrizione();
	}

	public int getIdProdBase() {
		return this.idprodbase;
	}

	public void setIdProdBase(int idProdBase) {
		this.idprodbase = idProdBase;
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

}