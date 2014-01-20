package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EscursioniPacchPer")
public class EscursioniPacchPer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDESCURSIONE", unique=true, nullable=false)
	private int idEscursione;
	
	@Id
	@Column(name="IDPACCHPER", unique=true, nullable=false)
	private int idPacchPer;
	
	public EscursioniPacchPer(int idPacchPer, int idEscursione) {
		this.idPacchPer = idPacchPer;
		this.idEscursione = idEscursione;
	}
	
	public void setIdEscursione(int idEscursione) {
		this.idEscursione = idEscursione;
	}
	
	public int getIdEscursione(){
		return idEscursione;
	}
	
	public void setIdPacchPer(int idPacchPer) {
		this.idPacchPer = idPacchPer;
	}
	
	public int getIdPacchPer(){
		return idPacchPer;
	}
	

}
