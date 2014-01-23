package it.polimi.traveldreamsystem.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class PacchPredDTO {

	@NotEmpty
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private int idPacchPred;

	@NotEmpty
	private String descrizione;

	private List<HotelDTO> hotel;
	private List<EscursioneDTO> escursione;
	private List<TrasportoDTO> trasporto;
	
	public PacchPredDTO () {
		hotel = new ArrayList<HotelDTO>();
		escursione = new ArrayList<EscursioneDTO>();
		trasporto = new ArrayList<TrasportoDTO>();
	}

	public int getIdPacchPred() {
		return idPacchPred;
	}

	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<HotelDTO> getHotel() {
		return hotel;
	}

	public void setHotel(List<HotelDTO> hotel) {
		this.hotel = hotel;
	}

	public List<EscursioneDTO> getEscursione() {
		return escursione;
	}

	public void setEscursione(List<EscursioneDTO> escursione) {
		this.escursione = escursione;
	}

	public List<TrasportoDTO> getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(List<TrasportoDTO> trasporto) {
		this.trasporto = trasporto;
	}
}
