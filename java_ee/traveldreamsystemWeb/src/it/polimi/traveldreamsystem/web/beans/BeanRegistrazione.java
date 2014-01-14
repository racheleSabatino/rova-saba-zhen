package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="beanRegistrazione")
@RequestScoped
public class BeanRegistrazione {
	
	@EJB
	private UtenteMgrBeanLocal utenteMgrBean;

	private UtenteDTO utente;
	
	public BeanRegistrazione() {
		utente = new UtenteDTO();
	}

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

	public String registrati() {
		utenteMgrBean.save(utente);
		return "/homePage?faces-redirect=true";
	}
}
