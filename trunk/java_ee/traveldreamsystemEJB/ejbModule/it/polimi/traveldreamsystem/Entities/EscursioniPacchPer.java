package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	public EscursioniPacchPer() {}

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
