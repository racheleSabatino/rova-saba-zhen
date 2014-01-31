package it.polimi.traveldreamsystem.SessionBeans;


import java.util.ArrayList;
import java.util.List;

import it.polimi.traveldreamsystem.Entities.Escursione;
import it.polimi.traveldreamsystem.Entities.EscursioniPacchPred;
import it.polimi.traveldreamsystem.Entities.HotelsPacchPred;
import it.polimi.traveldreamsystem.Entities.PacchPred;
import it.polimi.traveldreamsystem.Entities.TrasportiPacchPred;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
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
//ancora stato comprato
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

	@Override
	public List<PacchPredDTO> getAllPacchPred() {
		List<PacchPred> pacchetti = new ArrayList<PacchPred>();
		Query q = em.createQuery("SELECT p FROM PacchPred p");
		pacchetti = (List<PacchPred>) q.getResultList();
		List<PacchPredDTO> pacchettiDTO = new ArrayList<PacchPredDTO>();
		for(int i=0; i<pacchetti.size(); i++) {
			PacchPredDTO pacchettoDTO = convertToDTO(pacchetti.get(i));
			pacchettiDTO.add(pacchettoDTO);
		}
		return pacchettiDTO;
	}

	static public PacchPredDTO convertToDTO(PacchPred pacchetto) {
		if (pacchetto == null) {
			return null;
		}
		PacchPredDTO pacchettoDTO = new PacchPredDTO();
		pacchettoDTO.setDescrizione(pacchetto.getDescrizione());
		pacchettoDTO.setIdPacchPred(pacchetto.getIdPacchPred());
		return pacchettoDTO;
	}
	
	@Override
	public void update(PacchPredDTO pacchetto) {
		em.merge(new PacchPred(pacchetto));
	}
	
	@Override
	public List<PacchPredDTO> getCittaHotelPacch(String citta){
		List<PacchPred> pacchetti;
		List<PacchPred> pacchettiCercati = new ArrayList<PacchPred>();
		Query q = em.createQuery("SELECT p FROM PacchPred");
		pacchetti = (List<PacchPred>) q.getResultList();
		if(pacchetti.isEmpty()) 
			return null;
		for(PacchPred p: pacchetti) {
			Query q1 = em.createQuery("SELECT c FROM HotelsPacchPer h JOIN h.pacchPer p JOIN h.hotel c"
					+ " WHERE p.idPacchPer = :idPacchPer").setParameter("idPacchPer", p.getIdPacchPred());
			List<String> cittaa = (List<String>) q1.getResultList();
			for(String s: cittaa) {
				if(s.toLowerCase().contains(citta.toLowerCase()))
					pacchettiCercati.add(p);
			}
		}
		List<PacchPredDTO> pacchettiCercatiDTO = new ArrayList<PacchPredDTO>();
		for(PacchPred p: pacchettiCercati) {
			pacchettiCercatiDTO.add(convertToDTO(p));
		}
		return pacchettiCercatiDTO;
	}

	
	


	


}