package it.polimi.traveldreamsystem.SessionBeans;

import java.util.List;

import it.polimi.traveldreamsystem.Entities.HotelsPacchPer;
import it.polimi.traveldreamsystem.Entities.PacchPer;
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
    	em.persist(newPacchetto);
    }


    
    
    public PacchPerDTO convertToDTO(PacchPer pacchetto) {
    	if (pacchetto == null) {
    		return null;
    	}
    	PacchPerDTO pacchDTO = new PacchPerDTO();
		return pacchDTO;
    		
    	}

    //restitusce gli hotel di un pacchetto personalizzato
    public HotelsPacchPer getHotelsPacchPer(int idPacchPer) {
    	Query q = em.createQuery("SELECT");
    	return null;
    }
    		
    //restituisce i pacchetti personalizzati di un cliente
    public PacchPer getClientePacchPer(String mail) {
    	return null;
    }
    
    //ritorna il costo totale del pacchetto personalizzato
    public int viewCostoTotale(int idPacchPer){
    	Query q = em.createQuery("SELECT SUM(p.costo) from PACCHPER p WHERE p.idPacchPer =: idPacchPer");
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
