package it.polimi.traveldreamsystem.web.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import eccezioni.PacchettoScadutoException;
import it.polimi.traveldreamsystem.SessionBeans.ClienteMgrBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

@ManagedBean
@SessionScoped
public class PacchPerBean {
	
	@EJB
	protected PacchPerMgrLocal pacchPerMgrBean;
	
	@EJB
	protected PacchPredMgrLocal pacchPredMgrBean;

	@EJB
	protected ComposizPacchPerMgrLocal compPacchPerMgr;

	@EJB
	protected ComposizPacchPredMgrLocal compPacchPredMgr;
	
	@EJB
	protected UtenteMgrBeanLocal utenteMgr;

	protected PacchPerDTO pacchPer;
	
	private PacchPredDTO pacchPred;
	
	private UtenteDTO cliente;
	
	private String mailAmicoInvito;
	
	private String mailAmicoRegali;

	private MailerManagedBean mailMgr;
	
	public PacchPerBean() {
		mailMgr = new MailerManagedBean();
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
		List<PacchPerDTO> listDTO = pacchPerMgrBean.getAllPacchPer();
		int id;
		if(listDTO.isEmpty()) {
			id = 1;
		} else {
			id = listDTO.get(listDTO.size() -1).getIdPacchPer() + 1;
		}
		return "/cliente/creazionePacchPer?faces-redirect=true"
				+ "&amp;id=" + id + "&amp;idPacchPred=" + pacchPred.getIdPacchPred() + "&amp;mail=" + cliente.getMail();
	}
	


	public PacchPredDTO getPacchPred() {
		return pacchPred;
	}

	public PacchPredDTO getPacchPred(int id) {
		return pacchPredMgrBean.findPacchPredDTO(id);
	}

	public void setPacchPred(PacchPredDTO pacchPred) {
		this.pacchPred = pacchPred;
	}

	public UtenteDTO getCliente() {
		return cliente;
	}

	public UtenteDTO getCliente(String mail) {
		return utenteMgr.findUtenteDTO(mail);
	}

	public void setCliente(UtenteDTO cliente) {
		this.cliente = cliente;
	}

	public String acquistaPacchetto() {
		 FacesContext context = FacesContext.getCurrentInstance();  
		try {
			pacchPerMgrBean.acquistaPacchPer(pacchPer.getIdPacchPer());
			context.addMessage(null, new FacesMessage("Conferma pacchetto acquistato con successo"));
			
		} catch (PacchettoScadutoException e) {
			 context.addMessage(null, new FacesMessage("Mi dispiace, il pacchetto non può più essere"
			 		+ "acquistato, poichè la data di pagamento è successiva alla data di ritorno dell'ultimo"
			 		+ "prodotto base che compone il pacchetto"));
		}
		return "/cliente/accountCliente?faces-redirect=true";
	}
	
	public String a(){
		return "/cliente/accountCliente?faces-redirect=true";
	}
	
	public PacchPerMgrLocal getPacchPerMgrBean() {
		return pacchPerMgrBean;
	}


	public void setPacchPerMgrBean(PacchPerMgrLocal pacchPerMgrBean) {
		this.pacchPerMgrBean = pacchPerMgrBean;
	}


	public ComposizPacchPerMgrLocal getCompPacchPerMgr() {
		return compPacchPerMgr;
	}


	public void setCompPacchPerMgr(ComposizPacchPerMgrLocal compPacchPerMgr) {
		this.compPacchPerMgr = compPacchPerMgr;
	}


	public ComposizPacchPredMgrLocal getCompPacchPredMgr() {
		return compPacchPredMgr;
	}


	public void setCompPacchPredMgr(ComposizPacchPredMgrLocal compPacchPredMgr) {
		this.compPacchPredMgr = compPacchPredMgr;
	}


	public UtenteMgrBeanLocal getUtenteMgr() {
		return utenteMgr;
	}


	public void setUtenteMgr(UtenteMgrBeanLocal utenteMgr) {
		this.utenteMgr = utenteMgr;
	}


	public MailerManagedBean getMailMgr() {
		return mailMgr;
	}


	public void setMailMgr(MailerManagedBean mailMgr) {
		this.mailMgr = mailMgr;
	}


	

	public void goToPaginaListaRegali(){}


	public String getMailAmicoRegali() {
		return mailAmicoRegali;
	}


	public void setMailAmicoRegali(String mailAmicoRegali) {
		this.mailAmicoRegali = mailAmicoRegali;
	}


	public String getMailAmicoInvito() {
		return mailAmicoInvito;
	}


	public void setMailAmicoInvito(String mailAmicoInvito) {
		this.mailAmicoInvito = mailAmicoInvito;
	}
	
}
