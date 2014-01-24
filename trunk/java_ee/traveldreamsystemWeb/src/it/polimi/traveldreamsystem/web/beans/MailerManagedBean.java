package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.MailerBeanLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MailerManagedBean {

	@EJB
	private MailerBeanLocal mailerBean;
	
	private String receiverEmailID;
	
	private String senderMailID;
	
	private final String emailSubject = "Invito ad unirti ad un pacchetto vacanza ";
	
	private final String emailBody = "Ciao, \n Il tuo amico ti invita ad unirti a lui in un magnifico pacchetto"
			+ "vacanza, clicca sul link per visionarne tutti i dettagli";
	
	private boolean success;
	
	
	public MailerManagedBean() {
		success = false;
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
		mailerBean.sendMessage(senderMailID, receiverEmailID, emailSubject, emailBody, 10);
		success = getSuccess();
		return "/homePage?faces-redirect=true";
	}

	public void setReceiverMail(String receiverMail){
		this.receiverEmailID = receiverMail;
	}
	
	public String getReceiverEmailID(){
		return receiverEmailID;
	}
	
	public boolean getSuccess(){
		return mailerBean.successInvio();
	}
}
