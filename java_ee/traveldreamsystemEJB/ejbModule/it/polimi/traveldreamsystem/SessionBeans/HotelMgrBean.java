package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Hotel;
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
 * Session Bean implementation class ProdBaseMgrBean
 */
@Stateless
@LocalBean
public class HotelMgrBean implements HotelMgrLocal {

	@PersistenceContext
	protected EntityManager em;

	@Resource
	private EJBContext context;
	
    public HotelMgrBean() {
   
    }

    @Override
	public List<HotelDTO> getAllHotel() {
		List<Hotel> hotels = em.createNamedQuery("Hotel.findALL", Hotel.class).getResultList();	
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

	//bisogna aggiungere che se appartiene ad un pacchetto, nn pu� essere elimnato
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
	public void changeHotelCosto(int cost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeDescrizione(String descrizione) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeCitta(String citta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStelle(int stelle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeTipoCamera(String tipoCamera) {
		// TODO Auto-generated method stub
		
	}

}
