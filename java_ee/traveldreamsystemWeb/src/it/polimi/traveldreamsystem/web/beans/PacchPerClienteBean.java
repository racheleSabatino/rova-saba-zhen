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
    
    private List<PacchPerDTO> pacchetti;  
   
    private PacchPerDTO selectedPacchetto;  
      
      
    public PacchPerClienteBean() {
    	
    }
    @PostConstruct
    public void init() {  
    	String mailCliente = utenteMgr.getPrincipalEmail();
    	pacchetti = pacchPerMgr.getClientePacchPerDTONonAcquistati(mailCliente);
    }  
           
    public PacchPerDTO getSelectedPacchetto() {  
        return selectedPacchetto;  
    }  
       
    public void setSelectedPacchetto(PacchPerDTO selectedPacchetto) {  
        this.selectedPacchetto = selectedPacchetto;  
      }  
         
       
    public List<PacchPerDTO> getPacchetti() {  
    	return pacchetti;  
    }
     
    public List<PacchPerDTO> setPacchetti(List<PacchPerDTO> list) {  
    	return pacchetti = list;  
    }
 
	  
	public String pagModificaPacchPer(int id){
		return "/cliente/creazionePacchPer?faces-redirect=true"
		+ "&amp;id=" + id;
	}
	
	public String pagRiepilogoPacchPer(int id){
		return "/cliente/riepilogoPacchetto?faces-redirect=true"
		+ "&amp;id=" + id;
	}
	
	public void removePacchetto(){
		pacchPerMgr.removePacchPer(selectedPacchetto.getIdPacchPer());
		FacesContext messaggio = FacesContext.getCurrentInstance();
		messaggio.addMessage(null, new FacesMessage("Pacchetto personalizzato eliminato con successo"));
	}

	
}
