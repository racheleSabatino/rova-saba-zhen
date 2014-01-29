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
	
	public void sendMessage(String receiverEmailID, String emailSubject, String emailBody) {
		mailerBean.sendMessage(receiverEmailID, emailSubject, emailBody);
	}

}
