package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EscursioniPacchPred")
public class EscursioniPacchPred implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDESCURSIONE", referencedColumnName = "IDPRODBASE")
	private Escursione escursioni;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDPACCHPRED", referencedColumnName = "IDPACCHPRED")
	private PacchPred pacchPred;

	public EscursioniPacchPred(){}
	
	public EscursioniPacchPred(PacchPred pacchPred, Escursione escursioni) {
		this.escursioni = escursioni;
		this.pacchPred = pacchPred;
	}


	public Escursione getEscursioni() {
		return escursioni;
	}

	public void setEscursioni(Escursione escursioni) {
		this.escursioni = escursioni;
	}

	public PacchPred getPacchPred() {
		return pacchPred;
	}

	public void setPacchPred(PacchPred pacchPred) {
		this.pacchPred = pacchPred;
	}
	
}