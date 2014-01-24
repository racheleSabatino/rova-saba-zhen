package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.HotelMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.HotelDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class HotelBean {

	@EJB
	private HotelMgrBeanLocal hotelMgrBean;

	private HotelDTO hotel;
	
	public HotelBean() {
		hotel = new HotelDTO();
	}

	public void addHotel(){
		hotelMgrBean.addNewHotel(hotel);
        FacesContext context = FacesContext.getCurrentInstance();  
        
        context.addMessage(null, new FacesMessage("Creazione avvenuta con successo"));  
	}

	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}
	
}
