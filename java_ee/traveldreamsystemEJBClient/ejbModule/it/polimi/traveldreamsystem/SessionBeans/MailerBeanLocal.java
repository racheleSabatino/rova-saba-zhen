package it.polimi.traveldreamsystem.SessionBeans;

import javax.ejb.Local;

@Local
public interface MailerBeanLocal {
	
	boolean successInvio();

	void sendMessage(String receiverEmailID,
			String emailSubject, String emailBody);

}
