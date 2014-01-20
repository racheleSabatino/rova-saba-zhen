package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TrasportiPacchPred")
public class TrasportiPacchPred implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDTRASPORTO", unique=true, nullable=false)
	int idTrasporto;
	
	@Id
	@Column(name="IDPACCHPRED", unique=true, nullable=false)
	int idPacchPred;
	
	public TrasportiPacchPred(int idPacchPred, int idTrasporto) {
		this.idPacchPred = idPacchPred;
		this.idTrasporto = idTrasporto;
	}
	
	public void setIdTrasporto(int idTrasporto) {
		this.idTrasporto = idTrasporto;
	}
	
	public int getIdHotel(){
		return idTrasporto;
	}
	
	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}
	
	public int getIdPacchPred(){
		return idPacchPred;
	}

}
