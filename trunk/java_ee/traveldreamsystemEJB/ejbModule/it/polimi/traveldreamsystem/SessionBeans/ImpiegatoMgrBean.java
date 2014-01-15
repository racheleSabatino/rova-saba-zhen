package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Utente;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * 
 */
@Stateless
public class ImpiegatoMgrBean extends UtenteMgrBean implements ImpiegatoMgrBeanLocal{
	
	@Override
	@RolesAllowed(Utente._AMMINISTRATORE)
	public void addImpiegato(UtenteDTO utente) {
		utente.setTipoUtente(Utente._IMPIEGATO);
		save(utente);
	}
    
    public List<Utente> getAllEmployees() {
    	try{
    		Query q = em.createNamedQuery("SELECT i FROM Utente i WHERE i.tipoutente = :tipo ");
    		q.setParameter("tipo", "_IMPIEGATO");
    		List<Utente> impiegati = q.getResultList();
    		return impiegati;
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    


}
