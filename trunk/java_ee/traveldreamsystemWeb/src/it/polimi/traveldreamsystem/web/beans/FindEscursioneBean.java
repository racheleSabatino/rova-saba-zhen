package it.polimi.traveldreamsystem.web.beans;

import java.awt.event.ActionEvent;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	
	private boolean resultPanelVisible;
	
	public boolean isResultPanelVisible() {
		return resultPanelVisible;
	}

	public void setResultPanelVisible(boolean resultPanelVisible) {
		this.resultPanelVisible = resultPanelVisible;
	}

	public FindEscursioneBean() {
		searchedEscursione = new EscursioneDTO();
		this.resultPanelVisible = false;
	}
	
	public void find() {
		FacesContext messaggio = FacesContext.getCurrentInstance();
		searchedEscursione = escursioneMgrBean.findEscursioneDTO(searchedId);
		if(searchedEscursione != null) {
			resultPanelVisible = true;
		}
		else {
			messaggio.addMessage(null, new FacesMessage("Attenzione", "Non è stato trovato una escursione avente l'id "
					+ "digitato, accertarsi di aver inserito un id corretto"));
			resultPanelVisible = false;
		}
	}

	public EscursioneDTO getSearchedEscursione() {
		return searchedEscursione;
	}

	public void setSearchedEscursione(EscursioneDTO searchedEscursione) {
		this.searchedEscursione = searchedEscursione;
	}

	public void remove(ActionEvent actionEvent) {
		 FacesContext context = FacesContext.getCurrentInstance();  
			try {
				escursioneMgrBean.removeEscursione(searchedId);
				context.addMessage(null, new FacesMessage("Successo", "L'eliminazione dell'escursione è andata a buon fine"));
			} catch(Exception e) {
				context.addMessage(null, new FacesMessage("Attenzione", "L'escursione non può essere eliminata perchè"
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
