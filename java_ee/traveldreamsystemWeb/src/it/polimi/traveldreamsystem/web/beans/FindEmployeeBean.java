package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Pattern;

@ManagedBean(name="findEmployeeBean")
@RequestScoped
public class FindEmployeeBean {
	
	@EJB
	private UtenteMgrBeanLocal utenteMgrBean;
	
	private UtenteDTO searchedEmployee;
	
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="invalid email")
	private String searchedMail;
	
	public FindEmployeeBean() {
		searchedEmployee = new UtenteDTO();
		searchedMail = new String();
	}
	
	public String getMail() {
		return searchedMail;
	}
	
	public void setMail(String mail) {
		searchedMail = mail;
	}
	
	public void find(String mail) {
		setEmployee(utenteMgrBean.findUtenteDTO(mail));
	}

	public UtenteDTO getEmployee() {
		return searchedEmployee;
	}

	public void setEmployee(UtenteDTO searchedEmployee) {
		this.searchedEmployee = searchedEmployee;
	}
	
	
	

}
