package it.polimi.traveldreamsystem.SessionBeans;


import java.util.List;

import it.polimi.traveldreamsystem.Entities.Utente;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class AddPacchPredMgr
 */
@Stateless
@LocalBean
public class AddPacchPredMgr implements AddPacchPredLocal {

	@PersistenceContext
	protected EntityManager em;

	@Resource
	private EJBContext context;

	
    public AddPacchPredMgr() {
        // TODO Auto-generated constructor stub
    	
    }

	@Override
	public void addNewPacchPred(PacchPredDTO newPacchetto) {
		// TODO Auto-generated method stub
		
	}
	
	


	


}