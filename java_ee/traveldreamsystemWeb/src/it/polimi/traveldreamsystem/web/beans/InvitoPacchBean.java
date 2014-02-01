package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.xml.internal.security.Init;

import eccezioni.AcquistoProdDaPropriaLista;
import eccezioni.PacchettoScadutoException;
import eccezioni.ProdottoGiaAcquistato;


@ManagedBean
@ApplicationScoped
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
	
	public boolean isEscursioneAcquistato(int idEscursione){
		return !pacchPerMgr.ckeckEscursioneGiaAcquistata(searchedId, idEscursione);
		
	}
	
	public boolean isHotelAcquistato(int idHotel){
		return !pacchPerMgr.ckeckHotelGiaAcquistato(searchedId, idHotel);
		
	}
	
	public boolean isTrasportoAcquistato(int idTrasporto){
		return !pacchPerMgr.ckeckTrasportoGiaAcquistato(searchedId, idTrasporto);
		
	}
	
	public void compraEscursione() throws PacchettoScadutoException, AcquistoProdDaPropriaLista, ProdottoGiaAcquistato{
		pacchPerMgr.acquistaEscursioneListaRegali(selectedEscursione.getIdProdBase(), searchedId, utenteMgr.getPrincipalEmail());
	}
	
	
	public void compraHotel() throws PacchettoScadutoException, AcquistoProdDaPropriaLista, ProdottoGiaAcquistato{
		pacchPerMgr.acquistaHotelListaRegali(selectedHotel.getIdProdBase(), searchedId, utenteMgr.getPrincipalEmail());
	}
	
	public void compraTrasporto() throws PacchettoScadutoException, AcquistoProdDaPropriaLista, ProdottoGiaAcquistato{
		pacchPerMgr.acquistaTrasportoListaRegali(selectedTrasporto.getIdProdBase(), searchedId, utenteMgr.getPrincipalEmail());
	}
	
	private boolean b = true;
	
	
	public String goMyUrl() {
		StringBuffer s=((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURL(); 
		b = false;
		return s.toString();
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}
	
	public void aggiungi(){
		String mail = utenteMgr.getPrincipalEmail();
		UtenteDTO utente = this.utenteMgr.findUtenteDTO(mail);
		comp.addPacchAmico(searchedPacch, escursioni, hotels, trasporti, utente);
		FacesContext mex = FacesContext.getCurrentInstance();
		mex.addMessage(null, new FacesMessage("Successo", "pacchetto aggiungo alla tua lista. Potrai modificarlo"
				+ " accendendo alla pagina Pacchetti Personalizzati che trovi nel menù cliente"));
	}
}
