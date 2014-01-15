package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.ImpiegatoMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AddImpiegatoBean {

	@EJB
	private ImpiegatoMgrBeanLocal impiegatoMgrBean;

	private UtenteDTO impiegato;

	public AddImpiegatoBean() {
		this.impiegato = new UtenteDTO();
	}

	public String add() {
		impiegatoMgrBean.addImpiegato(impiegato);
		return "/homePage?faces-redirect=true";
	}

	public UtenteDTO getImpiegato() {
		return impiegato;
	}

	public void getImpiegato(UtenteDTO impiegato) {
		this.impiegato = impiegato;
	}

}
