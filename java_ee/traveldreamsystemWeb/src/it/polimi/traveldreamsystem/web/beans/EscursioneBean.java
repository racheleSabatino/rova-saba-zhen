package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.EscursioneMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EscursioneBean {

	@EJB
	private EscursioneMgrBeanLocal escursioneMgrBean;

	private EscursioneDTO escursione;
	
	public EscursioneBean() {
		escursione = new EscursioneDTO();
	}

	public void addEscursione(){
		escursioneMgrBean.addNewEscursione(escursione);
	}

	public EscursioneDTO getEscursione() {
		return escursione;
	}

	public void setEscursione(EscursioneDTO escursione) {
		this.escursione = escursione;
	}
	
}
