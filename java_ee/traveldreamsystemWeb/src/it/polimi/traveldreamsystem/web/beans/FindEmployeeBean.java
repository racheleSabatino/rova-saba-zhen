package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class FindEmployeeBean {
	
	@EJB
	private UtenteMgrBeanLocal utenteMgrBean;
	
	private UtenteDTO searchedEmployee;
	
	private String searchedMail;
	
	private String removeOK;

	
	public FindEmployeeBean() {
		searchedEmployee = new UtenteDTO();
		searchedMail = new String();
		setRemoveOK(new String());
	}
	
	public void find() {
		searchedEmployee = utenteMgrBean.findUtenteDTO(searchedMail);
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
	
	
	

}
