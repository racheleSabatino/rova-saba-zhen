package it.polimi.traveldreamsystem.web.beans;

import java.util.ArrayList;
import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.EscursioneMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@RequestScoped
public class EscursioneBean {

	@EJB
	private EscursioneMgrBeanLocal escursioneMgrBean;

	private List<EscursioneDTO> escursioni;
	
	private EscursioneDTO escursione;
	
	private EscursioneDataModel escursioneDataModel;
	
	public EscursioneBean() {
	}

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    	
    	/*
        FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getModel());

        FacesContext.getCurrentInstance().addMessage(null, msg);*/
    }
    
    public void onCancel(RowEditEvent event) {/*
        FacesMessage msg = new FacesMessage("Car Cancelled", ((Car) event.getObject()).getModel());

        FacesContext.getCurrentInstance().addMessage(null, msg);*/
    }
	
	@PostConstruct
	public void init(){
		escursione = new EscursioneDTO();
		escursioni = new ArrayList<EscursioneDTO>();
		escursioneDataModel = new EscursioneDataModel(getAllEscursione());
	}
	
	public List<EscursioneDTO> getEscursioni() {
		return escursioni;
	}


	public void setEscursioni(List<EscursioneDTO> escursioni) {
		this.escursioni = escursioni;
	}


	public List<EscursioneDTO> getAllEscursione() {
		return escursioneMgrBean.getAllEscursione();
	}

	public EscursioneDataModel getEscursioneDataModel() {
		return escursioneDataModel;
	}

	public void setEscursioneDataModel(EscursioneDataModel escursioneDataModel) {
		this.escursioneDataModel = escursioneDataModel;
	}

	public EscursioneDTO getEscursione() {
		return escursione;
	}

	public void setEscursione(EscursioneDTO escursione) {
		this.escursione = escursione;
	}
	
	public void addEscursione(){
		escursioneMgrBean.addNewEscursione(escursione);
	}
	
}
