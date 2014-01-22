package it.polimi.traveldreamsystem.SessionBeans;


import java.util.ArrayList;
import java.util.List;

import it.polimi.traveldreamsystem.Entities.EscursioniPacchPred;
import it.polimi.traveldreamsystem.Entities.HotelsPacchPred;
import it.polimi.traveldreamsystem.Entities.PacchPred;
import it.polimi.traveldreamsystem.Entities.TrasportiPacchPred;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class AddPacchPredMgr
 */
@Stateless
@LocalBean
public class PacchPredMgr implements PacchPredMgrLocal {

	@PersistenceContext
	protected EntityManager em;

	@Resource
	private EJBContext context;

	
    public PacchPredMgr() {
    	
    }

	@Override
	public void addNewPacchPred(PacchPredDTO newPacchetto) {
		PacchPred newPacchPred = new PacchPred(newPacchetto);
		em.persist(newPacchPred);
	}

//bisogna aggiungere il controllo che non deve essere associato ad un pacchetto personalizzato che non 
//è ancora stato comprato
	@Override
	public void removePacchPred(int idPacchPred) {
		PacchPred pacchetto = findPacchPred(idPacchPred);
		em.remove(pacchetto);
		List<HotelsPacchPred> hotels;
		Query q1 = em.createQuery("SELECT h FROM HotelsPacchPred WHERE h.idPacchPred= :idPacchPred");
		q1.setParameter("idPacchPred", idPacchPred);
		hotels = (List<HotelsPacchPred>) q1.getResultList();
		for(int i=0; i< hotels.size(); i++) {
			em.remove(hotels.get(i));
		}
		List<TrasportiPacchPred> trasporti;
		Query q2 = em.createQuery("SELECT h FROM TrasportiPacchPred WHERE h.idPacchPred= :idPacchPred");
		q2.setParameter("idPacchPred", idPacchPred);
		trasporti = (List<TrasportiPacchPred>) q2.getResultList();
		for(int i=0; i< trasporti.size(); i++) {
			em.remove(trasporti.get(i));
		}
		List<EscursioniPacchPred> escursioni;
		Query q3 = em.createQuery("SELECT h FROM EscursioniPacchPred WHERE h.idPacchPred= :idPacchPred");
		q3.setParameter("idPacchPred", idPacchPred);
		escursioni = (List<EscursioniPacchPred>) q3.getResultList();
		for(int i=0; i< escursioni.size(); i++) {
			em.remove(escursioni.get(i));
		}
	}

	
	public PacchPred findPacchPred(int idPacchPred) {
		return em.find(PacchPred.class, idPacchPred);
		
	}
	
	@Override
	public PacchPredDTO findPacchPredDTO(int idPacchPred) {
		PacchPred pacchetto = findPacchPred(idPacchPred);
		return this.convertToDTO(pacchetto);
	}

	public List<PacchPredDTO> getAllPacchPred() {
		List<PacchPred> pacchetti = new ArrayList<PacchPred>();
		pacchetti = em.createNamedQuery("PacchPred.findALL", PacchPred.class).getResultList();
		List<PacchPredDTO> pacchettiDTO = new ArrayList<PacchPredDTO>();
		for(int i=0; i<pacchetti.size(); i++) {
			PacchPredDTO pacchettoDTO = convertToDTO(pacchetti.get(i));
			pacchettiDTO.add(pacchettoDTO);
		}
		return pacchettiDTO;
	}

	public PacchPredDTO convertToDTO(PacchPred pacchetto) {
		if (pacchetto == null) {
			return null;
		}
		PacchPredDTO pacchettoDTO = new PacchPredDTO();
		pacchettoDTO.setDescrizione(pacchetto.getDescrizione());
		pacchettoDTO.setIdPacchpred(pacchetto.getIdPacchPred());
		return pacchettoDTO;
	}

	@Override
	public void modificaPacchPred(PacchPredDTO pacchetto) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	


	


}