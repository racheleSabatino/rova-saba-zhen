package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

import java.io.IOException;  
import java.io.Serializable;  
import java.util.ArrayList;  
import java.util.List;  

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
	  

@ManagedBean
@SessionScoped
public class TablePacchPredBean implements Serializable {  

	private static final long serialVersionUID = 1L;


	@EJB
	ComposizPacchPredMgrLocal comp;
	
	@EJB
	PacchPredMgrLocal pacchPredMgr;
	  
    private List<PacchPredDTO> pacchetti;  
      
	private PacchPredDTO selectedPacchetto;  
	
	private String datePacchSelezionato;
	
	private String cittaPacchSelezionato;
	
	private String ciao; 

	public TablePacchPredBean() {  
	}
	  
	@PostConstruct
	public void init() {  
		pacchetti = pacchPredMgr.getAllPacchPred();
		setCiao("ciao");
	}  
	      
	public PacchPredDTO getSelectedPacchetto() {  
		return selectedPacchetto;  
	}  
	  
	public void setSelectedPacchetto(PacchPredDTO selectedPacchetto) {  
		this.selectedPacchetto = selectedPacchetto;  
	}  
	    
	  
	public List<PacchPredDTO> getPacchetti() {  
		return pacchetti;  
	} 
	
	public List<PacchPredDTO> setPacchetti(List<PacchPredDTO> list) {  
		return pacchetti = list;  
	} 
	  
	public String updateDetailPacch(PacchPredDTO selectedPacchetto){
		setDatePacchSelezionato(comp.getDatePacch(selectedPacchetto.getIdPacchPred()));
		setCittaPacchSelezionato(comp.getCittaPartenzaPacch(selectedPacchetto.getIdPacchPred()));
		return null;
	}
	

	public String getDatePacchSelezionato() {
		return datePacchSelezionato;
	}

	public void setDatePacchSelezionato(String datePacchSelezionato) {
		this.datePacchSelezionato = datePacchSelezionato;
	}

	public String getCittaPacchSelezionato() {
		return cittaPacchSelezionato;
	}

	public void setCittaPacchSelezionato(String cittaPacchSelezionato) {
		this.cittaPacchSelezionato = cittaPacchSelezionato;
	}

	public String getCiao() {
		return ciao;
	}

	public void setCiao(String ciao) {
		this.ciao = ciao;
	}
	      
	   
}
