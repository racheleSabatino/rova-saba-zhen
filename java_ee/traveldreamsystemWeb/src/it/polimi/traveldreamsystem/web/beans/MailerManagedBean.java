package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.MailerBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MailerManagedBean {

	@EJB
	private MailerBeanLocal mailerBean;
	
	@EJB
	private UtenteMgrBeanLocal utenteMgr;
	
	private String receiverEmailID;
	
	private String senderMailID;
	
	private final String emailSubject = "Invito ad unirti ad un pacchetto vacanza ";
	
	private String emailBody;

	
	public MailerManagedBean() {
		receiverEmailID = new String();
	}
	
	public String getSenderMailID() {
		return senderMailID;
	}

	public void setSenderMailID(String senderMailID) {
		this.senderMailID = senderMailID;
	}

	public void setReceiverEmailID(String receiverEmailID) {
		this.receiverEmailID = receiverEmailID;
	}
	
	//cambiare
	public String sendMessage() {
		senderMailID = utenteMgr.getPrincipalEmail();
		
		String link = "http://localhost:8080/traveldreamsystemWeb/homePage.xhtml";
		this.emailBody = "Ciao, \n Il tuo amico " + senderMailID + " ti invita ad unirti a lui in" 
				+ " un magnifico pacchetto vacanza, clicca sul link per visionarne tutti i dettagli"
				+ "\n" + link;
		mailerBean.sendMessage(receiverEmailID, emailSubject, emailBody);
		return "/homePage?faces-redirect=true";
	}

	
	public String getReceiverEmailID(){
		return receiverEmailID;
	}
	
	public boolean getSuccess(){
		return mailerBean.successInvio();
	}
}
