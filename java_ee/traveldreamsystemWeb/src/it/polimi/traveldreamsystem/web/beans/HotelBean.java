package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.CheckDateLocal;
import it.polimi.traveldreamsystem.SessionBeans.HotelMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.HotelDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@SessionScoped
public class HotelBean extends PacchPredBean {

	@EJB
	private HotelMgrBeanLocal hotelMgrBean;
	
	@EJB
	private CheckDateLocal checkDateBean;

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
	
	public HotelBean() {
		hotel = new HotelDTO();
	}

	public void init(int id) {
		hotels = hotelMgrBean.getAllHotel();
		pacchPred = pacchPredMgrBean.findPacchPredDTO(id);
		for (HotelDTO aDTO : hotels) {
			if (compPacchMgr.findHotel(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
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
		FacesContext context = FacesContext.getCurrentInstance();
		if(!checkDateBean.checkDate(hotel.getDataRitorno(), hotel.getDataPartenza())){
			context.addMessage(null, new FacesMessage("Controllare i valori inseriti, "
					+ "la data di partenza deve essere successiva o perlomeno uguale alla data della arrivo. "
					+ "Inserire valori corretti e poi ripremere il pulsante Salva"));
		}
		else {
			hotelMgrBean.addNewHotel(hotel);
			context.addMessage(null, new FacesMessage("Creazione avvenuta con successo"));  
		}
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
	}
}
