package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.ImpiegatoMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class AddImpiegatoBean {

	@EJB
	private ImpiegatoMgrBeanLocal impiegatoMgrBean;

	private UtenteDTO impiegato;

	public AddImpiegatoBean() {
		this.impiegato = new UtenteDTO();
	}

	public void add() {

		FacesContext mex = FacesContext.getCurrentInstance();
		if(impiegatoMgrBean.findUtenteDTO(impiegato.getMail())!=null) {
			mex.addMessage(null, new FacesMessage("Attenzione", "Mail già presente, inserirne una diversa"));
		}
		else  {
			impiegatoMgrBean.addImpiegato(impiegato);
			mex.addMessage(null, new FacesMessage("Successo", "Registrazione avvenuta"));
		}
	}

	public UtenteDTO getImpiegato() {
		return impiegato;
	}

	public void getImpiegato(UtenteDTO impiegato) {
		this.impiegato = impiegato;
	}

}
