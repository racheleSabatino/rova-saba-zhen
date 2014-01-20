package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the Escursione database table.
 * 
 */
@Entity
@Table(name="escursione")
@NamedQuery(name="Escursione.findAll", query="SELECT e FROM Escursione e")
public class Escursione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDPRODBASE", unique=true, nullable=false)
	private int idprodbase;

	@Column(name="COSTO")
	private int costo;

	@Lob
	@Column(name="DESCRIZIONE")
	private String descrizione;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAPARTENZA", nullable=false)
	private Date datapartenza;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATARITORNO", nullable=false)
	private Date dataritorno;

	@Column(name="LUOGO", nullable=false, length=45)
	private String luogo;

	public Escursione() {
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

}