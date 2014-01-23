package it.polimi.traveldreamsystem.SessionBeans;

interface ComposizPaccPerMgrLocal {

	void addHotelToPacchPer(int idPacchPer, int idHotel);

	void addEscursioneToPacchPer(int idPacchPer, int idEscursione);

	void addTrasportoToPacchPer(int idPacchPer, int idTrasporto);
	
	void removeHotelToPacchPer(int idPacchPer, int idHotel);

	void removeEscursioneToPacchPer(int idPacchPer, int idEscursione);

	void removeTrasportoToPacchPer(int idPacchPer, int idTrasporto);
}
