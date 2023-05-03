package com.live_glow.util;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;
  
public class SendMail {
	
	
	

    public boolean send(String to,  String subject, String text) {
  
	 boolean flag = false;

    
     Properties properties = new Properties();
     properties.put("mail.smtp.auth", true);
     properties.put("mail.smtp.starttls.enable", true);
     properties.put("mail.smtp.port", "587");
     properties.put("mail.smtp.host", "smtp.gmail.com");

     String username = "sabsahihaiii";
     String password = "jnhmplqdbbrwochz";


     //session
     Session session = Session.getInstance(properties, new Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(username, password);
         }
     });

     try {

         Message message = new MimeMessage(session);
         message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
         message.setFrom(new InternetAddress("sabsahihaiii@gmail.com"));
         message.setSubject(subject);
         message.setText(text);
         Transport.send(message);
         flag = true;
     } catch (Exception e) {
         e.printStackTrace();
         
     }


     return flag;
}
}