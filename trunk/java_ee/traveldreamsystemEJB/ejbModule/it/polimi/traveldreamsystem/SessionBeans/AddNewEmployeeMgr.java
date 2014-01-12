package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Utente;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import java.util.List;

import javax.annotation.Resource;
//import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class UtenteMgrBean
 */
@Stateless
public class AddNewEmployeeMgr implements AddNewEmployee {

    /**
     * Default constructor. 
     */
    public AddNewEmployeeMgr() {
    }
    
	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
	@Override
//	@RolesAllowed({Utente._IMPIEGATO})
	public void addNewEmployee (UtenteDTO utente) {
		Utente newUtente = new Utente(utente);
		newUtente.setTipoUtente(Utente._IMPIEGATO);
		em.persist(newUtente);
	}


	@Override
	public UtenteDTO getUtenteDTO() {
		return convertToDTO(getPrincipalUser());
	}


	@Override
	public void unregister() {
		remove(getPrincipalUser());
	}


	public Utente find(String mail) {
    	return em.find(Utente.class, mail);
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

    public void remove(String mail) {
		Utente utente = find(mail);
        em.remove(utente);
	}
    
    public void remove(Utente utente) {
    	em.remove(utente);
	}
    
    
    public Utente getPrincipalUser() {
    	return find(getPrincipalEmail());
    }
	
    
    public String getPrincipalEmail() {
    	return context.getCallerPrincipal().getName();
    }

    private UtenteDTO convertToDTO(Utente utente) {
    	UtenteDTO utenteDTO = new UtenteDTO();
    	utenteDTO.setMail(utente.getMail());
    	utenteDTO.setNome(utente.getNome());
    	utenteDTO.setCognome(utente.getCognome());
		return utenteDTO;
	}

}
