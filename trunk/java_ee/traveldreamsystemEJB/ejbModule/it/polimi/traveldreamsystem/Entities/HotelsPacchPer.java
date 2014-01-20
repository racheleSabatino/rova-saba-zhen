package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HotelsPacchPer")
public class HotelsPacchPer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDHOTEL", unique=true, nullable=false)
	private int idHotel;
	
	@Id
	@Column(name="IDPACCHPER", unique=true, nullable=false)
	private int idPacchPer;
	
	public HotelsPacchPer(int idPacchPer, int idHotel) {
		this.idPacchPer = idPacchPer;
		this.idHotel = idHotel;
	}
	
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	
	public int getIdHotel(){
		return idHotel;
	}
	
	public void setIdPacchPer(int idPacchPer) {
		this.idPacchPer = idPacchPer;
	}
	
	public int getIdPacchPer(){
		return idPacchPer;
	}
	
}
