/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.email;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author rolando
 */
public class Email {
    private String fromUser = ""; //uso de archivos de propiedads
    private String passwordFrom="";  //uso de archivos de propiedades
    private Properties props;
    private final Session session;
    
    
    public Email()
    {
        props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(fromUser, passwordFrom);
                    }
                }); 
    }
    public void unicast(String toMail, String subject, String contentMail)
    {
        try
        {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromUser));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
            msg.setSubject(subject);
            msg.setText(contentMail);
        }catch(MessagingException e)
        {
            throw new RuntimeException(e); //personalizar excepcion
        }
    }
    public void broadcast(ArrayList<String> destinos, String subject, String contentMail)
    {
        try
        {
           Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromUser));
            Address [] toMails = new Address[destinos.size()];
            for(int i=0; i<toMails.length;i++)
            {
                toMails[i]= new InternetAddress(destinos.get(i));
            }
            msg.setRecipients(Message.RecipientType.TO, toMails);
            msg.setSubject(subject);
            msg.setText(contentMail); 
        }catch(MessagingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
