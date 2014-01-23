package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import javax.ejb.Local;

@Local
public interface PacchPerMgrLocal {

	void addNewPacchPer(PacchPerDTO newPacchetto);

	void acquistaPacchPer(int idPacchPer);

	void creaListaRegali(int idPacchPer);

}
