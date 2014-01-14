package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Pattern;

@ManagedBean(name="a")
@RequestScoped
public class FindEmployeeBean {
	
	@EJB
	private UtenteMgrBeanLocal utenteMgrBean;
	
	private UtenteDTO searchedEmployee;
	
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="invalid email")
	private String searchedMail;
	private String prova;
	
	public FindEmployeeBean() {
		searchedEmployee = new UtenteDTO();
		searchedMail = new String();
		prova = new String();
	}
	
	public String getMail() {
		return searchedMail;
	}
	
	public void setMail(String mail) {
		searchedMail = mail;
	}
	
	public void find(String mail) {
		searchedEmployee = utenteMgrBean.findUtenteDTO(mail);
		if(searchedEmployee.getCognome()!=null) {
			prova = "trovato";
		} else {
			prova = "non trovato";
		}
		
	}

	public UtenteDTO getEmployee() {
		return searchedEmployee;
	}

	public void setEmployee(UtenteDTO searchedEmployee) {
		this.searchedEmployee = searchedEmployee;
	}
	
	
	

}
