package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TrasportiPacchPer")
public class TrasportiPacchPer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDTRASPORTO", unique=true, nullable=false)
	private int idTrasporto;
	
	@Id
	@Column(name="IDPACCHPER", unique=true, nullable=false)
	private int idPacchPer;
	
	public TrasportiPacchPer(int idPacchPer, int idTrasporto) {
		this.idPacchPer = idPacchPer;
		this.idTrasporto = idTrasporto;
	}
	
	public void setIdTrasporto(int idTrasporto) {
		this.idTrasporto = idTrasporto;
	}
	
	public int getIdTrasporto(){
		return idTrasporto;
	}
	
	public void setIdPacchPer(int idPacchPer) {
		this.idPacchPer = idPacchPer;
	}
	
	public int getIdPacchPer(){
		return idPacchPer;
	}
	
}
