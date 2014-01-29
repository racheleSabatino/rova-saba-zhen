package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class InvitoPacchBean {
	private boolean resultPanelVisible;
	
	@EJB
	private PacchPerMgrLocal pacchMgrBean;
	
	private int searchedId;
	
	private PacchPerDTO searchedPacch;
	
	private String mail;

	public boolean isResultPanelVisible() {
		return resultPanelVisible;
	}

	public void setResultPanelVisible(boolean resultPanelVisible) {
		this.resultPanelVisible = resultPanelVisible;
	}

	public int getSearchedId() {
		return searchedId;
	}

	public void setSearchedId(int searchedId) {
		this.searchedId = searchedId;
	}

	public PacchPerDTO getSearchedPacch() {
		return searchedPacch;
	}

	public void setSearchedPacch(PacchPerDTO searchedPacch) {
		this.searchedPacch = searchedPacch;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public InvitoPacchBean(){

	}
	
	public void find() {
		FacesContext messaggio = FacesContext.getCurrentInstance();
		searchedPacch = pacchMgrBean.findPacchPerDTO(searchedId);
		if(searchedPacch != null && searchedPacch.getCliente().getMail().equals(mail)) {
			resultPanelVisible = true;
		}
		else {
			messaggio.addMessage(null, new FacesMessage("Attenzione", "Dati errati "
					+ "accertarsi di aver inserito dati corretti"));
			resultPanelVisible = false;
		}
	}

}
