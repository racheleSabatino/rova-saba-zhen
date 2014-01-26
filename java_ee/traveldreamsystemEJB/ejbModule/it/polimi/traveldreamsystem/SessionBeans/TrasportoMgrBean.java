package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Trasporto;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean

public class TrasportoMgrBean implements TrasportoMgrBeanLocal{
    /**
     * Default constructor. 
     */
    public TrasportoMgrBean() {
    }
    
    @PersistenceContext
	protected EntityManager em;

	@Resource
	private EJBContext context;
	

    @Override
	public List<TrasportoDTO> getAllTrasporto() {
		List<Trasporto> escursioni = em.createNamedQuery("Trasporto.findAll", Trasporto.class).getResultList();	
		List<TrasportoDTO> escursioniDTO = new ArrayList<TrasportoDTO>();
		for(int i=0; i<escursioni.size(); i++) {
			Trasporto current = escursioni.get(i);
			escursioniDTO.add(convertToDTO(current));
		}
		return escursioniDTO;
	}
		
	public TrasportoDTO convertToDTO(Trasporto trasporto) {
		if (trasporto == null) {
			return null;
		}
		TrasportoDTO TrasportoDTO = new TrasportoDTO();
		TrasportoDTO.setCosto(trasporto.getCosto());
		TrasportoDTO.setDescrizione(trasporto.getDescrizione());
		TrasportoDTO.setIdProdBase(trasporto.getIdProdBase());
		TrasportoDTO.setCittaPartenza(trasporto.getCittaPartenza());
		TrasportoDTO.setCittaRitorno(trasporto.getCittaRitorno());
		TrasportoDTO.setDataPartenza(trasporto.getDataPartenza());
		TrasportoDTO.setDataRitorno(trasporto.getDataRitorno());
		return TrasportoDTO;
	}

	@Override
	public void addNewTrasporto(TrasportoDTO newTrasporto) {
		Trasporto trasporto = new Trasporto(newTrasporto);
		em.persist(trasporto);
	}

	//bisogna aggiungere che se appartiene ad un pacchetto, nn puo' essere elimnato
	@Override
	public void removeTrasporto(int idTrasporto) {
		Trasporto trasporto = findTrasporto(idTrasporto);
		em.remove(trasporto);
		
	}
	
	private Trasporto findTrasporto(int idTrasporto) {
		return em.find(Trasporto.class, idTrasporto);
		
	}

	@Override
	public TrasportoDTO findTrasportoDTO(int idTrasporto) {
		Trasporto trasporto = findTrasporto(idTrasporto);
		return this.convertToDTO(trasporto);
	}

	@Override
	public void update(TrasportoDTO Trasporto) {
		em.merge(new Trasporto(Trasporto));
	}



}
