package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.EscursioneDTO;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the Escursione database table.
 * 
 */
@Entity
@Table(name = "escursione")
@NamedQuery(name = "Escursione.findAll", query = "SELECT e FROM Escursione e")
public class Escursione implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "IDPRODBASE", unique = true, nullable = false)
	private int idprodbase;
	
	@Lob
	@Column(name = "DESCRIZIONE")
	private String descrizione;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATAPARTENZA", nullable = false)
	private Date dataPartenza;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATARITORNO", nullable = false)
	private Date dataritorno;

	@Column(name = "COSTO")
	private int costo;

	@Column(name = "LUOGO", nullable = false, length = 45)
	private String luogo;

	public Escursione() {}

	public Escursione(EscursioneDTO escursione) {
		this.descrizione = escursione.getDescrizione();
		this.costo = escursione.getCosto();
		this.dataPartenza = escursione.getDataPartenza();
		this.dataritorno = escursione.getDataRitorno();
		this.costo = escursione.getCosto();
		this.luogo = escursione.getLuogo();
	}

	public int getIdprodbase() {
		return this.idprodbase;
	}

	public void setIdprodbase(int idprodbase) {
		this.idprodbase = idprodbase;
	}

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

	public Date getDataPartenza() {
		return this.dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
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

}