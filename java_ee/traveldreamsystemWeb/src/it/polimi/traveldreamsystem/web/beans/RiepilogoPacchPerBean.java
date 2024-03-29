package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.MailerBeanLocal;
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


@ManagedBean
@SessionScoped
public class RiepilogoPacchPerBean {

	@EJB
    ComposizPacchPerMgrLocal comp;
     
    @EJB
    PacchPerMgrLocal pacchPerMgr;
       
    @EJB
    UtenteMgrBeanLocal utenteMgr; 
    
    @EJB
    MailerBeanLocal mailerBean;
   
    private PacchPerDTO pacchetto; 
    
    private int idPacchPer;
   
    private List<HotelDTO> hotels;
	
	private List<EscursioneDTO> escursioni;
	
	private List<TrasportoDTO> trasporti;
	
	 private HotelDTO selectedHotel;
		
	private EscursioneDTO selectedEscursione;
		
	private TrasportoDTO selectedTrasporto;
    
    private String hotel;
    
    private String escursione;
    
    private boolean creaListaRegali;
    
    private String mailAmicoInvito;
    
    private String mailAmicoRegali;
    
	public String getMailAmicoInvito() {
		return mailAmicoInvito;
	}

	public void setMailAmicoInvito(String mailAmicoInvito) {
		this.mailAmicoInvito = mailAmicoInvito;
	}

	public String getMailAmicoRegali() {
		return mailAmicoRegali;
	}

	public void setMailAmicoRegali(String mailAmicoRegali) {
		this.mailAmicoRegali = mailAmicoRegali;
	}

	public RiepilogoPacchPerBean() {
    }
    
    public void init() {  
    	idPacchPer = pacchetto.getIdPacchPer();
        hotel = comp.convertToStringHotel(idPacchPer);
        escursione = comp.convertToStringEscursione(idPacchPer);
        trasporto = comp.convertToStringTrasporto(idPacchPer);
        costoTotale = pacchPerMgr.viewCostoTotale(idPacchPer);
        regaloAmici = pacchPerMgr.viewTotaleAcquistatoDaAmici(idPacchPer);
        System.out.println("tot acquistato da amici " + regaloAmici);
        totaleDaPagare = costoTotale - regaloAmici;
        hotels = comp.getHotelsPacchPer(idPacchPer);
        escursioni = comp.getEscursioniPacchPer(idPacchPer);
        trasporti = comp.getTrasportiPacchPer(idPacchPer); 
        if(pacchetto.isListaRegali()) {
        	creaListaRegali = false;
        } else {
        	creaListaRegali = true;
        }
        
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
    	if(pacchetto != null)
    		pacchetto = pacchPerMgr.findPacchPerDTO(pacchetto.getIdPacchPer());
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
	

	public void removePacchetto(int id){
		pacchPerMgr.removePacchPer(id);
		FacesContext messaggio = FacesContext.getCurrentInstance();
		messaggio.addMessage(null, new FacesMessage("Successo", "Il pacchetto personalizzato � stato eliminato, "
				+ "ricaricando la pagina il pacchetto eliminato non sar� pi� visualizzato"));
	}
	
	public void removePacchetto(){
		pacchPerMgr.removePacchPer(idPacchPer);
		FacesContext messaggio = FacesContext.getCurrentInstance();
		messaggio.addMessage(null, new FacesMessage("Successo", "Il pacchetto personalizzato � stato eliminato, "
				+ "ricaricando la pagina il pacchetto eliminato non sar� pi� visualizzato"));
	}

	public void setPacchetto(PacchPerDTO pacchetto) {
		this.pacchetto = pacchetto;
		init();
	}
	
	public String creaLRegali() {
		pacchPerMgr.creaListaRegali(idPacchPer);
		FacesContext messaggio = FacesContext.getCurrentInstance();
		messaggio.addMessage(null, new FacesMessage("Successo", "ora il tuo pacchetto personalizzato � diventato"
				+ " una lista regali"));
		return "riepilogoPacchetto?faces-redirect=true";
	}

	public boolean isCreaListaRegali() {
		return creaListaRegali;
	}

	public void setCreaListaRegali(boolean creaListaRegali) {
		this.creaListaRegali = creaListaRegali;
	}
	
	public String showListaRegalo() {
		this.setPacchetto(pacchPerMgr.findPacchPerDTO(idPacchPer));
		return "/cliente/viewListeRegalo?faces-redirect=true";
	}

	public int getIdPacchPer() {
		return idPacchPer;
	}

	public void setIdPacchPer(int idPacchPer) {
		this.idPacchPer = idPacchPer;
	}
	
	public String isEscursioneAcquistata() {
		if(pacchPerMgr.ckeckEscursioneGiaAcquistata(idPacchPer, selectedEscursione.getIdProdBase())) {
		return "� stato acquistato da un tuo amico";
	}
		else {
			return "Non � ancora acquistato da un tuo amico";
		}
	}
	
	public String isHotelAcquistato() {
		if(pacchPerMgr.ckeckHotelGiaAcquistato(idPacchPer, selectedHotel.getIdProdBase())) {
		return "� stato acquistato da un tuo amico";
	}
		else {
			return "Non � ancora stato acquistato da un tuo amico";
		}
	}
	
	public String isTrasportoAcquistato() {
		if(pacchPerMgr.ckeckTrasportoGiaAcquistato(idPacchPer, selectedTrasporto.getIdProdBase())) {
		return "� stato acquistato da un tuo amico";
	}
		else {
			return "Non � ancora stato acquistato da un tuo amico";
		}
	}
	
	public void inviaInvito(){
		String senderMailID = utenteMgr.getPrincipalEmail();
		String link = new String("http://localhost:8080/traveldreamsystemWeb/public/invitoPacch.xhtml?id=" + 
		idPacchPer + "&mail=" + senderMailID);
		String emailBody = "Ciao, \n Il tuo amico " + senderMailID + " ti invita ad unirti a lui in" 
				+ " un magnifico pacchetto vacanza, clicca sul link per visionarne tutti i dettagli"
				+ "\n" + link;
		String emailSubject = "INVITO AD UNIRTI AD UN PACCHETTO VACANZA";
		mailerBean.sendMessage(mailAmicoInvito, emailSubject, emailBody);
		System.out.println("invio con successo3");
		FacesContext messaggio = FacesContext.getCurrentInstance();
		messaggio.addMessage(null, new FacesMessage("Successo", "la mail di invito al tuo amico � stata "
				+ "inviata con successo"));
	}
	
	public void inviaInvitoLista(){
		pacchPerMgr.creaListaRegali(idPacchPer);
		FacesContext messaggio = FacesContext.getCurrentInstance();

		String senderMailID = utenteMgr.getPrincipalEmail();
		String link = new String("http://localhost:8080/traveldreamsystemWeb/public/compraRegali.xhtml?id=" + 
		idPacchPer + "&mail=" + senderMailID);
		String emailBody = "Ciao, \n Il tuo amico " + senderMailID + " ha deciso di prenotare un magnifico "
				+ "pacchetto vacanza dal nostro sito TravelDreamSystem e ha bisogno del tuo aiuto. "
				+ "Il nostro sito gli ha offerto la possibilit� di creare una lista regalo dal suo pacchetto, "
				+ "se ne hai la possibilit�, fagli un regalo! Acquista per lui un prodotto della lista e gli"
				+ " mostrerai la tua amicizia."
				+ "Clicca sul link seguente: " + link + 
				" \n\n\n Ti aspettiamo sul nostro sito \n\n\nServizio Clienti TravelDreamSystem";
		String emailSubject = "INVITO PER LISTA REGALO";
		mailerBean.sendMessage(mailAmicoRegali, emailSubject, emailBody);
		messaggio.addMessage(null, new FacesMessage("Successo", "la mail di invito al tuo amico � stata"
				+ " inviata con successo"));
	}

	
}

