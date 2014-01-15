package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.Local;

@Local
public interface ImpiegatoMgrBeanLocal extends UtenteMgrBeanLocal {

	void addImpiegato(UtenteDTO utente);

}
