package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

@ManagedBean
@SessionScoped
public class PacchPerBean {
	
	@EJB
	protected PacchPerMgrLocal pacchPerMgrBean;

	@EJB
	protected ComposizPacchPerMgrLocal compPacchMgr;

	protected PacchPerDTO pacchPer;

	public void addPacchPer(){
		pacchPerMgrBean.addNewPacchPer(pacchPer);
	}

	public PacchPerDTO getPacchPer() {
		return pacchPer;
	}

	public void setPacchPer(PacchPerDTO pacchPer) {
		this.pacchPer = pacchPer;
	}
	
	public PacchPerDTO getTestPacch() {
		return pacchPerMgrBean.getAllPacchPer().get(0);
	}

	public String creazionePacchPer(){
		PacchPerDTO pacchPer = new PacchPerDTO();
		pacchPerMgrBean.addNewPacchPer(pacchPer);
		List<PacchPerDTO> listDTO = pacchPerMgrBean.getAllPacchPer();
		int id = listDTO.get(listDTO.size() -1).getIdPacchPer();
		return "/creazionePacchPer?faces-redirect=true"
				+ "&amp;id=" + id
				;
	}

}
