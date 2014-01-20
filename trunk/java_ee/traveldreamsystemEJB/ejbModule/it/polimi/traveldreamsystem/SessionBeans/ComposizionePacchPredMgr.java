package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.EscursioniPacchPred;
import it.polimi.traveldreamsystem.Entities.Hotel;
import it.polimi.traveldreamsystem.Entities.HotelsPacchPred;
import it.polimi.traveldreamsystem.Entities.TrasportiPacchPred;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ComposizionePacchPredMgr
 */
@Stateless
@LocalBean
public class ComposizionePacchPredMgr implements ComposizPacchPredMgrLocal {
	
	@PersistenceContext
	protected EntityManager em;

    public ComposizionePacchPredMgr() {
        
    }
    
    @Override
    public void addHotelToPacch(int idPacchPred, int idHotel){
    	HotelsPacchPred composizione = new HotelsPacchPred(idPacchPred, idHotel);
		em.persist(composizione);
    }

	@Override
	public void removeHotelToPacch(int idPacchPred, int idHotel) {
		Query q = (Query) em.createNamedQuery("SELECT i FROM HotelsPacchPred i WHERE i.idPacchPred = :idPacch AND i.idHotel = : idHotel");
    		((javax.persistence.Query) q).setParameter("idPacch", idPacchPred);
    		//((Object) q).setParamater("idHotel", idHotel);
	}
	
	//private HotelsPacchPred findHotel(int idPacchPred,int idHotel) {
		
	//}


	@Override
	public void addTrasportoToPacch(int idPacchPred, int idTrasporto) {
		TrasportiPacchPred composizione = new TrasportiPacchPred(idPacchPred, idTrasporto);
		em.persist(composizione);
		
	}

	@Override
	public void removeTrasportoToPacch(int idPacchPred, int idTrasporto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEscursioneToPacch(int idPacchPred, int idEscursione) {
		EscursioniPacchPred composizione = new EscursioniPacchPred(idPacchPred, idEscursione);
		em.persist(composizione);
		
	}

	@Override
	public void removeEscursioneToPacch(int idPacchPred, int idEscursione) {
		// TODO Auto-generated method stub
		
	}
    


}
