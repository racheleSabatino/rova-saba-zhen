package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
	
	private boolean resultPanelVisible = false;
	
	
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
		resultPanelVisible = true;
		searchedHotel = hotelMgrBean.findHotelDTO(searchedId);
	}

	public HotelDTO getSearchedHotel() {
		return searchedHotel;
	}

	public void setSearchedHotel(HotelDTO searchedHotel) {
		this.searchedHotel = searchedHotel;
	}

	public void remove() {
		hotelMgrBean.removeHotel(searchedId);
		setRemoveOK("Eliminazione hotel terminata con successo");
	
	}

	public String getRemoveOK() {
		return removeOK;
	}

	public void setRemoveOK(String removeOK) {
		this.removeOK = removeOK;
	}
	
}