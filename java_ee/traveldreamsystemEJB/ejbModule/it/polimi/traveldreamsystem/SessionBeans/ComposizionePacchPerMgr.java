package it.polimi.traveldreamsystem.SessionBeans;

import java.util.ArrayList;
import java.util.List;

import it.polimi.traveldreamsystem.Entities.Escursione;
import it.polimi.traveldreamsystem.Entities.EscursioniPacchPer;
import it.polimi.traveldreamsystem.Entities.Hotel;
import it.polimi.traveldreamsystem.Entities.HotelsPacchPer;
import it.polimi.traveldreamsystem.Entities.PacchPer;
import it.polimi.traveldreamsystem.Entities.TrasportiPacchPer;
import it.polimi.traveldreamsystem.Entities.Trasporto;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ComposizionePacchPerMgr
 */
@Stateless
@LocalBean
public class ComposizionePacchPerMgr implements ComposizPacchPerMgrLocal {
	
	@PersistenceContext
	protected EntityManager em;

	HotelMgrBean hotelMgrBean;
	
	EscursioneMgrBean escursioneMgrBean;
	
	TrasportoMgrBean trasportoMgrBean;
	
	public ComposizionePacchPerMgr () {
		hotelMgrBean = new HotelMgrBean(em);
		escursioneMgrBean = new EscursioneMgrBean(em);
		trasportoMgrBean = new TrasportoMgrBean(em);
	}
	
	public ComposizionePacchPerMgr(EntityManager em) {
		this.em = em;
		hotelMgrBean = new HotelMgrBean(em);
		escursioneMgrBean = new EscursioneMgrBean(em);
		trasportoMgrBean = new TrasportoMgrBean(em);
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
		PacchPer pacchPer = em.find(PacchPer.class, idPacchPer);
		Trasporto trasporto = em.find(Trasporto.class, idTrasporto);
		TrasportiPacchPer e = new TrasportiPacchPer(trasporto, pacchPer);
		em.persist(e);
	}

	@Override
	public void removeHotelToPacchPer(int idPacchPer, int idHotel) {
		PacchPer pacchPer = em.find(PacchPer.class, idPacchPer);
		Hotel hotel = em.find(Hotel.class, idHotel);
		Query q = em.createQuery("SELECT e FROM HotelsPacchPer e "
				+ "WHERE e.pacchPer = :pacchPer AND e.hotel = :hotel");
		q.setParameter("pacchPer", pacchPer);
		q.setParameter("hotel", hotel);
		if(!q.getResultList().isEmpty()) {
			HotelsPacchPer h = (HotelsPacchPer) q.getResultList().get(0);
			em.remove(h);
		}
	}

	@Override
	public void removeEscursioneToPacchPer(int idPacchPer, int idEscursione) {
		PacchPer pacchPer = em.find(PacchPer.class, idPacchPer);
		Escursione escursione = em.find(Escursione.class, idEscursione);
		Query q = em.createQuery("SELECT e FROM EscursioniPacchPer e "
				+ "WHERE e.pacchPer = :pacchPer AND e.escursioni = :escursione");
		q.setParameter("pacchPer", pacchPer);
		q.setParameter("escursione", escursione);
		if(!q.getResultList().isEmpty()) {
			EscursioniPacchPer h = (EscursioniPacchPer) q.getResultList().get(0);
			em.remove(h);
		}
	}

	@Override
	public void removeTrasportoToPacchPer(int idPacchPer, int idTrasporto) {
		PacchPer pacchPer = em.find(PacchPer.class, idPacchPer);
		Trasporto trasporto = em.find(Trasporto.class, idTrasporto);
		Query q = em.createQuery("SELECT h FROM TrasportiPacchPer h "
				+ "WHERE p.pacchPer = :pacchPer AND h.trasporto= :trasporto");
		q.setParameter("pacchPer", pacchPer);
		q.setParameter("trasporto", trasporto);
		if(!q.getResultList().isEmpty()) {
			TrasportiPacchPer h = (TrasportiPacchPer) q.getResultList().get(0);
			em.remove(h);
		}
	}
	
	@Override
	public List<HotelDTO> getHotelsPacchPer(int idPacchPer) {
		PacchPer pacch = em.find(PacchPer.class, idPacchPer);
		Query q = em.createQuery("SELECT e FROM HotelsPacchPer h JOIN h.hotel e "
				+ "WHERE h.pacchPer = :pacch");
		q.setParameter("pacch", pacch);
		List<Hotel> hotels = (List<Hotel>) q.getResultList();
		List<HotelDTO> hotelsDTO = new ArrayList<HotelDTO>();
		for(Hotel hotel : hotels) {
			HotelDTO hotelDTO= hotelMgrBean.convertToDTO(hotel);
			hotelsDTO.add(hotelDTO);
		}
		return hotelsDTO;
	}

	@Override
	public List<EscursioneDTO> getEscursioniPacchPer(int idPacchPer) {
		Query q = em.createQuery("SELECT e FROM EscursioniPacchPer h JOIN h.pacchPer p JOIN h.escursioni e "
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
	public List<TrasportoDTO> getTrasportiPacchPer(int idPacchPer) {
		Query q = em.createQuery("SELECT e FROM TrasportiPacchPer h JOIN h.pacchPer p JOIN h.trasporto e "
				+ "WHERE p.idPacchPer = :idPacchPer");
		q.setParameter("idPacchPer", idPacchPer);
		List<Trasporto> trasporti = (List<Trasporto>) q.getResultList();
		List<TrasportoDTO> trasportiDTO = new ArrayList<TrasportoDTO>();
		for(int i=0; i < trasporti.size(); i++) {
			TrasportoDTO trasportoDTO= trasportoMgrBean.convertToDTO(trasporti.get(i));
			trasportiDTO.add(trasportoDTO);
		}
		return trasportiDTO;
	}

	@Override
	public boolean findEscursione(int idPacchPer, int idEscursione){ 
		Query q = em.createQuery("SELECT e FROM EscursioniPacchPer h JOIN h.pacchPer p JOIN h.escursioni e "
				+ "WHERE p.idPacchPer = :idPacchPer AND e.idProdBase = :idEscursione");
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
				+ "WHERE p.idPacchPer = :idPacchPer AND e.idProdBase = :idHotel");
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
				+ "WHERE p.idPacchPer = :idPacchPer AND e.idProdBase = :idTrasporto");
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
	
	@Override
	public String convertToStringHotel(int idPacchPer){
		List<HotelDTO> hotels = this.getHotelsPacchPer(idPacchPer);
		String hotelRep = new String();
		for(HotelDTO hotel: hotels) {
			hotelRep = hotelRep + hotel.toString() + "\n\n\n";
		}
		return hotelRep;
	}

	@Override
	public String convertToStringEscursione(int idPacchPer){
		List<EscursioneDTO> escursioni = this.getEscursioniPacchPer(idPacchPer);
		String escursioniRep = new String();
		for(EscursioneDTO escursione: escursioni) {
			escursioniRep = escursioniRep + escursione.toString() + "\n\n\n";
		}
		return escursioniRep;
	}
	
	@Override
	public String convertToStringTrasporto(int idPacchPer){
		List<TrasportoDTO> trasporti = this.getTrasportiPacchPer(idPacchPer);
		String trasportoRep = new String();
		for(TrasportoDTO trasporto: trasporti) {
			trasportoRep = trasportoRep + trasporto.toString() + "\n\n\n";
		}
		return trasportoRep;
	}
	
	@Override
	public void addPacchAmico(PacchPerDTO p, List<EscursioneDTO> escursioni, List<HotelDTO> hotels,
			List<TrasportoDTO> trasporti, UtenteDTO cliente) {
		PacchPerDTO nuovoDTO = new PacchPerDTO();
		nuovoDTO.setIdPacchPer(p.getIdPacchPer() + 10000);
		nuovoDTO.setListaRegali(false);
		nuovoDTO.setPacchPred(p.getPacchPred());
		nuovoDTO.setCliente(cliente);
		PacchPer nuovo = new PacchPer(nuovoDTO);
		em.persist(nuovo);
		for(EscursioneDTO e: escursioni) {
			EscursioniPacchPer h = new EscursioniPacchPer();
			h.setDataAcquisto(null);
			h.setEscursioni(new Escursione(e));
			h.setPacchPer(nuovo);
			em.persist(h);
		}
		for(HotelDTO e: hotels) {
			HotelsPacchPer h = new HotelsPacchPer();
			h.setDataAcquisto(null);
			h.setHotel(new Hotel(e));
			h.setPacchPer(nuovo);
			em.persist(h);
		}
		for(TrasportoDTO e: trasporti) {
			TrasportiPacchPer h = new TrasportiPacchPer();
			h.setDataAcquisto(null);
			h.setTrasporto(new Trasporto(e));
			h.setPacchPer(nuovo);
			em.persist(h);
		}
	}
	
	
	
	
	
	
	
	
}
    
