package it.polimi.traveldreamsystem.SessionBeans;

import java.util.ArrayList;
import java.util.List;

import it.polimi.traveldreamsystem.Entities.Escursione;
import it.polimi.traveldreamsystem.Entities.EscursioniPacchPer;
import it.polimi.traveldreamsystem.Entities.EscursioniPacchPred;
import it.polimi.traveldreamsystem.Entities.Hotel;
import it.polimi.traveldreamsystem.Entities.HotelsPacchPer;
import it.polimi.traveldreamsystem.Entities.HotelsPacchPred;
import it.polimi.traveldreamsystem.Entities.PacchPer;
import it.polimi.traveldreamsystem.Entities.TrasportiPacchPer;
import it.polimi.traveldreamsystem.Entities.TrasportiPacchPred;
import it.polimi.traveldreamsystem.Entities.Trasporto;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ComposizionePacchPredMgr
 */
@Stateless
@LocalBean
public class ComposizionePacchPerMgr implements ComposizPaccPerMgrLocal {
	
	@PersistenceContext
	protected EntityManager em;

	HotelMgrBean hotelMgrBean;
	
	EscursioneMgrBean escursioneMgrBean;
	
	TrasportoMgrBean trasportoMgrBean;
	
	public ComposizionePacchPerMgr () {
		hotelMgrBean = new HotelMgrBean();
		escursioneMgrBean = new EscursioneMgrBean();
		trasportoMgrBean = new TrasportoMgrBean();
	}
	
	@Override
	public void addHotelToPacchPer(int idPacchPer, int idHotel) {
		Hotel hotel = em.find(Hotel.class, idHotel);
		PacchPer pacchPer = em.find(PacchPer.class, idPacchPer);
		HotelsPacchPer h = new HotelsPacchPer(hotel, pacchPer);
		em.persist(h);
	}
	
	@Override
	public void addEscursioneToPacchPer(int idPacchPer, int idEscursione){
		Escursione escursione = em.find(Escursione.class, idEscursione);
		PacchPer pacchPer = em.find(PacchPer.class, idPacchPer);
		EscursioniPacchPer e = new EscursioniPacchPer(escursione, pacchPer);
		em.persist(e);
	}

	@Override
	public void addTrasportoToPacchPer(int idPacchPer, int idTrasporto) {
		Trasporto trasporto = em.find(Trasporto.class, idTrasporto);
		PacchPer pacchPer = em.find(PacchPer.class, idPacchPer);
		TrasportiPacchPer e = new TrasportiPacchPer(trasporto, pacchPer);
		em.persist(e);
		
	}

	@Override
	public void removeHotelToPacchPer(int idPacchPer, int idHotel) {
		Query q = em.createQuery("DELETE FROM HotelsPacchPer h JOIN h.PacchPer p JOIN h.hotel o "
				+ "WHERE p.idPacchPer = :idPacchPer AND o.idprodbase = :idHotel");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idHotel", idHotel);
	}

	@Override
	public void removeEscursioneToPacchPer(int idPacchPer, int idEscursione) {
		Query q = em.createQuery("DELETE FROM EscursioniPacchPer h JOIN h.PacchPer p JOIN h.escursioni o "
				+ "WHERE p.idPacchPer = :idPacchPer AND o.idprodbase = :idEscursione");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idEscursione", idEscursione);
	}

	@Override
	public void removeTrasportoToPacchPer(int idPacchPer, int idTrasporto) {
		Query q = em.createQuery("DELETE FROM TrasportiPacchPer h JOIN h.PacchPer p JOIN h.trasporto o "
				+ "WHERE p.idPacchPer = :idPacchPer AND o.idprodbase = :idTrasporto");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idEscursione", idTrasporto);
		
	}
	
	@Override
	public List<HotelDTO> getHotelsPacchPer(int idPacchPer) {
		Query q = em.createQuery("SELECT e FROM HotelsPacchPer h JOIN h.pacchPer p JOIN h.hotel e "
				+ "WHERE p.idPacchPer = :idPacchPer");
		q.setParameter("idPacchPer", idPacchPer);
		List<Hotel> hotels = (List<Hotel>) q.getResultList();
		List<HotelDTO> hotelsDTO = new ArrayList<HotelDTO>();
		for(int i=0; i < hotels.size(); i++) {
			HotelDTO hotelDTO= hotelMgrBean.convertToDTO(hotels.get(i));
			hotelsDTO.add(hotelDTO);
		}
		return hotelsDTO;
	}



	@Override
	public List<EscursioneDTO> getEscursioniPacchPer(int idPacchPer) {
		Query q = em.createQuery("SELECT e FROM EscursioniPacchPer h JOIN h.pacchPred p JOIN h.escursioni e "
				+ "WHERE p.idPacchPer = :idPacchPer");
		q.setParameter("idPacchPer", idPacchPer);
		List<Escursione> escursioni = (List<Escursione>) q.getResultList();
		List<EscursioneDTO> escursioniDTO = new ArrayList<EscursioneDTO>();
		for(int i=0; i < escursioni.size(); i++) {
			EscursioneDTO escursioneDTO = escursioneMgrBean.convertToDTO(escursioni.get(i));
			escursioniDTO.add(escursioneDTO);
		}
		return escursioniDTO;
	}



	@Override
	public List<TrasportoDTO> getTrasportiPacchPred(int idPacchPer) {
		Query q = em.createQuery("SELECT h.trasporto FROM TrasportiPacchPer h JOIN h.pacchPred p JOIN h.trasporto e "
				+ "WHERE p.idPacchPer = :idPacchPer");
		q.setParameter("idPacchPer", idPacchPer);
		List<Trasporto> trasporti = (List<Trasporto>) q.getResultList();
		List<TrasportoDTO> trasportiDTO = new ArrayList<TrasportoDTO>();
		for(int i=0; i < trasporti.size(); i++) {
			TrasportoDTO hotelDTO= trasportoMgrBean.convertToDTO(trasporti.get(i));
			trasportiDTO.add(hotelDTO);
		}
		return trasportiDTO;
	}

	@Override
	public boolean findEscursione(int idPacchPer, int idEscursione){ 
		Query q = em.createQuery("SELECT e FROM EscursioniPacchPer h JOIN h.pacchPer p JOIN h.escursioni e "
				+ "WHERE p.idPacchPer = : idPacchPer AND e.idprodbase = :idEscursione");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idEscursione", idEscursione);
		List list = q.getResultList();
		if(list.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public boolean findHotel(int idPacchPer, int idHotel){ 
		Query q = em.createQuery("SELECT e FROM HotelsPacchPer h JOIN h.pacchPer p JOIN h.hotel e "
				+ "WHERE p.idPacchPer = : idPacchPer AND e.idprodbase = :idHotel");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idHotel", idHotel);
		List list = q.getResultList();
		if(list.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public boolean findTrasporto(int idPacchPer, int idTrasporto){ 
		Query q = em.createQuery("SELECT e FROM TrasportiPacchPer h JOIN h.pacchPer p JOIN h.trasporto e "
				+ "WHERE p.idPacchPer = : idPacchPer AND e.idprodbase = :idTrasporto");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idTrasporto", idTrasporto);
		List list = q.getResultList();
		if(list.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}
		
	}
    
