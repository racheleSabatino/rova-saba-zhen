package it.polimi.traveldreamsystem.SessionBeans;

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
import it.polimi.traveldreamsystem.dto.HotelDTO;

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

	
	public ComposizionePacchPerMgr () {
		
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
		Query q = em.createQuery("DELETE FROM HOTELSPACCHPER h JOIN h.PacchPer p JOIN h.hotel o "
				+ "WHERE p.idPacchPer = :idPacchPer AND o.idprodobase = :idHotel");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idHotel", idHotel);
	}

	@Override
	public void removeEscursioneToPacchPer(int idPacchPer, int idEscursione) {
		Query q = em.createQuery("DELETE FROM ESCURSIONIPACCHPER h JOIN h.PacchPer p JOIN h.escursioni o "
				+ "WHERE p.idPacchPer = :idPacchPer AND o.idprodobase = :idEscursione");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idEscursione", idEscursione);
	}

	@Override
	public void removeTrasportoToPacchPer(int idPacchPer, int idTrasporto) {
		Query q = em.createQuery("DELETE FROM TRASPORTIPACCHPER h JOIN h.PacchPer p JOIN h.trasporto o "
				+ "WHERE p.idPacchPer = :idPacchPer AND o.idprodobase = :idTrasporto");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idEscursione", idTrasporto);
		
	}
		
	}
    
