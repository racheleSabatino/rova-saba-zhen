package it.polimi.traveldreamsystem.web.beans;

import java.util.ArrayList;
import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.HotelMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@SessionScoped
public class HotelBeanPer extends PacchPerBean {
	
	@EJB
	HotelMgrBeanLocal hotelMgr;
	
	private List<HotelDTO> hotels;

	private List<HotelDTO> filteredHotels;

	private HotelDTO hotel;

	private int pacchId;
	
	private int idPacchPred;
	
	private String mail;
	
	private List<String> cittaSelez;

	public int getPacchId() {
		return pacchId;
	}

	public void setPacchId(int pacchId) {
		this.pacchId = pacchId;
		init(pacchId);
	}
	
	public List<String> getCittaSelez() {
		return cittaSelez;
	}

	public void setAddCittaSelez(String citta) {
		cittaSelez.add(citta);
	}
	
	public HotelBeanPer() {
		hotel = new HotelDTO();
	}

	public void init(int id) {
		cittaSelez = new ArrayList<String>();
		pacchPer = pacchPerMgrBean.findPacchPerDTO(id);
		if(pacchPer == null) {
			pacchPer = new PacchPerDTO(id, false, getPacchPred(idPacchPred), getCliente(mail));
		}
		hotels = compPacchPredMgr.getHotelsPacchPred(pacchPer.getPacchPred().getIdPacchPred());
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
		//return filteredHotels; cittaSelez;

		if(cittaSelez.isEmpty()) 
			return filteredHotels;
		List<HotelDTO> hotelCercati = new ArrayList<HotelDTO>();
		if(filteredHotels != null) {
			for (HotelDTO h : filteredHotels) {
				String hCitta = h.getCitta().toLowerCase();
				for (String s : cittaSelez) {
					if (hCitta.equals(s.toLowerCase()))
						hotelCercati.add(h);
				}
			}
		} else {
			for (HotelDTO h : hotels) {
				String hCitta = h.getCitta().toLowerCase();
				for (String s : cittaSelez) {
					if (hCitta.equals(s.toLowerCase()))
						hotelCercati.add(h);
				}
			}
		}
		return hotelCercati;
	}

	public void setFilteredHotels(List<HotelDTO> filteredHotels) {
		this.filteredHotels = filteredHotels;
	}
	
	public void setValidHotel() {
		filteredHotels = hotelMgr.getValidHotel(hotels, cittaSelez);
		System.out.println("filtered hotel" + filteredHotels);
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

	public int getIdPacchPred() {
		return idPacchPred;
	}

	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
}
