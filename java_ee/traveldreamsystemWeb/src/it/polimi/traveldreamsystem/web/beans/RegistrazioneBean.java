package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RegistrazioneBean {
	
	@EJB
	private ClienteMgrBeanLocal clienteMgrBean;

	private UtenteDTO utente;
	
	public RegistrazioneBean() {
		utente = new UtenteDTO();
	}

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

	public String registrati() {
		clienteMgrBean.addCliente(utente);
		return "/homePage?faces-redirect=true";
	}
}
