package it.polimi.traveldreamsystem.SessionBeans;

import javax.ejb.Local;

@Local
public interface ComposizPacchPredMgrLocal {

	void addHotelToPacch(int idPacchPred, int idHotel);
	
	int removeHotelToPacch(int idPacchPred, int idHotel);
	
	void addTrasportoToPacch(int idPacchPred, int idTrasporto);
	
	int removeTrasportoToPacch(int idPacchPred, int idTrasporto);
	
	void addEscursioneToPacch(int idPacchPred, int idEscursione);
	
	int removeEscursioneToPacch(int idPacchPred, int idEscursione);
}
