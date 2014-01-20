package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EscursioniPacchPred")
public class EscursioniPacchPred implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDESCURSIONE", unique=true, nullable=false)
	private int idEscursione;
	
	@Id
	@Column(name="IDPACCHPRED", unique=true, nullable=false)
	private int idPacchPred;
	
	public EscursioniPacchPred(int idPacchPred, int idEscursione) {
		this.idPacchPred = idPacchPred;
		this.idEscursione = idEscursione;
	}
	
	public void setIdEscursione(int idEscursione) {
		this.idEscursione = idEscursione;
	}
	
	public int getIdEscursione(){
		return idEscursione;
	}
	
	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}
	
	public int getIdPacchPred(){
		return idPacchPred;
	}
}