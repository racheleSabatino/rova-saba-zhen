package it.polimi.traveldreamsystem.SessionBeans;

import javax.ejb.Local;

import it.polimi.traveldreamsystem.dto.UtenteDTO;

@Local
public interface SearchUserLocal {

	public abstract String searchUserByMail (String mail);
	
	public abstract String searchUserByCognome(String cognome);
	
}
