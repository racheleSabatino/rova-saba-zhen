package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Classe che rappresenta la composizione di un pacchetto predefinito. Un oggetto della seguente classe rappresenta 
 * un pacchetto predefinito e la lista degli hotel che lo compongono
 */

@Entity
@Table(name = "hotelsPacchPred")
public class HotelsPacchPred implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDHOTEL", referencedColumnName = "IDPRODBASE")
	private Hotel hotel;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDPACCHPRED", referencedColumnName = "IDPACCHPRED")
	private PacchPred pacchPred;
	
	public HotelsPacchPred() {}

	public HotelsPacchPred(PacchPred pacchPred, Hotel hotel) {
		this.hotel = hotel;
		this.pacchPred = pacchPred;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public PacchPred getPacchPred() {
		return pacchPred;
	}

	public void setPacchPred(PacchPred pacchPred) {
		this.pacchPred = pacchPred;
	}
	
}
