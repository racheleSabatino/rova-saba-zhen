package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Hotel;
import it.polimi.traveldreamsystem.Entities.PacchPred;
import it.polimi.traveldreamsystem.dto.HotelDTO;

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
public class HotelMgrBean implements HotelMgrBeanLocal {

	@PersistenceContext
	protected EntityManager em;

	@Resource
	private EJBContext context;
	
    public HotelMgrBean() {
   
    }

    public HotelMgrBean(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<HotelDTO> getAllHotel() {
		List<Hotel> hotels = em.createNamedQuery("Hotel.findAll", Hotel.class).getResultList();	
		List<HotelDTO> hotelsDTO = new ArrayList<HotelDTO>();
		for(int i=0; i<hotels.size(); i++) {
			Hotel current = hotels.get(i);
			hotelsDTO.add(convertToDTO(current));
		}
		return hotelsDTO;
	}
		
	public HotelDTO convertToDTO(Hotel hotel) {
		if (hotel == null) {
			return null;
		}
		HotelDTO hotelDTO = new HotelDTO();
		hotelDTO.setCosto			(hotel.getCosto());
		hotelDTO.setDescrizione		(hotel.getDescrizione());
		hotelDTO.setIdProdBase		(hotel.getIdProdBase());
		hotelDTO.setCitta			(hotel.getCitta());
		hotelDTO.setStelle			(hotel.getStelle());
		hotelDTO.setTipoCamera		(hotel.getTipoCamera());
		hotelDTO.setDataPartenza	(hotel.getDataPartenza());
		hotelDTO.setDataRitorno		(hotel.getDataRitorno());
		return hotelDTO;
	}

	@Override
	public void addNewHotel(HotelDTO newHotel) {
		Hotel hotel = new Hotel(newHotel);
		em.persist(hotel);
	}

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

	@Override
	public List<HotelDTO> getValidHotel(List<HotelDTO> hotels, List<String> citta) {
		if(hotels.isEmpty() || citta.isEmpty()) 
			return null;
		List<HotelDTO> hotelCercati = new ArrayList<HotelDTO>();
		for(HotelDTO h: hotels) {
			String hCitta = h.getCitta().toLowerCase();
			for(String s: citta) {
				if(hCitta.equals(s.toLowerCase()))
					hotelCercati.add(h);
				}
		}
		return hotelCercati;
	}
	
}
