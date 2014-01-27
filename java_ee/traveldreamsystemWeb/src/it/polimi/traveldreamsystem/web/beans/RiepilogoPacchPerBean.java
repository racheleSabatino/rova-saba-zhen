package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "riepilogoBean")
@RequestScoped
public class RiepilogoPacchPerBean {

	@EJB
    ComposizPacchPerMgrLocal comp;
     
    @EJB
    PacchPerMgrLocal pacchPerMgr;
       
    @EJB
    UtenteMgrBeanLocal utenteMgr; 
   
    private PacchPerDTO pacchetto;  
    
    private String hotel;
    
    private String escursione;
    
    private String trasporto;
    
    public RiepilogoPacchPerBean() {
    }
    @PostConstruct
    public void init() {  
        hotel = comp.convertToStringHotel(pacchetto.getIdPacchPer());
        escursione = comp.convertToStringEscursione(pacchetto.getIdPacchPer());
        trasporto = comp.convertToStringTrasporto(pacchetto.getIdPacchPer());
    }

    public PacchPerDTO getPacchetto() {
    	return pacchetto;
    }

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getEscursione() {
		return escursione;
	}

	public void setEscursione(String escursione) {
		this.escursione = escursione;
	}

	public String getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(String trasporto) {
		this.trasporto = trasporto;
	}
	

}
