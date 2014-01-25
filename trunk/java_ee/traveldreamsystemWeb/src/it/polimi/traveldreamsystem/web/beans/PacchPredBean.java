package it.polimi.traveldreamsystem.web.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

@ManagedBean
@RequestScoped
public class PacchPredBean {

	@EJB
	private PacchPredMgrLocal pacchPredMgrBean;

	private PacchPredDTO pacchPred;

	public void addPacchPred(){
		pacchPredMgrBean.addNewPacchPred(pacchPred);
	}

	public PacchPredDTO getPacchPred() {
		return pacchPred;
	}

	public void setPacchPred(PacchPredDTO pacchPred) {
		this.pacchPred = pacchPred;
	}
	
	public PacchPredDTO getTestPacch() {
		return pacchPredMgrBean.getAllPacchPred().get(0);
	}

}
