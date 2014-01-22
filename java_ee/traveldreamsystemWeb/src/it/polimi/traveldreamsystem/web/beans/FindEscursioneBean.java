package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class FindEscursioneBean {

	@EJB
	private EscursioneMgrBeanLocal escursioneMgrBean;

	private EscursioneDTO searchedEscursione;
	
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

	public FindEscursioneBean() {
		searchedEscursione = new EscursioneDTO();
	}
	
	public void find() {
		resultPanelVisible = true;
		searchedEscursione = escursioneMgrBean.findEscursioneDTO(searchedId);
	}

	public EscursioneDTO getSearchedEscursione() {
		return searchedEscursione;
	}

	public void setSearchedEscursione(EscursioneDTO searchedEscursione) {
		this.searchedEscursione = searchedEscursione;
	}

	public void remove() {
		escursioneMgrBean.removeEscursione(searchedId);
		setRemoveOK("Eliminazione impiegato terminata con successo");
	
	}

	public String getRemoveOK() {
		return removeOK;
	}

	public void setRemoveOK(String removeOK) {
		this.removeOK = removeOK;
	}
	
	
	

}
