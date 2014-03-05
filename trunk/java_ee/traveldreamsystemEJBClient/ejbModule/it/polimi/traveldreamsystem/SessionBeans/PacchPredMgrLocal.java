package it.polimi.traveldreamsystem.SessionBeans;

import java.util.List;

import it.polimi.traveldreamsystem.dto.PacchPredDTO;

import javax.ejb.Local;

@Local
public interface PacchPredMgrLocal {
	
	List<PacchPredDTO> getAllPacchPred();

	void addNewPacchPred(PacchPredDTO newPacchetto);
	
	boolean removePacchPred(int idPacchetto);
	
	PacchPredDTO findPacchPredDTO(int idPacchPred);

	void update(PacchPredDTO pacchetto);

	List<PacchPredDTO> getCittaHotelPacch(String citta);
}
