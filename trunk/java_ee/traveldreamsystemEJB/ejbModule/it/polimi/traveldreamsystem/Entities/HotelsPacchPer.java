package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HotelsPacchPer")
public class HotelsPacchPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDHOTEL", referencedColumnName = "IDPRODBASE")
	private Hotel hotel;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDPACCHPER", referencedColumnName = "IDPACCHPER")
	private PacchPer pacchPer;
	
	public HotelsPacchPer() {}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public PacchPer getPacchPer() {
		return pacchPer;
	}

	public void setPacchPer(PacchPer pacchPer) {
		this.pacchPer = pacchPer;
	}
	
}
