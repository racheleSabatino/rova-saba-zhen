package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.CheckDateLocal;
import it.polimi.traveldreamsystem.SessionBeans.TrasportoMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@SessionScoped
public class TrasportoBean extends PacchPredBean {

	@EJB
	private TrasportoMgrBeanLocal trasportoMgrBean;
	
	@EJB
	private CheckDateLocal checkDateBean;

	private List<TrasportoDTO> trasporti;

	private List<TrasportoDTO> filteredTrasporti;

	private TrasportoDTO trasporto;

	private int pacchId;

	public int getPacchId() {
		return pacchId;
	}

	public void setPacchId(int pacchId) {
		this.pacchId = pacchId;
		init(pacchId);
	}
	
	public TrasportoBean() {
		trasporto = new TrasportoDTO();
	}

	public void init(int id) {
		trasporti = trasportoMgrBean.getAllTrasporto();
		pacchPred = pacchPredMgrBean.findPacchPredDTO(id);
		if(pacchPred == null) {
			pacchPred = new PacchPredDTO(id);
		}
		for (TrasportoDTO aDTO : trasporti) {
			if (compPacchMgr.findTrasporto(pacchPred.getIdPacchPred(), aDTO.getIdProdBase())) {
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
		FacesContext context = FacesContext.getCurrentInstance();
		if(!checkDateBean.checkDate(trasporto.getDataPartenza(), trasporto.getDataRitorno())){
			context.addMessage(null, new FacesMessage("Controllare i valori inseriti, "
					+ "la data di ritorno deve essere uguale o successiva alla data della partenza. "
					+ "Inserire valori corretti e poi ripremere il pulsante Salva"));
		}
		else {
			TrasportoDTO e = trasportoMgrBean.findTrasportoDTO(trasporto.getIdProdBase());
			if(e != null) {
				trasportoMgrBean.update(e);
				context.addMessage(null, new FacesMessage("Modifica avvenuta con successo")); 
			}
		trasportoMgrBean.addNewTrasporto(trasporto);
        context.addMessage(null, new FacesMessage("Creazione avvenuta con successo"));  
		}
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
		System.out.println("cell save trasporti");

		pacchPredMgrBean.update(pacchPred);
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
	}
	
	public String getPage(int idTrasporto){
		return trasportoMgrBean.pagRiepilogoPacchPer(idTrasporto);
	}
	
	public String goToPaginaModifica(int idTrasporto){
		return "/impiegato/creazioneTrasporto?faces-redirect=true"
				+ "&amp;id=" + idTrasporto;
	}

}
