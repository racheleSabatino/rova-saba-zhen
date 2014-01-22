package it.polimi.traveldreamsystem.SessionBeans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
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

	final String senderEmailID = "racheles1991@gmail.com";
    final String senderPassword = "rachele";
    final String emailSMTPserver = "smtp.gmail.com";
    final String emailServerPort = "465";

    String receiverEmailID = null;
    String emailSubject = null;
    String emailBody = null;
    
    boolean success;
    
 public class STMPAuthenticator  extends javax.mail.Authenticator {
    	
    	public PasswordAuthentication getPasswordAuthentication() {
    		return new PasswordAuthentication(senderEmailID, senderPassword);
    	}
    }
    
 	public MailerBean() {
 			success = false; 
 	}
 
 	@Asynchronous
    public void sendMessage(String receiverEmailID, String emailSubject, String emailBody, int idPacchPer) {
    	this.receiverEmailID=receiverEmailID;
    	this.emailSubject=emailSubject;
    	this.emailBody=emailBody;

    	Properties props = new Properties();
    	props.put("mail.smtp.user",senderEmailID);
    	props.put("mail.smtp.host", emailSMTPserver);
    	props.put("mail.smtp.port", emailServerPort);
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.socketFactory.port", emailServerPort);
    	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    	props.put("mail.smtp.socketFactory.fallback", "false");

    	Authenticator auth = new STMPAuthenticator();
    	try
    	{
    		Session session = Session.getInstance(props, auth);
    		MimeMessage msg = new MimeMessage(session);
    		DateFormat dateFormatter = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT);
    		Date timeStamp = new Date();
    		String body = "Messaggio inviato il " + dateFormatter + "\n" + emailBody ;
    		msg.setSentDate(timeStamp);
    		msg.setText(body);
    		msg.setSubject(emailSubject);
    		msg.setFrom(new InternetAddress(senderEmailID));
    		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailID));
    		Transport.send(msg);
    		success = true;
    	}
    	catch (Exception mex) {
    			mex.printStackTrace();
    			success = false;
    	}	
 	}
    	
    public boolean successInvio() {
    	return success;
    }
   
   
}
