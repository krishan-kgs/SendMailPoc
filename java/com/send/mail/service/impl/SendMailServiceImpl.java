package com.send.mail.service.impl;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.send.mail.model.Mail;
import com.send.mail.service.SendMailService;

/**
 *  
 *  @version     1.0, 04-Nov-2015
 *  @author Krishan
 */

@Service("sendMailService")
public class SendMailServiceImpl implements SendMailService{

	public Mail sendMail(Mail mail) {

		final String username = "pocexampless@gmail.com";
		final String password = "poc123456789";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("pocexampless@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(mail.getToAddr()));
			message.setSubject(mail.getSubject());
			message.setText(mail.getContent());

			Transport.send(message);

			System.out.println("Done");
			
			mail.setComment("Mail Sent Successfully!!");

		} catch (MessagingException e) {
			mail.setComment("Error in Sending Mail !!");
			throw new RuntimeException(e);
		}
		
		return mail;
	}

}
