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

	private String prova;
	
	public FindEmployeeBean() {
		searchedEmployee = new UtenteDTO();
		searchedMail = new String();
		setProva(new String());
	}
	
	public void find() {
		searchedEmployee = utenteMgrBean.findUtenteDTO(searchedMail);
		if(searchedEmployee.getCognome()!=null) {
			setProva("trovato");
		} else {
			setProva("non trovato");
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

	public String getProva() {
		return prova;
	}

	public void setProva(String prova) {
		this.prova = prova;
	}
	
	
	

}
