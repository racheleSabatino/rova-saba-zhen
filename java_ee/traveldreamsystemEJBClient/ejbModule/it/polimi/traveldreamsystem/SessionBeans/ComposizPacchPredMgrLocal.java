package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ComposizPacchPredMgrLocal {

	void addHotelToPacch(int idPacchPred, int idHotel);
	
	int removeHotelToPacch(int idPacchPred, int idHotel);
	
	void addTrasportoToPacch(int idPacchPred, int idTrasporto);
	
	int removeTrasportoToPacch(int idPacchPred, int idTrasporto);
	
	void addEscursioneToPacch(int idPacchPred, int idEscursione);
	
	int removeEscursioneToPacch(int idPacchPred, int idEscursione);

	List<HotelDTO> getHotelsPacchPred(int idPacchPred);
	
	List<EscursioneDTO> getEscursioniPacchPred(int idPacchPred);
	
	List<TrasportoDTO> getTrasportiPacchPred(int idPacchPred);
}
