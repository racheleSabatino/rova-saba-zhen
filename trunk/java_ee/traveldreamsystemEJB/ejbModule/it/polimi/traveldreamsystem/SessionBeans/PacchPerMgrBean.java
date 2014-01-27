package it.polimi.traveldreamsystem.SessionBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.polimi.traveldreamsystem.Entities.Escursione;
import it.polimi.traveldreamsystem.Entities.EscursioniPacchPer;
import it.polimi.traveldreamsystem.Entities.Hotel;
import it.polimi.traveldreamsystem.Entities.HotelsPacchPer;
import it.polimi.traveldreamsystem.Entities.PacchPer;
import it.polimi.traveldreamsystem.Entities.PacchPred;
import it.polimi.traveldreamsystem.Entities.TrasportiPacchPer;
import it.polimi.traveldreamsystem.Entities.Trasporto;
import it.polimi.traveldreamsystem.Entities.Utente;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class PacchPerMgrBean
 */
@Stateless
@LocalBean
public class PacchPerMgrBean implements PacchPerMgrLocal {

	@PersistenceContext
	protected EntityManager em;
	
	ComposizionePacchPerMgr cmpPacchPer;
	
	public final static int ACQUISTATO = 0;
	
	public final static int NON_ACQUISTATO = 1;

	public PacchPerMgrBean() {
		cmpPacchPer = new ComposizionePacchPerMgr();
	}


	@Override
	public void addNewPacchPer(PacchPerDTO newPacchetto) {
		PacchPer newPacchPer = new PacchPer(newPacchetto);
		em.persist(newPacchPer);
	}

	static public PacchPerDTO convertToDTO(PacchPer pacchetto) {
		if (pacchetto == null) {
			return null;
		}
		PacchPerDTO pacchDTO = new PacchPerDTO();
		pacchDTO.setIdPacchPer(pacchetto.getIdPacchPer());
		pacchDTO.setListaRegali(pacchetto.isListaRegali());
		pacchDTO.setPacchPred(PacchPredMgr.convertToDTO(pacchetto.getPacchPred()));
		pacchDTO.setCliente(UtenteMgrBean.convertToDTO(pacchetto.getCliente()));
		return pacchDTO;

	}

	@Override
	public void removePacchPer(int idPacchPer) {
		PacchPer pacchetto = em.find(PacchPer.class, idPacchPer);
		List<HotelDTO> hotels = cmpPacchPer.getHotelsPacchPer(idPacchPer);
		List<EscursioneDTO> escursioni = cmpPacchPer.getEscursioniPacchPer(idPacchPer);
		List<TrasportoDTO> trasporti = cmpPacchPer.getTrasportiPacchPer(idPacchPer);
		for(int i=0; i < hotels.size(); i++) {
			cmpPacchPer.removeHotelToPacchPer(idPacchPer, hotels.get(i).getIdProdBase());
		}
		for(int i=0; i < escursioni.size(); i++) {
			cmpPacchPer.removeEscursioneToPacchPer(idPacchPer, escursioni.get(i).getIdProdBase());
		}
		for(int i=0; i < trasporti.size(); i++) {
			cmpPacchPer.removeHotelToPacchPer(idPacchPer, trasporti.get(i).getIdProdBase());
		}
		em.remove(pacchetto);
	}
	
	@Override
	public List<PacchPerDTO> getAllPacchPer() {
		List<PacchPer> pacchetti = new ArrayList<PacchPer>();
		Query q = em.createQuery("SELECT p FROM PacchPer p");
		pacchetti = (List<PacchPer>) q.getResultList();
		List<PacchPerDTO> pacchettiDTO = new ArrayList<PacchPerDTO>();
		for (int i = 0; i < pacchetti.size(); i++) {
			PacchPerDTO pacchettoDTO = convertToDTO(pacchetti.get(i));
			pacchettiDTO.add(pacchettoDTO);
		}
		return pacchettiDTO;
	}

	
	public List<PacchPer> getClientePacchPer(String mail, int which) {
		List<PacchPer> pacchetti = getClientePacchPer(mail);
		List<PacchPer> pacchettiNonAcquistati = new ArrayList<PacchPer>();
		List<PacchPer> pacchettiAcquistati = new ArrayList<PacchPer>();
			for(PacchPer p: pacchetti) {
				int id = p.getIdPacchPer();
				Query q2 = em.createQuery("SELECT h.dataAcquisto FROM HotelsPacchPer h JOIN h.pacchPer p1 "
						+ "WHERE p1.idPacchPer = p.idPacchPer");
				Query q3 = em.createQuery("SELECT e.dataAcquisto FROM EscursioniPacchPer e JOIN e.pacchPer p2 "
						+ "WHERE p2.idPacchPer = p.idPacchPer ");
				Query q4 = em.createQuery(" SELECT t.dataAcquisto FROM TrasportiPacchPer t "
						+ "WHERE p3.idPacchPer = p.idPacchPer ");
				q2.setParameter("idPacchPer", id);
				q3.setParameter("idPacchPer", id);
				q4.setParameter("idPacchPer", id);
				List<Date> dateHotel = (List<Date>) q2.getResultList();
				List<Date> dateEscursione = (List<Date>) q3.getResultList();
				List<Date> dateTrasporto = (List<Date>) q4.getResultList();
				if(which == NON_ACQUISTATO) {
					if(checkNull(dateHotel) || checkNull(dateEscursione) || checkNull(dateTrasporto)) 
						pacchettiNonAcquistati.add(p);
				}
				else {
						pacchettiAcquistati.add(p);
				}
			}
			if(which == NON_ACQUISTATO) 
				return pacchettiNonAcquistati;
			else
				return pacchettiAcquistati;
	}

	//utilizzato per verificare se almeno un elemento della lista è nullo
	private boolean checkNull(List<Date> liste){
		for(int i=0; i < liste.size(); i++) {
			if(liste.get(i) == null)
				return true;
		}
		return false;
	}
	
	public List<PacchPer> getClientePacchPer(String mail) {
		Query q = em.createQuery("SELECT p FROM PacchPer p JOIN p.cliente c "
				+ "WHERE c.mail = :mail");
		q.setParameter("mail", mail);
		return (List<PacchPer>) q.getResultList();
	}
	
	@Override
	public List<PacchPerDTO> getClientePacchPerDTONonAcquistati(String mail) {
		List<PacchPer> pacchettiNonAcquistati = this.getClientePacchPer(mail, NON_ACQUISTATO);
		List<PacchPerDTO> pacchettiDTO = new ArrayList<PacchPerDTO>();
		for (int i = 0; i < pacchettiNonAcquistati.size(); i++) {
			PacchPerDTO pacchDTO = convertToDTO(pacchettiNonAcquistati.get(i));
			pacchettiDTO.add(pacchDTO);
		}
		return pacchettiDTO;
	}


	@Override
	public List<PacchPerDTO> getClientePacchPerDTOAcquistati(String mail) {
		List<PacchPer> pacchettiAcquistati = this.getClientePacchPer(mail, ACQUISTATO);
				
		List<PacchPerDTO> pacchettiDTO = new ArrayList<PacchPerDTO>();
		for (int i = 0; i < pacchettiAcquistati.size(); i++) {
			PacchPerDTO pacchDTO = convertToDTO(pacchettiAcquistati.get(i));
			pacchettiDTO.add(pacchDTO);
		}
		return pacchettiDTO;
	}

	// ritorna il costo totale del pacchetto personalizzato
	@Override
	public int viewCostoTotale(int idPacchPer) {
		Query q = em
				.createQuery("SELECT SUM(h.hotel.costo + p.escursione.costo + t.trasporto.costo) "
						+ "FROM PacchPer p JOIN p.hotelsPacchPer h JOIN p.escursioniPacchPer e JOIN p.trasportiPacchPer t "
						+ "WHERE p.idPacchPer = :idPacchPer");
		q.setParameter("idPacchPer", idPacchPer);
		Integer costoTotale = (Integer) q.getSingleResult();
		return (Integer) q.getSingleResult();

	}

	// acquista il pacchetto personalizzato, si inserisce la data di acquisto in
	// ogni prodotto base del pacchetto
	@Override
	public void acquistaPacchPer(int idPacchPer) {
		Calendar calendar = Calendar.getInstance();
		Date data = calendar.getTime();
		Query q = em
				.createQuery("UPDATE HotelsPacchPer h SET h.dataAcquisto =: data WHERE h.idPacchPer = :idPacchPer");
		q.setParameter("data", data);
		Query q1 = em
				.createQuery("UPDATE EscursioniPacchPer h SET h.dataAcquisto =: data WHERE h.idPacchPer = :idPacchPer");
		q1.setParameter("data", data);
		Query q2 = em
				.createQuery("UPDATE TrasportiPacchPer h SET h.dataAcquisto =: data WHERE h.idPacchPer = :idPacchPer");
		q2.setParameter("data", data);
		q.executeUpdate();
		q1.executeUpdate();
		q2.executeUpdate();
	}

	// crea la lista regali associata al pacchetto, si porta a true il valore
	// boolean listaRegali;
	@Override
	public void creaListaRegali(int idPacchPer) {
		Query q = em
				.createQuery("UPDATE PacchPer p SET p.listaRegali =: lista WHERE idPacchPer = :idPacchPer");
		q.setParameter("idPacchPer", idPacchPer);
		q.executeUpdate();
	}

	/*
	 * acquista un prodotto base di un pacchetto. Controllare che il cliente non
	 * acquisti un prodotto di una sua lista regali, che il pacchetto non sia
	 * gia completamente acquistato
	 * 
	 * @return -1 se l'id del pacchetto personalizzato non esiste in database -2
	 * se la mail dell'acquirente non corrisponde alla mail di un cliente in
	 * database -3 se la mail dell'acquirente corrisponde al cliente
	 * proprietario della lista regali, cioe un cliente non puo acquistare un
	 * prodotto dalla sua lista regali -4 se non esiste l'id dell'hotel 0 se
	 * l'acquisto si conclude con successo
	 */
	@Override
	public int acquistaHotelListaRegali(int idHotel, int idPacchPer,
			String mailAcquirente) {
		if (!existIdPacchPer(idPacchPer)) {
			return -1;
		}
		if (!existMailUtente(mailAcquirente)) {
			return -2;
		}
		if (!check(mailAcquirente, idPacchPer)) {
			return -3;
		}
		if (!existIdHotel(idHotel)) {
			return -4;
		}
		Query q = em
				.createQuery("SELECT h FROM HotelsPacchPer h JOIN h.pacchPer p JOIN p.cliente c JOIN h.hotel o "
						+ "WHERE h.dataAcquisto IS NULL AND p.idPacchPer = :idPacchPer AND c.mail != :mailAcquirente "
						+ "AND p.listaRegali = TRUE AND o.idProdBase = :idHotel");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("mailAcquirente", mailAcquirente);
		q.setParameter("idHotel", idHotel);
		HotelsPacchPer h = (HotelsPacchPer) q.getSingleResult();
		Calendar calendar = Calendar.getInstance();
		h.setDataAcquisto(calendar.getTime());
		return 0;
	}

	// controlla che un utente non acquista un prodotto di una propria lista
	// regali
	private boolean check(String mailAcquirente, int idPacchPer) {
		Query q = em
				.createQuery("SELECT p FROM PacchPer p JOIN p.utente u "
						+ "WHERE p.idPacchPer = :idPacchPer AND u.mail = :mailAcquirente");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("mailAcquirente", mailAcquirente);
		if (q.getResultList() != null) {
			return false;
		}
		return true;
	}

	private boolean existIdPacchPer(int idPacchPer) {
		PacchPer pacchetto = em.find(PacchPer.class, idPacchPer);
		if (pacchetto == null) {
			return false;
		}
		return true;
	}

	private boolean existMailUtente(String mail) {
		Utente utente = em.find(Utente.class, mail);
		if (utente == null) {
			return false;
		}
		return true;
	}

	private boolean existIdHotel(int idHotel) {
		Hotel hotel = em.find(Hotel.class, idHotel);
		if (hotel == null) {
			return false;
		}
		return true;
	}

	private boolean existIdEscursione(int idEscursione) {
		Escursione escursione = em.find(Escursione.class, idEscursione);
		if (escursione == null) {
			return false;
		}
		return true;
	}

	private boolean existIdTrasporto(int idTrasporto) {
		Trasporto trasporto = em.find(Trasporto.class, idTrasporto);
		if (trasporto == null) {
			return false;
		}
		return true;
	}

	@Override
	public int acquistaEscursioneListaRegali(int idEscursione, int idPacchPer,
			String mailAcquirente) {
		if (!existIdPacchPer(idPacchPer)) {
			return -1;
		}
		if (!existMailUtente(mailAcquirente)) {
			return -2;
		}
		if (!check(mailAcquirente, idPacchPer)) {
			return -3;
		}
		if (!existIdEscursione(idEscursione)) {
			return -4;
		}
		Query q = em
				.createQuery("SELECT h FROM EscursioniPacchPer h JOIN h.PacchPer p JOIN p.cliente c JOIN h.escursioni e "
						+ "WHERE h.dataAcquisto IS NULL AND p.idPacchPer = :idPacchPer AND c.mail != :mailAcquirente "
						+ "AND p.listaRegali = TRUE AND e.idProdBase = :idEscursione");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("mailAcquirente", mailAcquirente);
		q.setParameter("idEscursione", idEscursione);
		HotelsPacchPer h = (HotelsPacchPer) q.getSingleResult();
		Calendar calendar = Calendar.getInstance();
		h.setDataAcquisto(calendar.getTime());
		return 0;
	}

	@Override
	public int acquistaTrasportoListaRegali(int idTrasporto, int idPacchPer,
			String mailAcquirente) {
		if (!existIdPacchPer(idPacchPer)) {
			return -1;
		}
		if (!existMailUtente(mailAcquirente)) {
			return -2;
		}
		if (!check(mailAcquirente, idPacchPer)) {
			return -3;
		}
		if (!existIdTrasporto(idTrasporto)) {
			return -4;
		}
		Query q = em
				.createQuery("SELECT h FROM TrasportiPacchPer h JOIN h.PacchPer p JOIN p.cliente c JOIN h.trasporto o "
						+ "WHERE h.dataAcquisto IS NULL AND p.idPacchPer = :idPacchPer AND c.mail != :mailAcquirente "
						+ "AND p.listaRegali = TRUE AND o.idProdBase =: idTrasporto");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("mailAcquirente", mailAcquirente);
		q.setParameter("idTrasporto", idTrasporto);
		TrasportiPacchPer h = (TrasportiPacchPer) q.getSingleResult();
		Calendar calendar = Calendar.getInstance();
		h.setDataAcquisto(calendar.getTime());
		return 0;
	}

	@Override
	public void update(PacchPerDTO pacchetto) {
		em.merge(new PacchPer(pacchetto));
	}

	@Override
	public PacchPerDTO findPacchPerDTO(int idPacchPer) {
		PacchPer pacchetto = em.find(PacchPer.class, idPacchPer);
		return this.convertToDTO(pacchetto);
	}
}
