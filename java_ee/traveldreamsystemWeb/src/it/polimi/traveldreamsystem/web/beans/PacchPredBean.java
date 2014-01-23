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
	
	private EscursioneDataModel escursioneDataModel;

	public PacchPredBean() {
		pacchPred = new PacchPredDTO();
		escursioneDataModel = new EscursioneDataModel();
	}

	public void addPacchPred(){
		pacchPredMgrBean.addNewPacchPred(pacchPred);
	}

	public PacchPredDTO getPacchPred() {
		return pacchPred;
	}

	public void setPacchPred(PacchPredDTO pacchPred) {
		this.pacchPred = pacchPred;
	}

	public EscursioneDataModel getEscursioneDataModel() {
		return escursioneDataModel;
	}

	public void setEscursioneDataModel(EscursioneDataModel escursioneDataModel) {
		this.escursioneDataModel = escursioneDataModel;
	}
	
	public PacchPredDTO getTestPacch() {
		return pacchPredMgrBean.getAllPacchPred().get(0);
	}

}
