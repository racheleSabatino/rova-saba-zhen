package it.polimi.traveldreamsystem.SessionBeans;



import it.polimi.traveldreamsystem.Entities.Utente;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Session Bean implementation class MailerBean
 */
@Stateless
@LocalBean
public class MailerBean implements MailerBeanLocal {

	@Resource(name = "mail/travelDreamSystemSession")
    private Session mailSession;
	
	private boolean success;
	
	public MailerBean() {
		success = false;
	}
	
    public boolean successInvio() {
    	return success;
    }

	@Override
	public void sendMessage(String receiverEmailID, String emailSubject, String emailBody) {
		try{
		
		// Create the message object
	     Message message = new MimeMessage(mailSession);

	     // Adjust the recipients. Here we have only one
	     // recipient. The recipient's address must be
	     // an object of the InternetAddress class.
	     message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmailID, true));

	     // Set the message's subject
	     message.setSubject(emailSubject);

	     // Insert the message's body
	     message.setText(emailBody);

	     // This is not mandatory, however, it is a good
	     // practice to indicate the software which
	     // constructed the message.
	     message.setHeader("X-Mailer", "My Mailer");

	     // Adjust the date of sending the message
	     Date timeStamp = new Date();
	     message.setSentDate(timeStamp);

	     // Use the 'send' static method of the Transport
	     // class to send the message
	     Transport.send(message);
		}
		catch(Exception mex) {
			mex.printStackTrace();
		}
	}
	
	
   
   
}
