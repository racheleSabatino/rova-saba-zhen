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
			mex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attenzione", "Mail gi� presente, inserirne una diversa"));
			return;
		}
		
		if(utente.getPassword().length() < 8){
			mex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attenzione", "Password troppo corta, la lunghezza minima � 8 caratteri"));
			return;

		}
			clienteMgrBean.addCliente(utente); 
			mex.addMessage(null, new FacesMessage("Successo", "Registrazione avvenuta"));
		
	}
}
