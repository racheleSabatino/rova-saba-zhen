package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class FindEmployeeBean {
	
	@EJB
	private UtenteMgrBeanLocal utenteMgrBean;
	
	private UtenteDTO searchedEmployee;
	
	private String searchedMail;
	
	private String removeOK;
	
	private boolean resultPanelVisible;
	
	
	public boolean isResultPanelVisible() {
		return resultPanelVisible;
	}

	public void setResultPanelVisible(boolean resultPanelVisible) {
		this.resultPanelVisible = resultPanelVisible;
	}

	public FindEmployeeBean() {
		searchedMail = new String();
		resultPanelVisible = false;
	}
	
	public void find() {
		FacesContext context = FacesContext.getCurrentInstance();
		searchedEmployee = utenteMgrBean.findUtenteDTO(searchedMail);
		if(searchedEmployee == null) {
			resultPanelVisible = false;
			context.addMessage(null, new FacesMessage("L'impiegato non è presente in database, accertarsi di aver digitato"
													+ " una mail corretta"));
		}
		else {
			
			resultPanelVisible = true;
			}
	}
	
	public UtenteDTO getSearchedEmployee() {
		return searchedEmployee;
	}

	public void setSearchedEmployee(UtenteDTO searchedEmployee) {
		this.searchedEmployee = searchedEmployee;
	}
	
	public String getSearchedMail() {
		return searchedMail;
	}

	public void setSearchedMail(String searchedMail) {
		this.searchedMail = searchedMail;
	}

	public void remove() {
		utenteMgrBean.removeUtente(searchedMail);
		setRemoveOK("Eliminazione impiegato terminata con successo");
	
	}

	public String getRemoveOK() {
		return removeOK;
	}

	public void setRemoveOK(String removeOK) {
		this.removeOK = removeOK;
	}
	
	public void reset(){
		resultPanelVisible = false;
	}
	

}
