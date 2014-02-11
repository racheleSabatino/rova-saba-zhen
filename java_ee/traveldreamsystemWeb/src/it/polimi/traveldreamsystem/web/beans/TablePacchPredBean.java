package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
 


import java.io.Serializable;  
import java.util.ArrayList;  
import java.util.List;  

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
         

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
        
        private int idPacchettoSelezionato;
        
        private String destinazioneCercata;
        
        public TablePacchPredBean() {  
        }
        
        @PostConstruct
        public void init() {  
                pacchetti = pacchPredMgr.getAllPacchPred();
        }  
             
        public PacchPredDTO getSelectedPacchetto() {  
                return selectedPacchetto;  
        }  
         
        public void setSelectedPacchetto(PacchPredDTO selectedPacchetto) {  
                this.selectedPacchetto = selectedPacchetto;  
                updateDetailPacch(selectedPacchetto);
                idPacchettoSelezionato = selectedPacchetto.getIdPacchPred();
        }  
           
         
        public List<PacchPredDTO> getPacchetti() {  
	        	init();
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

		public int getIdPacchettoSelezionato() {
			return idPacchettoSelezionato;
		}

		public void setIdPacchettoSelezionato(int idPacchettoSelezionato) {
			this.idPacchettoSelezionato = idPacchettoSelezionato;
		}

		public String getDestinazioneCercata() {
			return destinazioneCercata;
		}

		public void setDestinazioneCercata(String destinazioneCercata) {
			this.destinazioneCercata = destinazioneCercata;
		}  
	  
		public void findPerDestinazione(){
			List<PacchPredDTO> pacchettiCercati = pacchPredMgr.getCittaHotelPacch(destinazioneCercata);
			if(pacchettiCercati.isEmpty()){
				FacesContext mex = FacesContext.getCurrentInstance();
				mex.addMessage("null", new FacesMessage("Non ci sono pacchetti vacanza aventi la destinazione "
						+ "digitata"));
			}
			setPacchetti(pacchettiCercati);
		}
	
           
}
