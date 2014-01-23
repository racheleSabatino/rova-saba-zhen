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
@Table(name = "EscursioniPacchPer")
public class EscursioniPacchPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDESCURSIONE", referencedColumnName = "IDPRODBASE")
	private Escursione escursioni;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDPACCHPER", referencedColumnName = "IDPACCHPER")
	private PacchPer pacchPer;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAACQUISTO", nullable=false)
	private Date dataAcquisto;

	public EscursioniPacchPer() {
	}

	public EscursioniPacchPer(Escursione escursione, PacchPer pacchPer) {
		this.escursioni = escursione;
		this.pacchPer = pacchPer;
	}

	public Date getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	
	public Escursione getEscursioni() {
		return escursioni;
	}

	public void setEscursioni(Escursione escursioni) {
		this.escursioni = escursioni;
	}

	public PacchPer getPacchPer() {
		return pacchPer;
	}

	public void setPacchPer(PacchPer pacchPer) {
		this.pacchPer = pacchPer;
	}
}
