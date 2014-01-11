package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="registerBean")
@RequestScoped
public class RegisterBean {
	
	@EJB
	private UtenteMgrBeanLocal utenteMgrBean;

	private UtenteDTO utente;
	
	public RegisterBean() {
		utente = new UtenteDTO();
	}

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

	public String register() {
		utenteMgrBean.save(utente);
		return "/homePage.xhtml?tab=0";
	}
}
