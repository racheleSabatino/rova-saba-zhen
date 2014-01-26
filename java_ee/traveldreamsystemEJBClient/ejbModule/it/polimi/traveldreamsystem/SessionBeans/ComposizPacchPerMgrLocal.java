package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ComposizPacchPerMgrLocal {

	void addHotelToPacchPer(int idPacchPer, int idHotel);

	void addEscursioneToPacchPer(int idPacchPer, int idEscursione);

	void addTrasportoToPacchPer(int idPacchPer, int idTrasporto);
	
	void removeHotelToPacchPer(int idPacchPer, int idHotel);

	void removeEscursioneToPacchPer(int idPacchPer, int idEscursione);

	void removeTrasportoToPacchPer(int idPacchPer, int idTrasporto);

	List<EscursioneDTO> getEscursioniPacchPer(int idPacchPred);

	List<HotelDTO> getHotelsPacchPer(int idPacchPer);

	List<TrasportoDTO> getTrasportiPacchPred(int idPacchPer);

	boolean findTrasporto(int idPacchPer, int idTrasporto);

	boolean findHotel(int idPacchPer, int idHotel);

	boolean findEscursione(int idPacchPer, int idEscursione);
}
