package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
		resultPanelVisible = true;
		searchedTrasporto = trasportoMgrBean.findTrasportoDTO(searchedId);
	}

	public TrasportoDTO getSearchedTrasporto() {
		return searchedTrasporto;
	}

	public void setSearchedTrasporto(TrasportoDTO searchedTrasporto) {
		this.searchedTrasporto = searchedTrasporto;
	}

	public void remove() {
		trasportoMgrBean.removeTrasporto(searchedId);
		setRemoveOK("Eliminazione trasporto terminata con successo");
	
	}

	public String getRemoveOK() {
		return removeOK;
	}

	public void setRemoveOK(String removeOK) {
		this.removeOK = removeOK;
	}
	
}