package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TrasportiPacchPer")
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
	
	public TrasportiPacchPer() {}

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