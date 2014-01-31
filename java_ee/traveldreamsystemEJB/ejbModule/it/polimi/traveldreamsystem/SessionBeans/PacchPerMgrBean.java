package it.polimi.traveldreamsystem.SessionBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.polimi.traveldreamsystem.Entities.Escursione;
import it.polimi.traveldreamsystem.Entities.Hotel;
import it.polimi.traveldreamsystem.Entities.PacchPer;
import it.polimi.traveldreamsystem.Entities.Trasporto;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import eccezioni.AcquistoProdDaPropriaLista;
import eccezioni.ErroreException;
import eccezioni.PacchettoScadutoException;
import eccezioni.ProdottoGiaAcquistato;

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
	}
	
	@PostConstruct
	public void init() {
		cmpPacchPer = new ComposizionePacchPerMgr(em);
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
						+ "WHERE p1.idPacchPer = :idPacchPer");
				Query q3 = em.createQuery("SELECT e.dataAcquisto FROM EscursioniPacchPer e JOIN e.pacchPer p1 "
						+ "WHERE p1.idPacchPer = :idPacchPer ");
				Query q4 = em.createQuery(" SELECT t.dataAcquisto FROM TrasportiPacchPer t JOIN t.pacchPer p1 "
						+ "WHERE p1.idPacchPer = :idPacchPer ");
				q2.setParameter("idPacchPer", id);
				q3.setParameter("idPacchPer", id);
				q4.setParameter("idPacchPer", id);
				List<Date> dateHotel = (List<Date>) q2.getResultList();
				List<Date> dateEscursione = (List<Date>) q3.getResultList();
				List<Date> dateTrasporto = (List<Date>) q4.getResultList();
				if(checkNull(dateHotel) || checkNull(dateEscursione) || checkNull(dateTrasporto)) 
					pacchettiNonAcquistati.add(p);
				else
					pacchettiAcquistati.add(p);
			}
			if(which == NON_ACQUISTATO) 
				return pacchettiNonAcquistati;
			else
				return pacchettiAcquistati;
	}

	//ritorna true se il pacchetto nn e stato acquistato
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
		int t1, t2, t3;
		Query q = em
				.createQuery("SELECT SUM(h1.costo)"
						+ "FROM PacchPer p JOIN p.hotelsPacchPer h JOIN h.hotel h1 " 
						+ "WHERE p.idPacchPer = :idPacchPer "
						+ "GROUP BY p.idPacchPer").setParameter("idPacchPer", idPacchPer);
		Query q2 = em
				.createQuery("SELECT SUM(e1.costo) "
						+ "FROM PacchPer p JOIN p.escursionePacchPer e "
						+ "JOIN e.escursioni e1 "
						+ "WHERE p.idPacchPer = :idPacchPer "
						+ "GROUP BY p.idPacchPer").setParameter("idPacchPer", idPacchPer);;
		Query q3 = em
				.createQuery("SELECT SUM(t1.costo) "
						+ "FROM PacchPer p JOIN p.trasportiPacchPer t "
						+ "JOIN t.trasporto t1 "
						+ "WHERE p.idPacchPer = :idPacchPer "
						+ "GROUP BY p.idPacchPer").setParameter("idPacchPer", idPacchPer);
		if(q.getResultList().isEmpty()) {
			t1 = 0;
		}
		else 
			t1 = ((Long) q.getSingleResult()).intValue();
		if(q2.getResultList().isEmpty())
			t2 = 0;
		else
			t2 = ((Long) q2.getSingleResult()).intValue();
		if(q3.getResultList().isEmpty())
			t3 = 0;
		else
			t3 = ((Long) q3.getSingleResult()).intValue();
		return t1 + t2 + t3;
	}
	
	@Override
	public int viewTotaleAcquistatoDaAmici(int idPacchPer){
		int t1, t2, t3;
		PacchPer pacch = em.find(PacchPer.class, idPacchPer);
		if(!pacch.isListaRegali()) 
			return 0;
		else {
			Query q = em
					.createQuery("SELECT SUM(h1.costo)"
							+ "FROM PacchPer p JOIN p.hotelsPacchPer h JOIN h.hotel h1 " 
							+ "WHERE p.idPacchPer = :idPacchPer AND h.dataAcquisto != :null "
							+ "AND p.listaRegali = :true "
							+ "GROUP BY p.idPacchPer").setParameter("idPacchPer", idPacchPer);
			q.setParameter("true", true);
			Query q2 = em
					.createQuery("SELECT SUM(e1.costo) "
							+ "FROM PacchPer p JOIN p.escursionePacchPer e "
							+ "JOIN e.escursioni e1 "
							+ "WHERE p.idPacchPer = :idPacchPer AND e.dataAcquisto != :null "
							+ "AND p.listaRegali = :true " 
							+ "GROUP BY p.idPacchPer").setParameter("idPacchPer", idPacchPer);
			q2.setParameter("true", true);
			Query q3 = em
					.createQuery("SELECT SUM(t1.costo) "
							+ "FROM PacchPer p JOIN p.trasportiPacchPer t "
							+ "JOIN t.trasporto t1 "
							+ "WHERE p.idPacchPer = :idPacchPer AND t.dataAcquisto != :null "
							+ "AND p.listaRegali = :true " 
							+ "GROUP BY p.idPacchPer").setParameter("idPacchPer", idPacchPer);
			q3.setParameter("true", true);
			if(q.getResultList().isEmpty()) {
				t1 = 0;
			}
			else 
				t1 = ((Long) q.getSingleResult()).intValue();
			if(q2.getResultList().isEmpty())
				t2 = 0;
			else
				t2 = ((Long) q2.getSingleResult()).intValue();
			if(q3.getResultList().isEmpty())
				t3 = 0;
			else
				t3 = ((Long) q3.getSingleResult()).intValue();
			return t1 + t2 + t3;
		}
	}

	private Date estraiDataScadenzaPacch(int idPacchPer) {
		Query q = em.createQuery("SELECT o.dataRitorno FROM HotelsPacchPer h JOIN h.pacchPer p JOIN h.hotel o "
				+ "WHERE p.idPacchPer = :idPacchPer").setParameter("idPacchPer", idPacchPer);
		Query q1 = em.createQuery("SELECT o.dataRitorno FROM EscursioniPacchPer h JOIN h.pacchPer p JOIN h.escursioni o "
				+ "WHERE p.idPacchPer = :idPacchPer").setParameter("idPacchPer", idPacchPer);
		Query q2 = em.createQuery("SELECT o.dataRitorno FROM TrasportiPacchPer h JOIN h.pacchPer p JOIN h.trasporto o "
				+ "WHERE p.idPacchPer = :idPacchPer").setParameter("idPacchPer", idPacchPer);
		List<Date> lista = (List<Date>) q.getResultList();
		List<Date> lista1 = (List<Date>) q1.getResultList();
		List<Date> lista2 = (List<Date>) q2.getResultList();
		lista.addAll(lista1);
		lista.addAll(lista2);
		return trovaMaxData(lista);
	}
	
	private Date trovaMaxData(List<Date> date) {
		Date max = date.get(0);
		for(int i=1; i < date.size() - 1; i++) {
			if(date.get(i).compareTo(date.get(i + 1)) > 0) 
				max = date.get(i);
		}
		return max;
	}
	
	// acquista il pacchetto personalizzato, si inserisce la data di acquisto in
	// ogni prodotto base del pacchetto
	@Override
	public void acquistaPacchPer(int idPacchPer) throws PacchettoScadutoException {
		Calendar calendar = Calendar.getInstance();
		Date data = calendar.getTime();
		if(this.estraiDataScadenzaPacch(idPacchPer).after(data)) {
			throw new PacchettoScadutoException("il pacchetto è scaduto");
		}
		Query q = em
				.createQuery("UPDATE HotelsPacchPer h SET h.dataAcquisto = :data "
						+ "WHERE h.idPacchPer = :idPacchPer AND h.dataAcquisto != :null")
						.setParameter("null", null);
		q.setParameter("data", data);
		Query q1 = em
				.createQuery("UPDATE EscursioniPacchPer h SET h.dataAcquisto = :data "
						+ "WHERE h.idPacchPer = :idPacchPer AND h.dataAcquisto != :null")
						.setParameter("null", null);
		q1.setParameter("data", data);
		Query q2 = em
				.createQuery("UPDATE TrasportiPacchPer h SET h.dataAcquisto = :data "
						+ "WHERE h.idPacchPer = :idPacchPer AND h.dataAcquisto != :null")
						.setParameter("null", null);
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
				.createQuery("UPDATE PacchPer p SET p.listaRegali = :lista "
						+ "WHERE p.idPacchPer = :idPacchPer");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("lista", true);
		q.executeUpdate();
	}

	
	@Override
	public void acquistaHotelListaRegali(int idHotel, int idPacchPer, String mailAcquirente) 
		throws AcquistoProdDaPropriaLista, ProdottoGiaAcquistato {
		if(this.check(mailAcquirente, idPacchPer))
			throw new AcquistoProdDaPropriaLista("non puoi acquistare un prodotto da una propria lista regali");
		if(this.ckeckHotelGiaAcquistato(idPacchPer, idHotel))
			throw new ProdottoGiaAcquistato("il prodotto e' gia' stato acquistato");
		Hotel e = em.find(Hotel.class, idHotel);
		PacchPer p = em.find(PacchPer.class, idPacchPer);
		Query q2 = em.createQuery("UPDATE HotelsPacchPer e SET e.dataAcquisto = :data "
				+ "WHERE e.hotel = :hotel AND e.pacchPer = :pacchPer");
		Calendar calendar = Calendar.getInstance();
		Date dataAcquisto = calendar.getTime();
		q2.setParameter("data", dataAcquisto);
		q2.setParameter("hotel", e);
		q2.setParameter("pacchPer", p);
		q2.executeUpdate();
	}

	// controlla che un utente non acquista un prodotto di una propria lista
	// regali, ritorna falsa se la lista è vuota, cioè la mail del cliente è diversa da quello dell'acquirente
	private boolean check(String mailAcquirente, int idPacchPer)  {
		Query q = em
				.createQuery("SELECT p FROM PacchPer p JOIN p.cliente u "
						+ "WHERE p.idPacchPer = :idPacchPer AND u.mail = :mailAcquirente");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("mailAcquirente", mailAcquirente);
		if (q.getResultList().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean ckeckHotelGiaAcquistato(int idPacchPer, int idProdBase) {
		Query q = em.createQuery("SELECT h.dataAcquisto FROM HotelsPacchPer h JOIN h.pacchPer p JOIN h.hotel o "
				+ "WHERE p.idPacchPer = :idPacchPer AND o.idProdBase = :idProdBase");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idProdBase", idProdBase);
		if((q.getResultList().get(0)) == null) 
			return false;
		else
			return true;
	}

	@Override
	public boolean ckeckEscursioneGiaAcquistata(int idPacchPer, int idProdBase){
		Query q = em.createQuery("SELECT h.dataAcquisto FROM EscursioniPacchPer h JOIN h.pacchPer p "
				+ "JOIN h.escursioni o "
				+ "WHERE p.idPacchPer = :idPacchPer AND o.idProdBase = :idProdBase");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idProdBase", idProdBase);
		if((q.getResultList().get(0)) == null) 
			return false;
		else
			return true;
	}

	@Override
	public boolean ckeckTrasportoGiaAcquistato(int idPacchPer, int idProdBase) {
		Query q = em.createQuery("SELECT h.dataAcquisto FROM TrasportiPacchPer h JOIN h.pacchPer p "
				+ "JOIN h.trasporto o "
				+ "WHERE p.idPacchPer = :idPacchPer AND o.idProdBase = :idProdBase");
		q.setParameter("idPacchPer", idPacchPer);
		q.setParameter("idProdBase", idProdBase);
		if((q.getResultList().get(0)) == null) 
			return false;
		else
			return true;
	}

	
	@Override
	public void acquistaEscursioneListaRegali(int idEscursione, int idPacchPer, String mailAcquirente) throws AcquistoProdDaPropriaLista, ProdottoGiaAcquistato {
			if(this.check(mailAcquirente, idPacchPer))
				throw new AcquistoProdDaPropriaLista("non puoi acquistare un prodotto da una propria lista regali");
			if(this.ckeckEscursioneGiaAcquistata(idPacchPer, idEscursione))
				throw new ProdottoGiaAcquistato("il prodotto e' gia' stato acquistato");
			Escursione e = em.find(Escursione.class, idEscursione);
			PacchPer p = em.find(PacchPer.class, idPacchPer);
			Query q2 = em.createQuery("UPDATE EscursioniPacchPer e SET e.dataAcquisto = :data "
					+ "WHERE e.escursioni = :escursione AND e.pacchPer = :pacchPer");
			Calendar calendar = Calendar.getInstance();
			Date dataAcquisto = calendar.getTime();
			
			q2.setParameter("data", dataAcquisto);
			q2.setParameter("escursione", e);
			q2.setParameter("pacchPer", p);
			q2.executeUpdate();
	}

	@Override
	public void acquistaTrasportoListaRegali(int idTrasporto, int idPacchPer, String mailAcquirente)
			throws AcquistoProdDaPropriaLista, ProdottoGiaAcquistato {
		if(this.check(mailAcquirente, idPacchPer))
			throw new AcquistoProdDaPropriaLista("non puoi acquistare un prodotto da una propria lista regali");
		if(this.ckeckTrasportoGiaAcquistato(idPacchPer, idTrasporto))
			throw new ProdottoGiaAcquistato("il prodotto e' gia' stato acquistato");
		Trasporto e = em.find(Trasporto.class, idTrasporto);
		PacchPer p = em.find(PacchPer.class, idPacchPer);
		Query q2 = em.createQuery("UPDATE TrasportiPacchPer e SET e.dataAcquisto = :data "
				+ "WHERE e.trasporto = :trasporto AND e.pacchPer = :pacchPer");
		Calendar calendar = Calendar.getInstance();
		Date dataAcquisto = calendar.getTime();
		q2.setParameter("data", dataAcquisto);
		q2.setParameter("trasporto", e);
		q2.setParameter("pacchPer", p);
		q2.executeUpdate();
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
