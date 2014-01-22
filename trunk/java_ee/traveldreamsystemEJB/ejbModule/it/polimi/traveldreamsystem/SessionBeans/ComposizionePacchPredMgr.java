package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Escursione;
import it.polimi.traveldreamsystem.Entities.EscursioniPacchPred;
import it.polimi.traveldreamsystem.Entities.Hotel;
import it.polimi.traveldreamsystem.Entities.HotelsPacchPred;
import it.polimi.traveldreamsystem.Entities.TrasportiPacchPred;
import it.polimi.traveldreamsystem.Entities.Trasporto;

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

    public ComposizionePacchPredMgr() {
        
    }
    
    @Override
    public void addHotelToPacch(int idPacchPred, int idHotel){
    	HotelsPacchPred composizione = new HotelsPacchPred(idPacchPred, idHotel);
		em.persist(composizione);
    }

   //Metodo che permette di eliminare un hotel da un pacchetto predefinito. Si elimina cioe' una tupla dalla relativa 
   //tabella HotelsPacchPred. Bisogna pero' aggiungere il controllo che quell'hotel non sia presente
    //in un pacchetto personalizzato associato a quel pacchetto predefinito
	@Override
	public int removeHotelToPacch(int idPacchPred, int idHotel) {
		Hotel hotelDaRimuovere;
		int risultato = -1;
		try {
			Query q = (Query) em.createQuery("SELECT i FROM HotelsPacchPred i WHERE i.idPacchPred = :idPacch AND i.idHotel = :idHotel");
    		q.setParameter("idPacch", idPacchPred);
    		q.setParameter("idHotel", idHotel);
    		hotelDaRimuovere = (Hotel) q.getSingleResult();
    		if(hotelDaRimuovere != null){
    			risultato = 0;
    			em.remove(hotelDaRimuovere);
    		}
		}
		catch(Exception e){
			e.printStackTrace();
			risultato = -1;
		}
		return risultato;
	}


	@Override
	public void addTrasportoToPacch(int idPacchPred, int idTrasporto) {
		TrasportiPacchPred composizione = new TrasportiPacchPred(idPacchPred, idTrasporto);
		em.persist(composizione);
		
	}

	@Override
	public int removeTrasportoToPacch(int idPacchPred, int idTrasporto) {
		Trasporto trasportoDaRimuovere;
		int risultato = -1;
		try {
			Query q = (Query) em.createQuery("SELECT i FROM TrasportiPacchPred i WHERE i.idPacchPred = :idPacch AND i.idHotel = :idTrasporto");
    		q.setParameter("idPacch", idPacchPred);
    		q.setParameter("idHotel", idTrasporto);
    		trasportoDaRimuovere = (Trasporto) q.getSingleResult();
    		if(trasportoDaRimuovere != null){
    			risultato = 0;
    			em.remove(trasportoDaRimuovere);
    		}
		}
		catch(Exception e){
			e.printStackTrace();
			risultato = -1;
		}
		return risultato;
	}
		

	@Override
	public void addEscursioneToPacch(int idPacchPred, int idEscursione) {
		EscursioniPacchPred composizione = new EscursioniPacchPred(idPacchPred, idEscursione);
		em.persist(composizione);
		
	}

	@Override
	public int removeEscursioneToPacch(int idPacchPred, int idEscursione) {
		Escursione escursioneDaRimuovere;
		int risultato = -1;
		try {
			Query q = (Query) em.createQuery("SELECT i FROM TrasportiPacchPred i WHERE i.idPacchPred = :idPacch AND i.idHotel = :idEscursione");
    		q.setParameter("idPacch", idPacchPred);
    		q.setParameter("idHotel", idEscursione);
    		escursioneDaRimuovere = (Escursione) q.getSingleResult();
    		if(escursioneDaRimuovere != null){
    			risultato = 0;
    			em.remove(escursioneDaRimuovere);
    		}
		}
		catch(Exception e){
			e.printStackTrace();
			risultato = -1;
		}
		return risultato;
		
	}
    


}
