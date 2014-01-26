package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

import java.io.IOException;  
import java.io.Serializable;  
import java.util.ArrayList;  
import java.util.List;  

import javax.ejb.EJB;
	  
	  
public class TablePacchPredBean implements Serializable {  

	@EJB
	PacchPredMgrLocal pacchPredMgr;

	  
    private List<PacchPredDTO> pacchetti;  
      
	private PacchPredDTO selectedPacchetto;  
	  
	public TablePacchPredBean() {  
		pacchetti = new ArrayList<PacchPredDTO>();  
		populateRandomPacchetti(pacchetti, 50);  
	}  
	      
	public PacchPredDTO getSelectedPacchPredDTO() {  
		return selectedPacchetto;  
	}  
	  
	public void setSelectedPacchetto(PacchPredDTO selectedPacchetto) {  
		this.selectedPacchetto = selectedPacchetto;  
	}  
	    
	private void populateRandomPacchetti(List<PacchPredDTO> list, int size) {
		pacchetti = pacchPredMgr.getAllPacchPred();
	}  
	  
	public List<PacchPredDTO> getPacchPredDTOs() {  
		return pacchetti;  
	}  
	  
	      
	   
}
