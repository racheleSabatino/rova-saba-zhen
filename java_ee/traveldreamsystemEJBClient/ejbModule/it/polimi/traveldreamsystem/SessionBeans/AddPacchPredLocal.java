package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.dto.PacchPredDTO;

import javax.ejb.Local;

@Local
public interface AddPacchPredLocal {

	void addNewPacchPred(PacchPredDTO newPacchetto);
}
