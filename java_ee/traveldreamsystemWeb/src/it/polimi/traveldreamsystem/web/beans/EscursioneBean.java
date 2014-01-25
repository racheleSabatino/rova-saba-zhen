package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.EscursioneMgrBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@SessionScoped
public class EscursioneBean {/*

        <p:remoteCommand name="onload" action="#{bean.onload}" autoRun="true" />
        */

	@EJB
	private PacchPredMgrLocal pacchPredMgrBean;
	
	@EJB
	private ComposizPacchPredMgrLocal compPacchMgr;

	@EJB
	private EscursioneMgrBeanLocal escursioneMgrBean;
	
	private PacchPredDTO pacchPred;

	private List<EscursioneDTO> escursioni;

	private List<EscursioneDTO> filteredEscursioni;

	private EscursioneDTO escursione;
	
	public EscursioneBean() {
	}

	@PostConstruct
	public void init() {
		escursione = new EscursioneDTO();
		escursioni = escursioneMgrBean.getAllEscursione();
		pacchPred = pacchPredMgrBean.getAllPacchPred().get(0);
		for(EscursioneDTO esc: escursioni) {
			if(compPacchMgr.getEscursioniPacchPred(pacchPred.getIdPacchPred()).contains(esc)) {
				esc.setSelected(true);
			} else {
				esc.setSelected(false);
			}
		}
	}
	


	public void onCellEdit(CellEditEvent event) {

		System.out.println("cell edit");
	}

	public void onEdit(RowEditEvent event) {

		System.out.println("row edit");
	}


	public void setEscursioni(List<EscursioneDTO> escursioni) {
		this.escursioni = escursioni;
	}

	public void onCancel(RowEditEvent event) {

		System.out.println("cell rem");
	}

	public List<EscursioneDTO> getEscursioni() {
		return escursioni;
	}

	public EscursioneDTO getEscursione() {
		return escursione;
	}

	public void setEscursione(EscursioneDTO escursione) {
		this.escursione = escursione;
	}

	public void addEscursione() {
		escursioneMgrBean.addNewEscursione(escursione);
	}

	public List<EscursioneDTO> getFilteredEscursioni() {
		return filteredEscursioni;
	}

	public void setFilteredEscursioni(List<EscursioneDTO> filteredEscursioni) {
		this.filteredEscursioni = filteredEscursioni;
	}

	public void selected() {
		System.out.println("select");
		if(escursione.getSelected()) {
			escursione.setSelected(false);
		} else {
			escursione.setSelected(true);
		}
	}

	public String save() {
		System.out.println("cell save");

		for(EscursioneDTO esc: escursioni) {
			escursioneMgrBean.update(esc);
			if(esc.getSelected() && !compPacchMgr.getEscursioniPacchPred(pacchPred.getIdPacchPred()).contains(esc)) {
				compPacchMgr.addEscursioneToPacch(pacchPred.getIdPacchPred(), esc.getIdProdBase());
			}
		}
		pacchPredMgrBean.update(pacchPred);
		return "/homePage?faces-redirect=true";
	}

}
