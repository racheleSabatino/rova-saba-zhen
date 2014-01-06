package it.polimi.traveldreamsystemEJB;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trasporto database table.
 * 
 */
@Entity
@NamedQuery(name="Trasporto.findAll", query="SELECT t FROM Trasporto t")
public class Trasporto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int prodBaseID;

	private String cittPartenza;

	private String cittRitorno;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPartenza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRitorno;

	//bi-directional one-to-one association to Prodbase
	@OneToOne
	@JoinColumn(name="prodBaseID")
	private Prodbase prodbase;

	public Trasporto() {
	}

	public int getProdBaseID() {
		return this.prodBaseID;
	}

	public void setProdBaseID(int prodBaseID) {
		this.prodBaseID = prodBaseID;
	}

	public String getCittPartenza() {
		return this.cittPartenza;
	}

	public void setCittPartenza(String cittPartenza) {
		this.cittPartenza = cittPartenza;
	}

	public String getCittRitorno() {
		return this.cittRitorno;
	}

	public void setCittRitorno(String cittRitorno) {
		this.cittRitorno = cittRitorno;
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

	public Prodbase getProdbase() {
		return this.prodbase;
	}

	public void setProdbase(Prodbase prodbase) {
		this.prodbase = prodbase;
	}

}