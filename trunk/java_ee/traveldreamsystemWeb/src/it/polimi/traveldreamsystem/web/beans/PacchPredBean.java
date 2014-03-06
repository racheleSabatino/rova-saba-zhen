package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

@ManagedBean
@SessionScoped
public class PacchPredBean {
	
	@EJB
	protected PacchPerMgrLocal pacchPerMgrBean;
	
	@EJB
	protected PacchPredMgrLocal pacchPredMgrBean;

	@EJB
	protected ComposizPacchPredMgrLocal compPacchMgr;

	protected PacchPredDTO pacchPred;

	
	public void addPacchPred(){
			pacchPredMgrBean.addNewPacchPred(pacchPred);
		
	}

	public PacchPredDTO getPacchPred() {
		return pacchPred;
	}

	public void setPacchPred(PacchPredDTO pacchPred) {
		this.pacchPred = pacchPred;
	}
	
	public String creazionePacchPred(){
		List<PacchPredDTO> listDTO = pacchPredMgrBean.getAllPacchPred();
		int id;
		if(listDTO.isEmpty()) {
			id = 1;
		} else {
			id = listDTO.get(listDTO.size() -1).getIdPacchPred() + 1;
		}
		return "/impiegato/creazionePacchPred?faces-redirect=true"
				+ "&amp;id=" + id;
	}

	public String pagPacchPred(int id){
		return "/impiegato/creazionePacchPred?faces-redirect=true"
				+ "&amp;id=" + id
				;
	}

	public String removePacchPred(int id){
		System.out.println("pacchetto "+ id);
		if(!pacchPredMgrBean.removePacchPred(id)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Attenzione", "il pacchetto non puo' "
					+ "essere eliminato perchè un pacchetto personalizzato di un cliente fa riferimento ad esso"));
		return null;
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successo", "pacchetto Eliminato"));
			//return "/impiegato/ricercaPacchPred?faces-redirect=true";
			return "homePage?faces-redirect=true";
		}
	}

}
