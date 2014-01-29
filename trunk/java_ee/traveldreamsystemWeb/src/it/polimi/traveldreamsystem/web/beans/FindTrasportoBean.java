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
public class FindTrasportoBean {

	@EJB
	private TrasportoMgrBeanLocal trasportoMgrBean;

	private TrasportoDTO searchedTrasporto;
	
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

	public FindTrasportoBean() {
		searchedTrasporto = new TrasportoDTO();
	}
	
	public void find() {
		FacesContext messaggio = FacesContext.getCurrentInstance();
		searchedTrasporto= trasportoMgrBean.findTrasportoDTO(searchedId);
		if(searchedTrasporto != null) {
			resultPanelVisible = true;
		}
		else {
			messaggio.addMessage(null, new FacesMessage("Attenzione, Non è stato trovato un mezzo di trasporto coll'id digitato, "
					+ "accertarsi di aver inserito un id corretto"));
			resultPanelVisible = false;
		}
	}

	public TrasportoDTO getSearchedTrasporto() {
		return searchedTrasporto;
	}

	public void setSearchedTrasporto(TrasportoDTO searchedTrasporto) {
		this.searchedTrasporto = searchedTrasporto;
	}

	public void remove(ActionEvent actionEvent) {
		 FacesContext context = FacesContext.getCurrentInstance();  
			try {
				trasportoMgrBean.removeTrasporto(searchedId);
				context.addMessage(null, new FacesMessage("Successo", "L'eliminazione del mezzo di trasporto è andata a buon fine"));
			} catch(Exception e) {
				context.addMessage(null, new FacesMessage("Attenzione", "Il mezzo di trasporto non può essere eliminato perchè"
					+ " fa parte di un pacchetto vacanza"));
			}
	
	}

	public String getRemoveOK() {
		return removeOK;
	}

	public void setRemoveOK(String removeOK) {
		this.removeOK = removeOK;
	}
	
	public void resetForm(){
		searchedTrasporto = null; 
		searchedId = 0;
	}

	
}