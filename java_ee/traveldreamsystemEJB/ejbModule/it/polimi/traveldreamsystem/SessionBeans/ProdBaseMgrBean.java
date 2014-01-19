package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.PacchPred;
import it.polimi.traveldreamsystem.Entities.ProdBase;
import it.polimi.traveldreamsystem.Entities.Utente;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
import it.polimi.traveldreamsystem.dto.ProdBaseDTO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class ProdBaseMgrBean
 */
@Stateless
@LocalBean
public class ProdBaseMgrBean implements ProdBaseMgrLocal {

	@PersistenceContext
	protected EntityManager em;

	@Resource
	private EJBContext context;
	
    public ProdBaseMgrBean() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void addNewProdBase(ProdBaseDTO newProdotto) {
		ProdBase newProdBase = new ProdBase(newProdotto);
		em.persist(newProdBase);
	}

	
	@Override
	public void removeProdBase(int idProdBase) {
		ProdBase prodotto = findProdBase(idProdBase);
		em.remove(prodotto);
	}

	
	public ProdBase findProdBase(int idProdBase) {
		return em.find(ProdBase.class, idProdBase);
		
	}
	
	@Override
	public ProdBaseDTO findProdBasedDTO(int idProdBase) {
		ProdBase prodotto = findProdBase(idProdBase);
		return this.convertToDTO(prodotto);
	}

	//devo capire come fare
	public List<ProdBaseDTO> getAllHotel() {
		Query q = em.createQuery("FROM Hotel h LEFT JOIN h.idProdBase");
		List<ProdBase> hotel = (List<ProdBase>) q.getResultList();
		return q.getResultList();
	}
		


/*per il momento nel pacchetto predefinito DTO, al posto di inserire la lista dei prodotti base DTO, inserisco solo 
 * una lista degli id dei prodotti base che lo contengono. Questo perchè altrimenti bisognerebbe convertire in DTO 
 * anche i prodotti base, il che comporterebbe aggiungere all'interno di questo oggetto, l'oggetto
 * ProdBaseMgr che contiene il metodo converti prodotto base. 
*/
	public ProdBaseDTO convertToDTO(ProdBase prodotto) {
		if (prodotto == null) {
			return null;
		}
		ProdBaseDTO prodottoDTO = new ProdBaseDTO();
		prodottoDTO.setCosto(prodotto.getCosto());
		prodottoDTO.setDescrizione(prodotto.getDescrizione());
		prodottoDTO.setIdProdBase(prodotto.getIdprodbase());
		return prodottoDTO;
	}

}
