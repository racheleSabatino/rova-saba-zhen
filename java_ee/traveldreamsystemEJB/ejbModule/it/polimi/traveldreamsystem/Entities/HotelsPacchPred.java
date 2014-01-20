package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 * Classe che rappresenta la composizione di un pacchetto predefinito. Un oggetto della seguente classe rappresenta 
 * un pacchetto predefinito e la lista degli hotel che lo compongono
 */

@Entity
@Table(name="HotelsPacchPred")
public class HotelsPacchPred implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDHOTEL", unique=true, nullable=false)
	private int idHotel;
	
	@Id
	@Column(name="IDPACCHPRED", unique=true, nullable=false)
	private int idPacchPred;
	
	public HotelsPacchPred(int idPacchPred, int idHotel) {
		this.idPacchPred = idPacchPred;
		this.idHotel = idHotel;
	}
	
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	
	public int getIdHotel(){
		return idHotel;
	}
	
	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}
	
	public int getIdPacchPred(){
		return idPacchPred;
	}
	
	
	

}
