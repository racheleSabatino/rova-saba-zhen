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
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

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
   
    public PacchPerMgrBean() {
        
    }

    @Override
    public void addNewPacchPer(PacchPerDTO newPacchetto) {
    	PacchPer newPacchPer = new PacchPer(newPacchetto);
    	em.persist(newPacchPer);
    }
    
    
    public PacchPerDTO convertToDTO(PacchPer pacchetto) {
    	if (pacchetto == null) {
    		return null;
    	}
    	PacchPerDTO pacchDTO = new PacchPerDTO();
    	pacchDTO.setIdpacchper(pacchetto.getIdPacchPer());
    	pacchDTO.setListaRegali(pacchetto.isListaRegali());
    	pacchDTO.setIdPacchPred(pacchetto.getPacchPred().getIdPacchPred());
    	pacchDTO.setMailCliente(pacchetto.getCliente().getMail());
		return pacchDTO;
    		
    }
 
    @Override
    public List<PacchPerDTO> getAllPacchPred() {
		List<PacchPer> pacchetti = new ArrayList<PacchPer>();
		Query q = em.createQuery("SELECT p FROM PacchPer p");
		pacchetti = (List<PacchPer>) q.getResultList();
		List<PacchPerDTO> pacchettiDTO = new ArrayList<PacchPerDTO>();
		for(int i=0; i<pacchetti.size(); i++) {
			PacchPerDTO pacchettoDTO = convertToDTO(pacchetti.get(i));
			pacchettiDTO.add(pacchettoDTO);
		}
		return pacchettiDTO;
	}
    
    

    public List<PacchPer> getClientePacchPerNonAcquistati(String mail) {
    	Query q1 = em.createQuery(" SELECT distinct p FROM PacchPer p JOIN p.cliente c "
    			+ "WHERE c.mail =: mail AND "
    			+ "(EXIST { SELECT h FROM HotelsPacchPer h JOIN h.pacchPer p1 " + 
    	 "WHERE p1.idPacchPer = p.idPacchPer AND h.dataAcquisto = null } "
    	 + "OR EXIST { SELECT e FROM EscursioniPacchPer e JOIN e.pacchPer p2 " + 
    	 "WHERE p2.idPacchPer = p.idPacchPer AND e.dataAcquisto = null } "
    	 + "OR EXIST { SELECT t FROM TrasportiPacchPer t " + 
    	 "WHERE p3.idPacchPer = p.idPacchPer AND t.dataAcquisto = null })");
    	q1.setParameter("mail", mail);
    	return (List<PacchPer>)q1.getResultList();
    	
    }
    
    
    @Override
    public List<PacchPerDTO> getClientePacchPerDTONonACquistati(String mail) {
    	List<PacchPer> pacchettiNonAcquistati = this.getClientePacchPerNonAcquistati(mail);
    	List<PacchPerDTO> pacchettiDTO = new ArrayList<PacchPerDTO>();
    	for (int i=0; i < pacchettiNonAcquistati.size(); i++){
    		PacchPerDTO pacchDTO = convertToDTO(pacchettiNonAcquistati.get(i));
    		pacchettiDTO.add(pacchDTO);
    	}
    	return pacchettiDTO;
    }
    
    /*
     * restituisce i pacchetti personalizzati acquistati di un cliente. 
     */
   public List<PacchPer> getClientePacchPerAcquistati(String mail) {
    	Query q1 = em.createQuery(" SELECT distinct p FROM PacchPer p JOIN p.cliente c "
    			+ "WHERE c.mail =: mail AND "
    			+ "(NOT EXIST { SELECT h FROM HotelsPacchPer h JOIN h.pacchPer p1 " + 
    	 "WHERE p1.idPacchPer = p.idPacchPer AND h.dataAcquisto IS NULL } "
    	 + " AND NOT EXIST { SELECT e FROM EscursioniPacchPer e JOIN e.pacchPer p2 " + 
    	 "WHERE p2.idPacchPer = p.idPacchPer AND e.dataAcquisto IS NULL } "
    	 + "AND NOT EXIST { SELECT t FROM TrasportiPacchPer t JOIN t.pacchPer p3 " + 
    	 "WHERE p3.idPacchPer = p.idPacchPer AND t.dataAcquisto IS NULL })");
    	q1.setParameter("mail", mail);
    	if(q1.getResultList() != null) {
    		return (List<PacchPer>) q1.getResultList();
    	}
    	//il cliente non ha pacchetti personalizzati ancora acquistati 
    	return null;
    }
    
    @Override
    public List<PacchPerDTO> getClientePacchPerDTOACquistati(String mail) {
    	List<PacchPer> pacchettiAcquistati = this.getClientePacchPerAcquistati(mail);
    	List<PacchPerDTO> pacchettiDTO = new ArrayList<PacchPerDTO>();
    	for (int i=0; i < pacchettiAcquistati.size(); i++){
    		PacchPerDTO pacchDTO = convertToDTO(pacchettiAcquistati.get(i));
    		pacchettiDTO.add(pacchDTO);
    	}
    	return pacchettiDTO;
    }
    
    
    //ritorna il costo totale del pacchetto personalizzato
    @Override
    public int viewCostoTotale(int idPacchPer){
    	Query q = em.createQuery("SELECT SUM(h.hotel.costo + p.escursione.costo + t.trasporto.costo) "
    			+ "FROM PacchPer p JOIN p.hotelsPacchPer h JOIN p.escursioniPacchPer e JOIN p.trasportiPacchPer t "
    			+ "WHERE p.idPacchPer = :idPacchPer");
    	q.setParameter("idPacchPer", idPacchPer);
    	Integer costoTotale = (Integer) q.getSingleResult();
    	return (Integer) q.getSingleResult();

    }
    
    //acquista il pacchetto personalizzato, si inserisce la data di acquisto in ogni prodotto base del pacchetto
    @Override
    public void acquistaPacchPer(int idPacchPer) {	
    	Calendar calendar = Calendar.getInstance();
    	Date data = calendar.getTime();
    	Query q = em.createQuery("UPDATE HotelsPacchPer h SET h.dataAcquisto =: data WHERE h.idPacchPer = :idPacchPer");
    	q.setParameter("data", data);
    	Query q1 = em.createQuery("UPDATE EscursioniPacchPer h SET h.dataAcquisto =: data WHERE h.idPacchPer = :idPacchPer");
    	q1.setParameter("data", data);
    	Query q2 = em.createQuery("UPDATE TrasportiPacchPer h SET h.dataAcquisto =: data WHERE h.idPacchPer = :idPacchPer");
    	q2.setParameter("data", data);
		q.executeUpdate();
		q1.executeUpdate();
		q2.executeUpdate();
    }
   
    
    //crea la lista regali associata al pacchetto, si porta a true il valore boolean listaRegali;
    @Override
    public void creaListaRegali(int idPacchPer){
    	Query q = em.createQuery("UPDATE PacchPer p SET p.listaRegali =: lista WHERE idPacchPer = :idPacchPer");
    	q.setParameter("idPacchPer", idPacchPer);
		q.executeUpdate();
    }
    
    /*
     * acquista un prodotto base di un pacchetto. Controllare che il cliente non acquisti un prodotto di una 
     * sua lista regali, che il pacchetto non sia già completamente acquistato
     * @return -1 se l'id del pacchetto personalizzato non esiste in database
     * 		   -2 se la mail dell'acquirente non corrisponde alla mail di un cliente in database
     * 		   -3 se la mail dell'acquirente corrisponde al cliente proprietario della lista regali, cioè
     * 			un cliente non può acquistare un prodotto dalla sua lista regali
     * 			-4 se non esiste l'id dell'hotel
     * 		    0 se l'acquisto si conclude con successo
     */
    @Override
    public int acquistaHotelListaRegali(int idHotel, int idPacchPer, String mailAcquirente){
    	if(!existIdPacchPer(idPacchPer)) {
    		return -1;
    	}
    	if(!existMailUtente(mailAcquirente)){
    		return -2;
    	}
    	if(!check(mailAcquirente, idPacchPer)) {
    		return -3;
    	}
    	if(!existIdHotel(idHotel)){
    		return -4;
    	}
    	Query q = em.createQuery("SELECT h FROM HotelsPacchPer h JOIN h.pacchPer p JOIN p.cliente c JOIN h.hotel o "
    			+ "WHERE h.dataAcquisto IS NULL AND p.idPacchPer = :idPacchPer AND c.mail != :mailAcquirente "
    			+ "AND p.listaRegali = TRUE AND o.idprodbase = :idHotel");
    	q.setParameter("idPacchPer", idPacchPer);
    	q.setParameter("mailAcquirente", mailAcquirente);
    	q.setParameter("idHotel", idHotel);
    	HotelsPacchPer h = (HotelsPacchPer) q.getSingleResult();
    	Calendar calendar = Calendar.getInstance();
    	h.setDataAcquisto(calendar.getTime());
    	return 0;
    }
    
    //controlla che un utente non acquista un prodotto di una propria lista regali
    private boolean check(String mailAcquirente, int idPacchPer){
    	Query q = em.createQuery("SELECT p FROM PacchPer p JOIN p.utente u "
    			+ "WHERE p.idPacchPer = :idPacchPer AND u.mail = :mailAcquirente");
    	q.setParameter("idPacchPer", idPacchPer);
    	q.setParameter("mailAcquirente", mailAcquirente);
    	if(q.getResultList() != null) {
    		return false;
    	}
    	return true;
    }
    
    private boolean existIdPacchPer(int idPacchPer) {
    	PacchPer pacchetto = em.find(PacchPer.class, idPacchPer);
    	if(pacchetto == null) {
    		return false;
    	}
    	return true;
    }
    
    private boolean existMailUtente(String mail) {
    	Utente utente = em.find(Utente.class, mail);
    	if(utente == null) {
    		return false;
    	}
    	return true;	
    }
    
    
    private boolean existIdHotel(int idHotel) {
    	Hotel hotel = em.find(Hotel.class, idHotel);
    	if(hotel == null) {
    		return false;
    	}
    	return true;	
    }
    
    private boolean existIdEscursione(int idEscursione) {
    	Escursione escursione = em.find(Escursione.class, idEscursione);
    	if(escursione == null) {
    		return false;
    	}
    	return true;	
    }
    
    private boolean existIdTrasporto(int idTrasporto) {
    	Trasporto trasporto = em.find(Trasporto.class, idTrasporto);
    	if(trasporto == null) {
    		return false;
    	}
    	return true;	
    }
    
    
   @Override
    public int acquistaEscursioneListaRegali(int idEscursione, int idPacchPer, String mailAcquirente){
    	if(!existIdPacchPer(idPacchPer)) {
    		return -1;
    	}
    	if(!existMailUtente(mailAcquirente)){
    		return -2;
    	}
    	if(!check(mailAcquirente, idPacchPer)) {
    		return -3;
    	}
    	if(!existIdEscursione(idEscursione)){
    		return -4;
    	}
    	Query q = em.createQuery("SELECT h FROM EscursioniPacchPer h JOIN h.PacchPer p JOIN p.cliente c JOIN h.escursioni e "
    			+ "WHERE h.dataAcquisto IS NULL AND p.idPacchPer = :idPacchPer AND c.mail != :mailAcquirente "
    			+ "AND p.listaRegali = TRUE AND e.idprodbase = :idEscursione");
    	q.setParameter("idPacchPer", idPacchPer);
    	q.setParameter("mailAcquirente", mailAcquirente);
    	q.setParameter("idEscursione", idEscursione);
    	HotelsPacchPer h = (HotelsPacchPer) q.getSingleResult();
    	Calendar calendar = Calendar.getInstance();
    	h.setDataAcquisto(calendar.getTime());
    	return 0;
    }
    
   @Override
    public int acquistaTrasportoListaRegali(int idTrasporto, int idPacchPer, String mailAcquirente){
    	if(!existIdPacchPer(idPacchPer)) {
    		return -1;
    	}
    	if(!existMailUtente(mailAcquirente)){
    		return -2;
    	}
    	if(!check(mailAcquirente, idPacchPer)) {
    		return -3;
    	}
    	if(!existIdTrasporto(idTrasporto)){
    		return -4;
    	}
    	Query q = em.createQuery("SELECT h FROM TrasportiPacchPer h JOIN h.PacchPer p JOIN p.cliente c JOIN h.trasporto o "
    			+ "WHERE h.dataAcquisto IS NULL AND p.idPacchPer = :idPacchPer AND c.mail != :mailAcquirente "
    			+ "AND p.listaRegali = TRUE AND o.idprodbase =: idTrasporto");
    	q.setParameter("idPacchPer", idPacchPer);
    	q.setParameter("mailAcquirente", mailAcquirente);
    	q.setParameter("idTrasporto", idTrasporto);
    	TrasportiPacchPer h = (TrasportiPacchPer) q.getSingleResult();
    	Calendar calendar = Calendar.getInstance();
    	h.setDataAcquisto(calendar.getTime());
    	return 0;
    }
}
