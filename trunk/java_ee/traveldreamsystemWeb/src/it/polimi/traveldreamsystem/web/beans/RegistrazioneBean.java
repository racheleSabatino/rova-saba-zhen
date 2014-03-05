package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.dto.*;
import it.polimi.traveldreamsystem.SessionBeans.*;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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

	public void registrati() {
		FacesContext mex = FacesContext.getCurrentInstance();
		if(clienteMgrBean.findUtenteDTO(utente.getMail())!=null) {
			mex.addMessage(null, new FacesMessage("Attenzione", "Mail già presente, inserirne una diversa"));
		}
		else  {
			clienteMgrBean.addCliente(utente); 
			mex.addMessage(null, new FacesMessage("Successo", "Registrazione avvenuta"));
		}
	}
}
