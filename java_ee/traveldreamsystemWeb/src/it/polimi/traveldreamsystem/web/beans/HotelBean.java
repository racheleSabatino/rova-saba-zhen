package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.CheckDateLocal;
import it.polimi.traveldreamsystem.SessionBeans.HotelMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.context.RequestContext;

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
		if(pacchPred == null) {
			pacchPred = new PacchPredDTO(id);
		}
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
		if(!checkDateBean.checkDate(hotel.getDataPartenza(), hotel.getDataRitorno())){
			context.addMessage(null, new FacesMessage("Controllare i valori inseriti, "
					+ "la data di fine deve essere successiva o perlomeno uguale alla data di inizio della prenotazione. "
					+ "Inserire valori corretti e poi ripremere il pulsante Salva"));
		}
		else {
			HotelDTO e = hotelMgrBean.findHotelDTO(hotel.getIdProdBase());
			if(e != null) {
				hotelMgrBean.update(hotel);
				context.addMessage(null, new FacesMessage("Modifica avvenuta con successo")); 
			}
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
		System.out.println("cell save hotels");

		pacchPredMgrBean.update(pacchPred);
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
	}
	
	public String goToPaginaModifica(int idHotel){
		return "/impiegato/creazioneHotel?faces-redirect=true"
				+ "&amp;id=" + idHotel;
	}
	
	public void reset() {  
        RequestContext.getCurrentInstance().reset("form:panel");  
    }  
	
	public void messaggio() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("successo", "salvataggio avvenuto"));
	}
}
