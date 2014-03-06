package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.TrasportoMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@SessionScoped
public class TrasportoBeanPer extends PacchPerBean {

	private List<TrasportoDTO> trasporti;

	private List<TrasportoDTO> filteredTrasporti;

	private TrasportoDTO trasporto;

	private int pacchId;
	
	private int idPacchPred;
	
	public int getIdPacchPred() {
		return idPacchPred;
	}

	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	private String mail;

	public int getPacchId() {
		return pacchId;
	}

	public void setPacchId(int pacchId) {
		this.pacchId = pacchId;
		init(pacchId);
	}
	
	public TrasportoBeanPer() {
		trasporto = new TrasportoDTO();
	}

	public void init(int id) {
		pacchPer = pacchPerMgrBean.findPacchPerDTO(id);
		if(pacchPer == null) {
			pacchPer = new PacchPerDTO(id, false, getPacchPred(idPacchPred), getCliente(mail));
		}
		trasporti = compPacchPredMgr.getTrasportiPacchPred(pacchPer.getPacchPred().getIdPacchPred());
		for (TrasportoDTO aDTO : trasporti) {
			if (compPacchPerMgr.findTrasporto(pacchPer.getIdPacchPer(), aDTO.getIdProdBase())) {
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

	public void addTrasporto(){
		compPacchPerMgr.addTrasportoToPacchPer(pacchId, trasporto.getIdProdBase());
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

	public void save(AjaxBehaviorEvent e) {
		System.out.println("cell save");

		for (TrasportoDTO aDTO : trasporti) {
			if (aDTO.getSelected()
					&& !compPacchPerMgr.findTrasporto(pacchPer.getIdPacchPer(), aDTO.getIdProdBase())) {
				compPacchPerMgr.addTrasportoToPacchPer(pacchPer.getIdPacchPer(),
						aDTO.getIdProdBase());
			}
			if (!aDTO.getSelected()
					&& compPacchPerMgr.findTrasporto(pacchPer.getIdPacchPer(), aDTO.getIdProdBase())) {
				compPacchPerMgr.removeTrasportoToPacchPer(pacchPer.getIdPacchPer(),
						aDTO.getIdProdBase());
			}
		}
		pacchPerMgrBean.update(pacchPer);
	}
}

