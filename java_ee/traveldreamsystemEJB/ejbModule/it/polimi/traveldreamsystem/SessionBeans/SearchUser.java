package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Utente;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class SearchUser
 */
@Stateless
@LocalBean
public class SearchUser {

    /**
     * Default constructor. 
     */
    public SearchUser() {
    }
    
    @PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;

	
	public String searchUserByMail(String mail) {
		
		return null;
	}

	public String searchUserByCognome(String cognome) {
		
		return null;
	}

    private UtenteDTO convertToDTO(Utente utente) {
    	UtenteDTO utenteDTO = new UtenteDTO();
    	utenteDTO.setMail(utente.getMail());
    	utenteDTO.setNome(utente.getNome());
    	utenteDTO.setCognome(utente.getCognome());
		return utenteDTO;
	}

}

