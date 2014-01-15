package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Utente;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.Stateless;

/**
 * 
 */
@Stateless
public class ClienteMgrBean extends UtenteMgrBean implements ClienteMgrBeanLocal {

	@Override
	public void addCliente(UtenteDTO utente) {
		utente.setTipoUtente(Utente._CLIENTE);
		save(utente);
	}
}
