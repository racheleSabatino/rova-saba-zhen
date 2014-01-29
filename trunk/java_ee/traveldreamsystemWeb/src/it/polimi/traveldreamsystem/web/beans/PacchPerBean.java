package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import eccezioni.PacchettoScadutoException;
import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.MailerBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

@ManagedBean
@SessionScoped
public class PacchPerBean {
	
	@EJB
	protected PacchPerMgrLocal pacchPerMgrBean;

	@EJB
	protected ComposizPacchPerMgrLocal compPacchPerMgr;

	@EJB
	protected ComposizPacchPredMgrLocal compPacchPredMgr;
	
	@EJB
	protected MailerBeanLocal mailerMgr;
	
	@EJB
	protected UtenteMgrBeanLocal utenteMgr;

	protected PacchPerDTO pacchPer;
	
	private PacchPredDTO pacchPred;
	
	private UtenteDTO cliente;
	
	private String mailAmico;

	private MailerManagedBean mailMgr;
	
	public PacchPerBean() {
		mailMgr = new MailerManagedBean();
	}
	
	public String getMailAmico() {
		return mailAmico;
	}

	public void setMailAmico(String mailAmico) {
		this.mailAmico = mailAmico;
	}

	public void addPacchPer(){
		pacchPerMgrBean.addNewPacchPer(pacchPer);
	}

	public PacchPerDTO getPacchPer() {
		return pacchPer;
	}

	public void setPacchPer(PacchPerDTO pacchPer) {
		this.pacchPer = pacchPer;
	}

	public String creazionePacchPer(){
		PacchPerDTO pacchPer = new PacchPerDTO(0, false, pacchPred, cliente);
		pacchPerMgrBean.addNewPacchPer(pacchPer);
		List<PacchPerDTO> listDTO = pacchPerMgrBean.getAllPacchPer();
		int id = listDTO.get(listDTO.size() -1).getIdPacchPer();
		return "/cliente/creazionePacchPer?faces-redirect=true"
				+ "&amp;id=" + id
				;
	}
	
	

	public PacchPredDTO getPacchPred() {
		return pacchPred;
	}

	public void setPacchPred(PacchPredDTO pacchPred) {
		this.pacchPred = pacchPred;
	}

	public UtenteDTO getCliente() {
		return cliente;
	}

	public void setCliente(UtenteDTO cliente) {
		this.cliente = cliente;
	}

	public void acquistaPacchetto() {
		 FacesContext context = FacesContext.getCurrentInstance();  
		try {
			pacchPerMgrBean.acquistaPacchPer(pacchPer.getIdPacchPer());
			context.addMessage(null, new FacesMessage("Conferma pacchetto acquistato con successo"));
		} catch (PacchettoScadutoException e) {
			 context.addMessage(null, new FacesMessage("Mi dispiace, il pacchetto non pu� pi� essere"
			 		+ "acquistato, poich� la data di pagamento � successiva alla data di ritorno dell'ultimo"
			 		+ "prodotto base che compone il pacchetto"));
		}
	}
	
	public void inviaInvitoLista(){
		String senderMailID = utenteMgr.getPrincipalEmail();
		String link = "http://localhost:8080/traveldreamsystemWeb/homePage.xhtml";
		String emailBody = "Ciao, \n Il tuo amico " + senderMailID + " ha deciso di prenotare un magnifico"
				+ "pacchetto vacanza dal nostro sito TravelDreamSystem"
				+ "\n" + link;
		String emailSubject = "INVITO AD UNIRTI AD UN PACCHETTO VACANZA";
		mailMgr.sendMessage(mailAmico, emailSubject, emailBody);
		FacesContext messaggio = FacesContext.getCurrentInstance();
		messaggio.addMessage(null, new FacesMessage("Successo", "la mail di invito al tuo amico � stata"
				+ "inviata con successo"));
	}
	
	
	public void inviaInvito(){
		String senderMailID = utenteMgr.getPrincipalEmail();
		String link = "http://localhost:8080/traveldreamsystemWeb/invitoPacch=.xhtml";
		String emailBody = "Ciao, \n Il tuo amico " + senderMailID + " ti invita ad unirti a lui in" 
				+ " un magnifico pacchetto vacanza, clicca sul link per visionarne tutti i dettagli"
				+ "\n" + link;
		String emailSubject = "INVITO AD UNIRTI AD UN PACCHETTO VACANZA";
		mailMgr.sendMessage(mailAmico, emailSubject, emailBody);
		FacesContext messaggio = FacesContext.getCurrentInstance();
		messaggio.addMessage(null, new FacesMessage("Successo", "la mail di invito al tuo amico � stata"
				+ "inviata con successo"));
	}

	
	
}
