package it.polimi.traveldreamsystem.SessionBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.polimi.traveldreamsystem.Entities.Escursione;
import it.polimi.traveldreamsystem.Entities.EscursioniPacchPer;
import it.polimi.traveldreamsystem.Entities.Hotel;
import it.polimi.traveldreamsystem.Entities.HotelsPacchPer;
import it.polimi.traveldreamsystem.Entities.PacchPer;
import it.polimi.traveldreamsystem.Entities.TrasportiPacchPer;
import it.polimi.traveldreamsystem.Entities.Trasporto;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
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

	@Resource
	private EJBContext context;
   
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

    //restitusce gli hotel di un pacchetto personalizzato
    public List<Hotel> getHotelsPacchPer(int idPacchPer) {
    	PacchPer pacchPer = (PacchPer) em.find(PacchPer.class, idPacchPer);
    	if(pacchPer != null) {
    		List<Hotel> hotels = new ArrayList<Hotel>();
    		List<HotelsPacchPer> h = pacchPer.getHotelsPacchPer();
    		for(int i=0; i< h.size(); i++) {
    			hotels.add(h.get(i).getHotel());
    		}
    		return hotels;
    	}
    	return null;
    }
    
  //restitusce le escursioni di un pacchetto personalizzato
    public List<Escursione> getEscursioniPacchPer(int idPacchPer) {
    	PacchPer pacchPer = (PacchPer) em.find(PacchPer.class, idPacchPer);
    	if(pacchPer != null) {
    		List<Escursione> escursioni = new ArrayList<Escursione>();
    		List<EscursioniPacchPer> h = pacchPer.getEscursioniPacchPer();
    		for(int i=0; i< h.size(); i++) {
    			escursioni.add(h.get(i).getEscursioni());
    		}
    		return escursioni;
    	}
    	return null;
    }
    
  //restitusce i trasporti di un pacchetto personalizzato
    public List<Trasporto> getTrasportoPacchPer(int idPacchPer) {
    	PacchPer pacchPer = (PacchPer) em.find(PacchPer.class, idPacchPer);
    	if(pacchPer != null) {
    		List<Trasporto> trasporti = new ArrayList<Trasporto>();
    		List<TrasportiPacchPer> h = pacchPer.getTrasportiPacchPer();
    		for(int i=0; i< h.size(); i++) {
    			trasporti.add(h.get(i).getTrasporto());
    		}
    		return trasporti;
    	}
    	return null;
    }
    		
    //restituisce i pacchetti personalizzati di un cliente, è una lista perchè il cliente
    //potrebbe avere più pacchetti personalizzati
    public List<PacchPer> getClientePacchPer(String mail) {
    	List<PacchPer> pacchettiDiCliente; 
    	Query q = em.createQuery("SELECT p FROM PACCHPER WHERE p.cliente = :mail");
    	q.setParameter("mail", mail);
    	pacchettiDiCliente = (List<PacchPer>) q.getResultList();
    	if(pacchettiDiCliente != null) {
    		return pacchettiDiCliente;
    	}
    	return null;
    }
    
    
    //restituisce i pacchetti personalizzati non ancora acquistati di un cliente
    public List<PacchPer> getClientePacchPerNonAcquistati(String mail) {
    	List<PacchPer> pacchettiDiCliente; 
    	Query q = em.createQuery("SELECT p FROM PACCHPER WHERE p.cliente = :mail");
    	q.setParameter("mail", mail);
    	pacchettiDiCliente = (List<PacchPer>) q.getResultList();
    	if(pacchettiDiCliente != null) {
    		return pacchettiDiCliente;
    	}
    	return null;
    }
    
    private boolean isPacchAcquistato(PacchPer pacchetto){
    	boolean isAcquistato = false;
    	Query q = em.createQuery("SELECT p.dataAcquisto FROM HOTELSPACCHPER h WHERE h.pacchPer.idPacchPer =: id");
    	q.setParameter("", pacchetto.getIdPacchPer());
    	List<Date> dateAcquisto = (List<Date>) q.getResultList();
    	for(int i=0; i < dateAcquisto.size(); i++) {
    		if(dateAcquisto.get(i) != null) {
    			
    		}
    	}
    	return false;
    }
    
    
    //ritorna il costo totale del pacchetto personalizzato
    public int viewCostoTotale(int idPacchPer){
    	Query q = em.createQuery("SELECT SUM(p.) from PACCHPER p WHERE p.idPacchPer =: idPacchPer");
    	q.setParameter("idPacchPer", idPacchPer);
    	return (Integer) q.getSingleResult();
    }
    
    //acquista il pacchetto personalizzato, si inserisce la data di acquisto in ogni prodotto base del pacchetto
    public void acquistaPacchPer(int idPacchPer) {	
    	Query q = em.createQuery("SELECT p from PACCHPER p WHERE p.idPacchPer =: idPacchPer");
    	q.setParameter("idPacchPer", idPacchPer);
    	List<PacchPer> pacchetto = (List<PacchPer>) q.getResultList();
    }
    
    //crea la lista regali associata al pacchetto, si porta a true il valore boolean listaRegali;
    public void creaListaRegali(int idPacchPer){
    }
    
    //acquista un prodotto base di un pacchetto. Controllare che il cliente non acquisti un prodotto di una 
    //sua lista regali, che il pacchetto non sia già completamente acquistato
    public void acquistaProdListaRegali(int idProdBase, int idPacchPer, String mailAcquirente){
    }
    
    
}
