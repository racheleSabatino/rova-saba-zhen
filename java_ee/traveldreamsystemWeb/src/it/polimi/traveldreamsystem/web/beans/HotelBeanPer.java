package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.dto.HotelDTO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@SessionScoped
public class HotelBeanPer extends PacchPerBean {

	private List<HotelDTO> hotels;

	private List<HotelDTO> filteredHotels;

	private HotelDTO hotel;

	private int pacchId;

	public int getPacchId() {
		return pacchId;
	}

	public void setPacchId(int pacchId) {
		this.pacchId = pacchId;
		init(pacchId);
	}
	
	public HotelBeanPer() {
		hotel = new HotelDTO();
	}

	public void init(int id) {
		pacchPer = pacchPerMgrBean.findPacchPerDTO(id);
		hotels = compPacchPredMgr.getHotelsPacchPred(pacchPer.getIdPacchPred());
		for (HotelDTO aDTO : hotels) {
			if (compPacchPerMgr.findHotel(pacchPer.getIdPacchPer(), aDTO.getIdProdBase())) {
				aDTO.setSelected(true);
			} else {
				aDTO.setSelected(false);
			}
		}
	}
	
	public void init() {
		init(pacchId);
	}

	public void initajax(AjaxBehaviorEvent e) {
		init();
	}

	public void addHotel(){
		compPacchPerMgr.addHotelToPacchPer(pacchId, hotel.getIdProdBase());
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

	public void save(AjaxBehaviorEvent e) {
		System.out.println("cell save");

		for (HotelDTO aDTO : hotels) {
			if (aDTO.getSelected()
					&& !compPacchPerMgr.findHotel(pacchPer.getIdPacchPer(), aDTO.getIdProdBase())) {
				compPacchPerMgr.addHotelToPacchPer(pacchPer.getIdPacchPer(),
						aDTO.getIdProdBase());
			}
			if (!aDTO.getSelected()
					&& compPacchPerMgr.findHotel(pacchPer.getIdPacchPer(), aDTO.getIdProdBase())) {
				compPacchPerMgr.removeHotelToPacchPer(pacchPer.getIdPacchPer(),
						aDTO.getIdProdBase());
			}
		}
		pacchPerMgrBean.update(pacchPer);
	}
}
