package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.Local;

@Local
public interface ClienteMgrBeanLocal extends UtenteMgrBeanLocal {

	void addCliente(UtenteDTO utente);

}
