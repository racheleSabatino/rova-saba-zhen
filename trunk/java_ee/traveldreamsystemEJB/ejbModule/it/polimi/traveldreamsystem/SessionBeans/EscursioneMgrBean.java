package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Escursione;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class EscursioneMgrBean
 */
@Stateless
@LocalBean
public class EscursioneMgrBean implements EscursioneMgrBeanLocal {

    /**
     * Default constructor. 
     */
    public EscursioneMgrBean() {
    }
    
    @PersistenceContext
	protected EntityManager em;

	@Resource
	private EJBContext context;
	

    @Override
	public List<EscursioneDTO> getAllEscursione() {
		List<Escursione> escursioni = em.createNamedQuery("Escursione.findAll", Escursione.class).getResultList();	
		List<EscursioneDTO> escursioniDTO = new ArrayList<EscursioneDTO>();
		for(int i=0; i<escursioni.size(); i++) {
			Escursione current = escursioni.get(i);
			escursioniDTO.add(convertToDTO(current));
		}
		return escursioniDTO;
	}
		
	public EscursioneDTO convertToDTO(Escursione escursione) {
		if (escursione == null) {
			return null;
		}
		EscursioneDTO EscursioneDTO = new EscursioneDTO();
		EscursioneDTO.setIdProdBase		(escursione.getIdProdBase());
		EscursioneDTO.setDataPartenza	(escursione.getDataPartenza());
		EscursioneDTO.setDataRitorno	(escursione.getDataRitorno());
		EscursioneDTO.setCosto			(escursione.getCosto());
		EscursioneDTO.setDescrizione	(escursione.getDescrizione());
		EscursioneDTO.setIdProdBase		(escursione.getIdProdBase());
		EscursioneDTO.setLuogo			(escursione.getLuogo());
		return EscursioneDTO;
	}

	@Override
	public void addNewEscursione(EscursioneDTO newEscursione) {
		Escursione escursione = new Escursione(newEscursione);
		em.persist(escursione);
	}

	//bisogna aggiungere che se appartiene ad un pacchetto, nn puo' essere eliminato
	@Override
	public void removeEscursione(int idEscursione) {
		Escursione escursione = findEscursione(idEscursione);
		em.remove(escursione);
		
	}
	
	private Escursione findEscursione(int idEscursione) {
		return em.find(Escursione.class, idEscursione);
		
	}

	@Override
	public EscursioneDTO findEscursioneDTO(int idEscursione) {
		Escursione escursione = findEscursione(idEscursione);
		return this.convertToDTO(escursione);
	}

	@Override
	public void update(EscursioneDTO Escursione) {
		em.merge(new Escursione(Escursione));
	}


}
