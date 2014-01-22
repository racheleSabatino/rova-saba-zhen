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
	
	private final String emailSubject = "Invito ad unirti ad un pacchetto vacanza ";
	private final String emailBody = "Ciao, \n Il tuo amico ti invita ad unirti a lui in un magnifico pacchetto"
			+ "vacanza, clicca sul link per visionarne tutti i dettagli";
	
	private boolean success;
	
	public MailerManagedBean() {
		success = false;
		receiverEmailID = new String();
	}
	
	//cambiare
	public void sendMessage() {
		mailerBean.sendMessage(receiverEmailID, emailSubject, emailBody, 10);
		success = getSuccess();
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
