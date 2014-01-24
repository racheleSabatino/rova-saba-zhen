package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.HotelMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.HotelDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HotelBean {

	@EJB
	private HotelMgrBeanLocal hotelMgrBean;

	private HotelDTO hotel;
	
	public HotelBean() {
		hotel = new HotelDTO();
	}

	public String addHotel(){
		hotelMgrBean.addNewHotel(hotel);
		return "/homePage?faces-redirect=true";
	}

	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}
	
}
