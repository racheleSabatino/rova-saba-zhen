package it.polimi.traveldreamsystemEJB;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the escursione database table.
 * 
 */
@Entity
@NamedQuery(name="Escursione.findAll", query="SELECT e FROM Escursione e")
public class Escursione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int prodBaseID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPartenza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataritorno;

	private String luogo;

	//bi-directional one-to-one association to Prodbase
	@OneToOne
	@JoinColumn(name="prodBaseID")
	private Prodbase prodbase;

	public Escursione() {
	}

	public int getProdBaseID() {
		return this.prodBaseID;
	}

	public void setProdBaseID(int prodBaseID) {
		this.prodBaseID = prodBaseID;
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

	public Prodbase getProdbase() {
		return this.prodbase;
	}

	public void setProdbase(Prodbase prodbase) {
		this.prodbase = prodbase;
	}

}