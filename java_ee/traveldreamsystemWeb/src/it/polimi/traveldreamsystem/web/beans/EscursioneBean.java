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
public class EscursioneBean extends PacchPredBean{
	
	@EJB
	private EscursioneMgrBeanLocal escursioneMgrBean;

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

	public EscursioneBean() {
		escursione = new EscursioneDTO();
	}

	public void init(int id) {
		escursioni = escursioneMgrBean.getAllEscursione();
		pacchPred = pacchPredMgrBean.findPacchPredDTO(id);
		for (EscursioneDTO aDTO : escursioni) {
			if (compPacchMgr.findEscursione(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
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
		escursioneMgrBean.addNewEscursione(escursione);
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
			escursioneMgrBean.update(aDTO);
			if (aDTO.getSelected()
					&& !compPacchMgr.findEscursione(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
				compPacchMgr.addEscursioneToPacch(pacchPred.getIdPacchPred(),
						aDTO.getIdProdBase());
			}
			if (!aDTO.getSelected()
					&& compPacchMgr.findEscursione(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
				compPacchMgr.removeEscursioneToPacch(pacchPred.getIdPacchPred(),
						aDTO.getIdProdBase());
			}
		}
		pacchPredMgrBean.update(pacchPred);
	}

}
