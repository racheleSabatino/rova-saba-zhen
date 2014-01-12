package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.Local;

@Local
public interface AddNewEmployee {

	void addNewEmployee(UtenteDTO impiegato);
	
	public void unregister();
	
	public UtenteDTO getUtenteDTO();

}
