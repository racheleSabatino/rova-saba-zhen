package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.TrasportoMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class TrasportoBean extends PacchPredBean {

	@EJB
	private TrasportoMgrBeanLocal trasportoMgrBean;

	private List<TrasportoDTO> trasporti;

	private List<TrasportoDTO> filteredTrasporti;

	private TrasportoDTO trasporto;
	
	public TrasportoBean() {
		trasporto = new TrasportoDTO();
	}

	@PostConstruct
	public void init() {
		trasporto = new TrasportoDTO();
		trasporti = trasportoMgrBean.getAllTrasporto();
		pacchPred = pacchPredMgrBean.getAllPacchPred().get(0);
		for (TrasportoDTO aDTO : trasporti) {
			if (compPacchMgr.findTrasporto(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
				aDTO.setSelected(true);
			} else {
				aDTO.setSelected(false);
			}
		}
	}

	public void addTrasporto(){
		trasportoMgrBean.addNewTrasporto(trasporto);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Creazione avvenuta con successo"));  

	}

	public TrasportoDTO getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(TrasportoDTO trasporto) {
		this.trasporto = trasporto;
	}

	public List<TrasportoDTO> getTrasporti() {
		return trasporti;
	}

	public void setTrasporti(List<TrasportoDTO> trasporti) {
		this.trasporti = trasporti;
	}

	public List<TrasportoDTO> getFilteredTrasporti() {
		return filteredTrasporti;
	}

	public void setFilteredTrasporti(List<TrasportoDTO> filteredTrasporti) {
		this.filteredTrasporti = filteredTrasporti;
	}
	
	public void selected() {
		System.out.println("select");
		if (trasporto.getSelected()) {
			trasporto.setSelected(false);
		} else {
			trasporto.setSelected(true);
		}
	}

	public String save() {
		System.out.println("cell save");

		for (TrasportoDTO aDTO : trasporti) {
			trasportoMgrBean.update(aDTO);
			if (aDTO.getSelected()
					&& !compPacchMgr.findTrasporto(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
				compPacchMgr.addTrasportoToPacch(pacchPred.getIdPacchPred(),
						aDTO.getIdProdBase());
			}
			if (!aDTO.getSelected()
					&& compPacchMgr.findTrasporto(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
				compPacchMgr.removeTrasportoToPacch(pacchPred.getIdPacchPred(),
						aDTO.getIdProdBase());
			}
		}
		pacchPredMgrBean.update(pacchPred);
		return "/homePage?faces-redirect=true";
	}
	
}
