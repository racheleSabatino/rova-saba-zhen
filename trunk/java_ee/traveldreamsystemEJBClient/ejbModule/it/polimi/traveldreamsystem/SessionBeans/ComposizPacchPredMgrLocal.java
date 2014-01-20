package it.polimi.traveldreamsystem.SessionBeans;

import javax.ejb.Local;

@Local
public interface ComposizPacchPredMgrLocal {

	void addHotelToPacch(int idPacchPred, int idHotel);
	
	void removeHotelToPacch(int idPacchPred, int idHotel);
	
	void addTrasportoToPacch(int idPacchPred, int idTrasporto);
	
	void removeTrasportoToPacch(int idPacchPred, int idTrasporto);
	
	void addEscursioneToPacch(int idPacchPred, int idEscursione);
	
	void removeEscursioneToPacch(int idPacchPred, int idEscursione);
}
