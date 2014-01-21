package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.PacchPer;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class PacchPerMgrBean
 */
@Stateless
@LocalBean
public class PacchPerMgrBean implements PacchPerMgrLocal {

	@PersistenceContext
	protected EntityManager em;

	@Resource
	private EJBContext context;
   
    public PacchPerMgrBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void addNewPacchPer(PacchPerDTO newPacchetto) {
    	PacchPer newPacchPer = new PacchPer(newPacchetto);
    	em.persist(newPacchetto);
    }


    
    
    public PacchPerDTO convertToDTO(PacchPer pacchetto) {
    	if (pacchetto == null) {
    		return null;
    	}
    	PacchPerDTO pacchDTO = new PacchPerDTO();
		return pacchDTO;
    		
    	}

    
    		
}
