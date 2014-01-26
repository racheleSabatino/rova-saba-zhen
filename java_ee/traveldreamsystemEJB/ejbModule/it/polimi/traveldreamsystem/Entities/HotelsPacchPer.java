package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "hotelsPacchPer")
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAACQUISTO")
	private Date dataAcquisto;
	
	public HotelsPacchPer() {
		
	}
	
	public HotelsPacchPer(Hotel hotel, PacchPer pacchPer) {
		this.hotel = hotel;
		this.pacchPer = pacchPer;
	}

	public Date getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	
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
