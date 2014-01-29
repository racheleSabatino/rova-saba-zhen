package it.polimi.traveldreamsystem.web.beans;


import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class FindHotelBean {

	@EJB
	private HotelMgrBeanLocal hotelMgrBean;

	private HotelDTO searchedHotel;
	
	private int searchedId;
	
	public int getSearchedId() {
		return searchedId;
	}

	public void setSearchedId(int searchedId) {
		this.searchedId = searchedId;
	}

	private String removeOK;
	
	private boolean resultPanelVisible;
	
	
	public boolean isResultPanelVisible() {
		return resultPanelVisible;
	}

	public void setResultPanelVisible(boolean resultPanelVisible) {
		this.resultPanelVisible = resultPanelVisible;
	}

	public FindHotelBean() {
		searchedHotel = new HotelDTO();
	}
	
	public void find() {
		FacesContext messaggio = FacesContext.getCurrentInstance();
		searchedHotel = hotelMgrBean.findHotelDTO(searchedId);
		if(searchedHotel != null) {
			resultPanelVisible = true;
		}
		else {
			messaggio.addMessage(null, new FacesMessage("Non è stato trovato un hotel avente l'id digitato, "
					+ "accertarsi di aver inserito un id corretto"));
		}
	}

	public HotelDTO getSearchedHotel() {
		return searchedHotel;
	}

	public void setSearchedHotel(HotelDTO searchedHotel) {
		this.searchedHotel = searchedHotel;
	}

	public void remove(ActionEvent actionEvent) {
		 FacesContext context = FacesContext.getCurrentInstance();  
		try {
			hotelMgrBean.removeHotel(searchedId);
			context.addMessage(null, new FacesMessage("Successo", "L'eliminazione dell'hotel è andata a buon fine"));
		} catch(Exception e) {
			context.addMessage(null, new FacesMessage("Attenzione", "L'hotel non può essere eliminato perchè"
				+ " fa parte di un pacchetto vacanza"));
		}
	}

	public String getRemoveOK() {
		return removeOK;
	}

	public void setRemoveOK(String removeOK) {
		this.removeOK = removeOK;
	}
	
	
}