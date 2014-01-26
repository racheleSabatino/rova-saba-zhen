package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.EscursioneMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@SessionScoped
public class EscursioneBeanPer extends PacchPerBean{

	private List<EscursioneDTO> escursioni;

	private List<EscursioneDTO> filteredEscursioni;

	private EscursioneDTO escursione;

	private int pacchId;

	public int getPacchId() {
		return pacchId;
	}

	public void setPacchId(int pacchId) {
		this.pacchId = pacchId;
		init(pacchId);
	}

	public EscursioneBeanPer() {
		escursione = new EscursioneDTO();
	}

	public void init(int id) {
		pacchPer = pacchPerMgrBean.findPacchPerDTO(id);
		escursioni = compPacchPredMgr.getEscursioniPacchPred(pacchPer.getIdPacchPred());
		for (EscursioneDTO aDTO : escursioni) {
			if (compPacchPerMgr.findEscursione(pacchPer.getIdPacchPred(), aDTO.getIdProdBase())) {
				aDTO.setSelected(true);
			} else {
				aDTO.setSelected(false);
			}
		}
	}
	
	public void init() {
		init(pacchId);
	}

	public void initajax(AjaxBehaviorEvent e) {
		init();
	}

	public void addEscursione() {
		compPacchPerMgr.addEscursioneToPacchPer(pacchId, escursione.getIdProdBase());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Creazione avvenuta con successo"));  
	}

	public EscursioneDTO getEscursione() {
		return escursione;
	}

	public void setEscursione(EscursioneDTO escursione) {
		this.escursione = escursione;
	}

	public List<EscursioneDTO> getEscursioni() {
		return escursioni;
	}

	public void setEscursioni(List<EscursioneDTO> escursioni) {
		this.escursioni = escursioni;
	}

	public List<EscursioneDTO> getFilteredEscursioni() {
		return filteredEscursioni;
	}

	public void setFilteredEscursioni(List<EscursioneDTO> filteredEscursioni) {
		this.filteredEscursioni = filteredEscursioni;
	}

	public void selected() {
		System.out.println("select");
		if (escursione.getSelected()) {
			escursione.setSelected(false);
		} else {
			escursione.setSelected(true);
		}
	}

	public void save(AjaxBehaviorEvent e) {
		System.out.println("cell save");

		for (EscursioneDTO aDTO : escursioni) {
			if (aDTO.getSelected()
					&& !compPacchPerMgr.findEscursione(pacchPer.getIdPacchPred(), aDTO.getIdProdBase())) {
				compPacchPerMgr.addEscursioneToPacchPer(pacchPer.getIdPacchPred(),
						aDTO.getIdProdBase());
			}
			if (!aDTO.getSelected()
					&& compPacchPerMgr.findEscursione(pacchPer.getIdPacchPred(), aDTO.getIdProdBase())) {
				compPacchPerMgr.removeEscursioneToPacchPer(pacchPer.getIdPacchPred(),
						aDTO.getIdProdBase());
			}
		}
		pacchPerMgrBean.update(pacchPer);
	}

}
