package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	//bi-directional many-to-one association to PacchPer
			@ManyToOne
			@JoinColumn(name="idPacchPer", nullable=false)
			private List<PacchPer> pacchPers;

		//bi-directional many-to-one association to Hotel
			@ManyToOne
			@JoinColumn(name="idprodbase", nullable=false)
			private List<Hotel> hotels;

	
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
	
	public void setPacchPers(List<PacchPer> pacchPers) {
		this.pacchPers = pacchPers;
	}
	
	public List<PacchPer> getpacchPers(){
		return pacchPers;
	}
	
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	public List<Hotel> getHotels(){
		return hotels;
	}
	
}
