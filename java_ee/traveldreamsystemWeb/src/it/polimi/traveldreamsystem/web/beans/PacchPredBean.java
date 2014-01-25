package it.polimi.traveldreamsystem.web.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

@ManagedBean
@SessionScoped
public class PacchPredBean {
	
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
	
	public PacchPredDTO getTestPacch() {
		return pacchPredMgrBean.getAllPacchPred().get(0);
	}

}
