package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

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
    
    private List<HotelDTO> hotels;
	
	private List<EscursioneDTO> escursioni;
	
	private List<TrasportoDTO> trasporti;
	
	 private HotelDTO selectedHotel;
		
	private EscursioneDTO selectedEscursione;
		
	private TrasportoDTO selectedTrasporto;
    
    private String hotel;
    
    private String escursione;
    
    public RiepilogoPacchPerBean() {
    }
    @PostConstruct
    public void init() {  
    	int id = pacchetto.getIdPacchPer();
        hotel = comp.convertToStringHotel(id);
        escursione = comp.convertToStringEscursione(id);
        trasporto = comp.convertToStringTrasporto(id);
        costoTotale = pacchPerMgr.viewCostoTotale(id);
        regaloAmici = pacchPerMgr.viewTotaleAcquistatoDaAmici(id);
        totaleDaPagare = costoTotale - regaloAmici;
        hotels = comp.getHotelsPacchPer(id);
        escursioni = comp.getEscursioniPacchPer(id);
        trasporti = comp.getTrasportiPacchPer(id);  
    }
    
    public HotelDTO getSelectedHotel() {
		return selectedHotel;
	}
	public void setSelectedHotel(HotelDTO selectedHotel) {
		this.selectedHotel = selectedHotel;
	}
	public EscursioneDTO getSelectedEscursione() {
		return selectedEscursione;
	}
	public void setSelectedEscursione(EscursioneDTO selectedEscursione) {
		this.selectedEscursione = selectedEscursione;
	}
	public TrasportoDTO getSelectedTrasporto() {
		return selectedTrasporto;
	}
	public void setSelectedTrasporto(TrasportoDTO selectedTrasporto) {
		this.selectedTrasporto = selectedTrasporto;
	}

	private String trasporto;
    
    public int costoTotale;
    
    public int regaloAmici;
    
    public int totaleDaPagare;

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

	public int getCostoTotale() {
		return costoTotale;
	}
	public void setCostoTotale(int costoTotale) {
		this.costoTotale = costoTotale;
	}
	public int getRegaloAmici() {
		return regaloAmici;
	}
	public void setRegaloAmici(int regaloAmici) {
		this.regaloAmici = regaloAmici;
	}
	public void setTrasporto(String trasporto) {
		this.trasporto = trasporto;
	}
	
	public void setTotaleDaPagare(int tot) {
		totaleDaPagare = tot;
	}
	
	public int getTotaleDaPagare(){
		return totaleDaPagare;
	}
	
	public List<HotelDTO> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelDTO> hotels) {
		this.hotels = hotels;
	}

	public List<EscursioneDTO> getEscursioni() {
		return escursioni;
	}

	public void setEscursioni(List<EscursioneDTO> escursioni) {
		this.escursioni = escursioni;
	}

	public List<TrasportoDTO> getTrasporti() {
		return trasporti;
	}

	public void setTrasporti(List<TrasportoDTO> trasporti) {
		this.trasporti = trasporti;
	}
}

