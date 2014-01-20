package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Escursione;
import it.polimi.traveldreamsystem.Entities.Hotel;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class EscursioneMgrBean
 */
@Stateless
@LocalBean
public class EscursioneMgrBean implements EscursioneBeanLocal {

    /**
     * Default constructor. 
     */
    public EscursioneMgrBean() {
    }
    
    @PersistenceContext
	protected EntityManager em;

	@Resource
	private EJBContext context;
	

    @Override
	public List<EscursioneDTO> getAllEscursione() {
		List<Escursione> hotels = em.createNamedQuery("Escursione.findALL", Hotel.class).getResultList();	
		List<EscursioneDTO> escursioniDTO = new ArrayList<Escursione>();
		for(int i=0; i<hotels.size(); i++) {
			Hotel current = hotels.get(i);
			hotelsDTO.add(convertToDTO(current));
		}
		return EscursioneDTO;
	}
		
	public HotelDTO convertToDTO(Hotel hotel) {
		if (hotel == null) {
			return null;
		}
		HotelDTO hotelDTO = new HotelDTO();
		hotelDTO.setCosto(hotel.getCosto());
		hotelDTO.setDescrizione(hotel.getDescrizione());
		hotelDTO.setIdprodbase(hotel.getIdprodbase());
		hotelDTO.setCitta(hotel.getCitta());
		hotelDTO.setStelle(hotel.getStelle());
		hotelDTO.setTipocamera(hotel.getTipocamera());
		return hotelDTO;
	}

	@Override
	public void addNewHotel(HotelDTO newHotel) {
		Hotel hotel = new Hotel(newHotel);
		em.persist(hotel);
	}

	//bisogna aggiungere che se appartiene ad un pacchetto, nn può essere elimnato
	@Override
	public void removeHotel(int idHotel) {
		Hotel hotel = findHotel(idHotel);
		em.remove(hotel);
		
	}
	
	private Hotel findHotel(int idHotel) {
		return em.find(Hotel.class, idHotel);
		
	}

	@Override
	public HotelDTO findHotelDTO(int idHotel) {
		Hotel hotel = findHotel(idHotel);
		return this.convertToDTO(hotel);
	}

	@Override
	public void update(HotelDTO hotel) {
		em.merge(new Hotel(hotel));
	}


}
