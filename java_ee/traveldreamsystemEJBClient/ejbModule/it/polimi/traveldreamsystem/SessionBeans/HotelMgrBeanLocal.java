package it.polimi.traveldreamsystem.SessionBeans;

import java.util.List;

import it.polimi.traveldreamsystem.dto.HotelDTO;

import javax.ejb.Local;

@Local
public interface HotelMgrBeanLocal {

	void addNewHotel(HotelDTO newHotel);

	void removeHotel(int idHotel);

	HotelDTO findHotelDTO(int idHotel);

	List<HotelDTO> getAllHotel();

	void update(HotelDTO hotel);

}
