package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.MailerBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "recBean")
@RequestScoped
public class RecuperaPasswordBean {

	@EJB
	private MailerBeanLocal mailerBean;
	
	@EJB
	private UtenteMgrBeanLocal utenteMgr;
	
	private String receiverEmailID;
	
	private final String emailSubject = "Recupera password ";
	
	private String emailBody;


	
	public RecuperaPasswordBean() {
		emailBody= new String();
	}
	

	public void setReceiverEmailID(String receiverEmailID) {
		this.receiverEmailID = receiverEmailID;
	}
	
	//cambiare
	public String sendMessage() {
		try {
			UtenteDTO utente = utenteMgr.findUtenteDTO(receiverEmailID);
			utente.setPassword("pippo");
			String password = utente.getPassword();
			utenteMgr.update(utente);
			String nameUtente = utente.getNome();
			emailBody = "Ciao " + nameUtente + " ricevi questa mail perché hai dimenticato la tua password, qui di sotto "
				+ " è riportata una password temporanea \n" + password + 
				"\nEntra nel tuo account usando questa mail e poi cambiala usando la funzione Cambia Password " + 
				"\nSe la richiesta non è stata inviata da te, ignora questa mail.\n\n" +
				"\n\n\nGrazie e a presto, \nServizio Clienti Travel Dream" 
				+ "\nQuesta mail viene inviata automaticamente, le risposte a questo indirizzo non verranno lette";
			mailerBean.sendMessage(receiverEmailID, emailSubject, emailBody);
			return "/homePage?faces-redirect=true";
		}
		catch (Exception e) {
			return "mailInesistente?faces-redirect=true";
		}
	}

	
	public String getReceiverEmailID(){
		return receiverEmailID;
	}
	
}
