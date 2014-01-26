package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "trasportiPacchPer")
public class TrasportiPacchPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDTRASPORTO", referencedColumnName = "IDPRODBASE")
	private Trasporto trasporto;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDPACCHPER", referencedColumnName = "IDPACCHPER")
	private PacchPer pacchPer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAACQUISTO")
	private Date dataAcquisto;
	
	
	public TrasportiPacchPer() {
	}
	
	public TrasportiPacchPer(Trasporto trasporto, PacchPer pacchPer) {
		this.trasporto = trasporto;
		this.pacchPer = pacchPer;
	}

	public Date getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	

	public Trasporto getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(Trasporto trasporto) {
		this.trasporto = trasporto;
	}

	public PacchPer getPacchPer() {
		return pacchPer;
	}

	public void setPacchPer(PacchPer pacchPer) {
		this.pacchPer = pacchPer;
	}

}