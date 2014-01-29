package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class PacchPerClienteBean {
	  
	@EJB
    ComposizPacchPredMgrLocal comp;
     
    @EJB
    PacchPerMgrLocal pacchPerMgr;
       
    @EJB
    UtenteMgrBeanLocal utenteMgr;
    
    private List<PacchPerDTO> pacchettiNonAcquistati;
    
    private List<PacchPerDTO> pacchettiAcquistati;
   
    private PacchPerDTO selectedPacchettoA;  
      
    private PacchPerDTO selectedPacchettoN; 
    
    public PacchPerClienteBean() {
    	
    }
    @PostConstruct
    public void init() {  
    	String mailCliente = utenteMgr.getPrincipalEmail();
    	pacchettiNonAcquistati = pacchPerMgr.getClientePacchPerDTONonAcquistati(mailCliente);
    	pacchettiAcquistati = pacchPerMgr.getClientePacchPerDTOAcquistati(mailCliente);
    }  
           
    public PacchPerDTO getSelectedPacchettoA() {  
        return selectedPacchettoA;  
    }  
       
    public void setSelectedPacchetto(PacchPerDTO selectedPacchetto) {  
        this.selectedPacchettoA = selectedPacchetto;  
      }  
         
       
    public List<PacchPerDTO> getPacchettiNonAcquistati() {  
    	return pacchettiNonAcquistati;  
    }
     
    public List<PacchPerDTO> setPacchetti(List<PacchPerDTO> list) {  
    	return pacchettiNonAcquistati = list;  
    }
 
	  
	public String pagModificaPacchPer(int id){
		return "/cliente/creazionePacchPer?faces-redirect=true"
		+ "&amp;id=" + id;
	}
	
	public String pagRiepilogoPacchPer(int id){
		return "/cliente/riepilogoPacchetto?faces-redirect=true"
	+ "&amp;id=" + id;
	}
	
	public List<PacchPerDTO> getPacchettiAcquistati() {
		return pacchettiAcquistati;
	}
	public void setPacchettiAcquistati(List<PacchPerDTO> pacchettiAcquistati) {
		this.pacchettiAcquistati = pacchettiAcquistati;
	}
	public PacchPerDTO getSelectedPacchettoN() {
		return selectedPacchettoN;
	}
	public void setSelectedPacchettoN(PacchPerDTO selectedPacchettoN) {
		this.selectedPacchettoN = selectedPacchettoN;
	}

	
}
