package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sun.org.apache.xml.internal.security.Init;


@ManagedBean
@SessionScoped
public class InvitoPacchBean {
	private boolean resultPanelVisible;
	
	@EJB
	private PacchPerMgrLocal pacchMgrBean;
	
	
	@EJB
    ComposizPacchPerMgrLocal comp;
     
    @EJB
    PacchPerMgrLocal pacchPerMgr;
       
    @EJB
    UtenteMgrBeanLocal utenteMgr; 
   
	private String trasporto;

	
   
    private List<HotelDTO> hotels;
	
	private List<EscursioneDTO> escursioni;
	
	private List<TrasportoDTO> trasporti;
	
	 private HotelDTO selectedHotel;
		
	private EscursioneDTO selectedEscursione;
		
	private TrasportoDTO selectedTrasporto;
    
    private String hotel;
    
    private String escursione;
    
	private int searchedId;
	
	private PacchPerDTO searchedPacch;
	
	private String mail;

	public boolean isResultPanelVisible() {
		return resultPanelVisible;
	}

	public void setResultPanelVisible(boolean resultPanelVisible) {
		this.resultPanelVisible = resultPanelVisible;
	}

	public int getSearchedId() {
		return searchedId;
	}

	public void setSearchedId(int searchedId) {
		this.searchedId = searchedId;
	}

	public PacchPerDTO getSearchedPacch() {
		return searchedPacch;
	}

	public void setSearchedPacch(PacchPerDTO searchedPacch) {
		this.searchedPacch = searchedPacch;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public InvitoPacchBean(){

	}
	
	public PacchPerMgrLocal getPacchMgrBean() {
		return pacchMgrBean;
	}

	public void setPacchMgrBean(PacchPerMgrLocal pacchMgrBean) {
		this.pacchMgrBean = pacchMgrBean;
	}

	public ComposizPacchPerMgrLocal getComp() {
		return comp;
	}

	public void setComp(ComposizPacchPerMgrLocal comp) {
		this.comp = comp;
	}

	public PacchPerMgrLocal getPacchPerMgr() {
		return pacchPerMgr;
	}

	public void setPacchPerMgr(PacchPerMgrLocal pacchPerMgr) {
		this.pacchPerMgr = pacchPerMgr;
	}

	public UtenteMgrBeanLocal getUtenteMgr() {
		return utenteMgr;
	}

	public void setUtenteMgr(UtenteMgrBeanLocal utenteMgr) {
		this.utenteMgr = utenteMgr;
	}

	public String getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(String trasporto) {
		this.trasporto = trasporto;
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

	public void find() {
		FacesContext messaggio = FacesContext.getCurrentInstance();
		searchedPacch = pacchMgrBean.findPacchPerDTO(searchedId);
		if(searchedPacch != null && searchedPacch.getCliente().getMail().equals(mail)) {
			resultPanelVisible = true;
	        hotel = comp.convertToStringHotel(searchedId);
	        escursione = comp.convertToStringEscursione(searchedId);
	        trasporto = comp.convertToStringTrasporto(searchedId);
	        //costoTotale = pacchPerMgr.viewCostoTotale(searchedId);
	        //regaloAmici = pacchPerMgr.viewTotaleAcquistatoDaAmici(searchedId);
	        //totaleDaPagare = costoTotale - regaloAmici;
	        hotels = comp.getHotelsPacchPer(searchedId);
	        escursioni = comp.getEscursioniPacchPer(searchedId);
	        trasporti = comp.getTrasportiPacchPer(searchedId); 
			
		}
		else {
			messaggio.addMessage(null, new FacesMessage("Attenzione", "Dati errati "
					+ "accertarsi di aver inserito dati corretti"));
			resultPanelVisible = false;
		}
	}
	
	public void Init(){
		find();
		
	}
}
