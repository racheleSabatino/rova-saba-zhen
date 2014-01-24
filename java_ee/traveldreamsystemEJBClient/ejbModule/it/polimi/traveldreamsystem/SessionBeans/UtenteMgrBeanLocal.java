package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.Local;

@Local
public interface UtenteMgrBeanLocal {
	
	public void unregister();
	
	public UtenteDTO getUtenteDTO();
	
	public UtenteDTO findUtenteDTO(String mail);

	public void removeUtente(String mail);

	void update(UtenteDTO utente);

	String getPrincipalEmail();
	
 
	
}