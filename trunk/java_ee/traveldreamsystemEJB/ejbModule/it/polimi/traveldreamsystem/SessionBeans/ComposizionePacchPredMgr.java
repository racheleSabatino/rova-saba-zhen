package it.polimi.traveldreamsystem.SessionBeans;

import java.util.ArrayList;
import java.util.List;

import it.polimi.traveldreamsystem.Entities.Escursione;
import it.polimi.traveldreamsystem.Entities.EscursioniPacchPred;
import it.polimi.traveldreamsystem.Entities.Hotel;
import it.polimi.traveldreamsystem.Entities.HotelsPacchPred;
import it.polimi.traveldreamsystem.Entities.PacchPred;
import it.polimi.traveldreamsystem.Entities.TrasportiPacchPred;
import it.polimi.traveldreamsystem.Entities.Trasporto;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ComposizionePacchPredMgr
 */
@Stateless
public class ComposizionePacchPredMgr implements ComposizPacchPredMgrLocal {
	
	@PersistenceContext
	protected EntityManager em;
	
	HotelMgrBean hotelMgrBean;
	
    EscursioneMgrBean escursioneMgrBean;
    
    TrasportoMgrBean trasportoMgrBean;

    public ComposizionePacchPredMgr() {
        this.hotelMgrBean = new HotelMgrBean();
        escursioneMgrBean = new EscursioneMgrBean();
        trasportoMgrBean = new TrasportoMgrBean();
    }
    
    
    
    @Override
    public void addHotelToPacch(int idPacchPred, int idHotel){
    	Hotel hotel = em.find(Hotel.class, idHotel);
		PacchPred pacchPred = em.find(PacchPred.class, idPacchPred);
		HotelsPacchPred h = new HotelsPacchPred(pacchPred, hotel);
		em.persist(h);
    }

   //Metodo che permette di eliminare un hotel da un pacchetto predefinito. Si elimina cioe' una tupla dalla relativa 
   //tabella HotelsPacchPred. Bisogna pero' aggiungere il controllo che quell'hotel non sia presente
    //in un pacchetto personalizzato associato a quel pacchetto predefinito
	@Override
	public void removeHotelToPacch(int idPacchPred, int idHotel) {
		Query q = em.createQuery("DELETE FROM HOTELSPACCHPRED h JOIN h.PacchPred p JOIN h.hotel o "
				+ "WHERE p.idPacchPred = :idPacchPred AND o.idprodobase = :idHotel");
		q.setParameter("idPacchPred", idPacchPred);
		q.setParameter("idHotel", idHotel);
	}
		


	@Override
	public void addTrasportoToPacch(int idPacchPred, int idTrasporto) {
		Trasporto trasporto = em.find(Trasporto.class, idTrasporto);
		PacchPred pacchPred = em.find(PacchPred.class, idPacchPred);
		TrasportiPacchPred h = new TrasportiPacchPred(pacchPred, trasporto);
		em.persist(h);
		
	}

	@Override
	public void removeTrasportoToPacch(int idPacchPred, int idTrasporto) {
		Query q = em.createQuery("DELETE FROM TRASPORTIPACCHPER h JOIN h.PacchPer p JOIN h.trasporto o "
				+ "WHERE p.idPacchPred = :idPacchPred AND o.idprodobase = :idEscursione");
		q.setParameter("idPacchPred", idPacchPred);
		q.setParameter("idEscursione", idTrasporto);
	}
		

	@Override
	public void addEscursioneToPacch(int idPacchPred, int idEscursione) {
		Escursione escursione = em.find(Escursione.class, idEscursione);
		PacchPred pacchPred = em.find(PacchPred.class, idPacchPred);
		EscursioniPacchPred h = new EscursioniPacchPred(pacchPred, escursione);
		em.persist(h);
		
	}

	@Override
	public void removeEscursioneToPacch(int idPacchPred, int idEscursione) {
		Query q = em.createQuery("DELETE FROM ESCURSIONIPACCHPRED h JOIN h.idPacchPred p JOIN h.escursioni o "
				+ "WHERE p.idPacchPred = :idPacchPred AND o.idprodobase = :idEscursione");
		q.setParameter("idPacchPred", idPacchPred);
		q.setParameter("idEscursione", idEscursione);
	
	}
    


	@Override
	public List<HotelDTO> getHotelsPacchPred(int idPacchPred) {
		Query q = em.createQuery("SELECT h.hotel FROM HOTELSPACCHPRED h JOIN h.pacchPred p JOIN h.hotel e "
				+ "WHERE p.idPacchPred = :idPacchPred");
		q.setParameter("idPacchPred", idPacchPred);
		List<Hotel> hotels = (List<Hotel>) q.getResultList();
		List<HotelDTO> hotelsDTO = new ArrayList<HotelDTO>();
		for(int i=0; i < hotels.size(); i++) {
			HotelDTO hotelDTO= hotelMgrBean.convertToDTO(hotels.get(i));
			hotelsDTO.add(hotelDTO);
		}
		return hotelsDTO;
	}



	@Override
	public List<EscursioneDTO> getEscursioniPacchPred(int idPacchPred) {
		Query q = em.createQuery("SELECT h.escursioni FROM ESCURSIONIPACCHPRED h JOIN h.pacchPred p JOIN h.escursioni e "
				+ "WHERE p.idPacchPred = :idPacchPred");
		q.setParameter("idPacchPred", idPacchPred);
		List<Escursione> escursioni = (List<Escursione>) q.getResultList();
		List<EscursioneDTO> escursioniDTO = new ArrayList<EscursioneDTO>();
		for(int i=0; i < escursioni.size(); i++) {
			EscursioneDTO escursioneDTO= escursioneMgrBean.convertToDTO(escursioni.get(i));
			escursioniDTO.add(escursioneDTO);
		}
		return escursioniDTO;
	}



	@Override
	public List<TrasportoDTO> getTrasportiPacchPred(int idPacchPred) {
		Query q = em.createQuery("SELECT h.trasporto FROM HOTELSPACCHPRED h JOIN h.pacchPred p JOIN h.trasporto e "
				+ "WHERE p.idPacchPred = :idPacchPred");
		q.setParameter("idPacchPred", idPacchPred);
		List<Trasporto> trasporti = (List<Trasporto>) q.getResultList();
		List<TrasportoDTO> trasportiDTO = new ArrayList<TrasportoDTO>();
		for(int i=0; i < trasporti.size(); i++) {
			TrasportoDTO hotelDTO= trasportoMgrBean.convertToDTO(trasporti.get(i));
			trasportiDTO.add(hotelDTO);
		}
		return trasportiDTO;
	}

}