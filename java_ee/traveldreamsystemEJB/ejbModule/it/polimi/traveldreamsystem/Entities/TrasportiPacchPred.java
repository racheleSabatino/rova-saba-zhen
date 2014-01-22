package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TrasportiPacchPred")
public class TrasportiPacchPred implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDTRASPORTO", referencedColumnName = "IDPRODBASE")
	private Trasporto trasporto;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDPACCHPRED", referencedColumnName = "IDPACCHPRED")
	private PacchPred pacchPred;

	public TrasportiPacchPred() {
	}

	public TrasportiPacchPred(int idPacchPred, int idTrasporto) {
		// TODO Auto-generated constructor stub
	}

	public Trasporto getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(Trasporto trasporto) {
		this.trasporto = trasporto;
	}

	public PacchPred getPacchPred() {
		return pacchPred;
	}

	public void setPacchPred(PacchPred pacchPred) {
		this.pacchPred = pacchPred;
	}

}