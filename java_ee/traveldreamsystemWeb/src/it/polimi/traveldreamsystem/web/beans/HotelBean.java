package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.HotelMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.HotelDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class HotelBean extends PacchPredBean {

	@EJB
	private HotelMgrBeanLocal hotelMgrBean;

	private List<HotelDTO> hotels;

	private List<HotelDTO> filteredHotels;

	private HotelDTO hotel;
	
	public HotelBean() {
	}

	@PostConstruct
	public void init() {
		hotel = new HotelDTO();
		hotels = hotelMgrBean.getAllHotel();
		pacchPred = pacchPredMgrBean.getAllPacchPred().get(0);
		for (HotelDTO aDTO : hotels) {
			if (compPacchMgr.findHotel(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
				aDTO.setSelected(true);
			} else {
				aDTO.setSelected(false);
			}
		}
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

	public List<HotelDTO> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelDTO> hotels) {
		this.hotels = hotels;
	}

	public List<HotelDTO> getFilteredHotels() {
		return filteredHotels;
	}

	public void setFilteredHotels(List<HotelDTO> filteredHotels) {
		this.filteredHotels = filteredHotels;
	}
	
	public void selected() {
		System.out.println("select");
		if (hotel.getSelected()) {
			hotel.setSelected(false);
		} else {
			hotel.setSelected(true);
		}
	}

	public String save() {
		System.out.println("cell save");

		for (HotelDTO aDTO : hotels) {
			hotelMgrBean.update(aDTO);
			if (aDTO.getSelected()
					&& !compPacchMgr.findHotel(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
				compPacchMgr.addHotelToPacch(pacchPred.getIdPacchPred(),
						aDTO.getIdProdBase());
			}
			if (!aDTO.getSelected()
					&& compPacchMgr.findHotel(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
				compPacchMgr.removeHotelToPacch(pacchPred.getIdPacchPred(),
						aDTO.getIdProdBase());
			}
		}
		pacchPredMgrBean.update(pacchPred);
		return "/homePage?faces-redirect=true";
	}
}
